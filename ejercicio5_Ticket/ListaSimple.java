/**
 * Problema: Ticket de compras ordenado por precio
 * Autor: Pedro Garcia Mata
 * Grupo: GTID244
 * Fecha: 26/10/2026
 * Descripción: Lista simple con inserción ordenada.
 */
import java.util.Comparator;

/**
 * Lista enlazada simple que mantiene sus elementos ordenados mediante
 * inserción ordenada (insertion sort sobre la propia lista).
 *
 * @param <T> tipo de dato almacenado
 */
public class ListaSimple<T> {
    /** Primer nodo de la lista. */
    private Nodo<T> cabeza;

    /** Crea una lista vacía. */
    public ListaSimple() {
        cabeza = null;
    }

    /**
     * Devuelve el primer nodo para poder recorrer la lista.
     *
     * @return la cabeza de la lista (null si está vacía)
     */
    public Nodo<T> obtenerCabeza() {
        return cabeza;
    }

    /**
     * Inserta un elemento en la posición que mantiene el orden dado por el
     * comparador. Ante empates, el nuevo queda después de los existentes.
     *
     * @param dato valor a insertar
     * @param cmp  comparador que define el orden de la lista
     */
    public void insertarOrdenado(T dato, Comparator<T> cmp) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null || cmp.compare(dato, cabeza.dato) < 0) {
            // Va al inicio: el nuevo apunta a la antigua cabeza
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            // Se busca el nodo previo a la posición de inserción
            Nodo<T> previo = cabeza;
            while (previo.siguiente != null && cmp.compare(dato, previo.siguiente.dato) >= 0) {
                previo = previo.siguiente;
            }
            // Se enlaza el nuevo entre 'previo' y su siguiente
            nuevo.siguiente = previo.siguiente;
            previo.siguiente = nuevo;
        }
    }
}
