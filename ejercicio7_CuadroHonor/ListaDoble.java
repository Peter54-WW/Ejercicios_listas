/**
 * Problema: Cuadro de honor
 * Autor: Pedro Garcia Mata
 * Grupo: GTID244
 * Fecha: 26/10/2026
 * Descripción: Lista doblemente enlazada con inserción ordenada.
 */
import java.util.Comparator;

/**
 * Lista doblemente enlazada que mantiene sus elementos ordenados.
 *
 * @param <T> tipo de dato almacenado
 */
public class ListaDoble<T> {
    /** Primer nodo. */
    private Nodo<T> cabeza;
    /** Último nodo. */
    private Nodo<T> cola;

    /** Crea una lista vacía. */
    public ListaDoble() {
        cabeza = null;
        cola = null;
    }

    /**
     * Devuelve el primer nodo para recorrer la lista hacia adelante.
     *
     * @return la cabeza (null si está vacía)
     */
    public Nodo<T> obtenerCabeza() {
        return cabeza;
    }

    /**
     * Inserta un elemento manteniendo el orden dado por el comparador.
     * Ante empates, el nuevo queda después de los existentes.
     *
     * @param dato valor a insertar
     * @param cmp  comparador que define el orden
     */
    public void insertarOrdenado(T dato, Comparator<T> cmp) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            // Lista vacía: es cabeza y cola
            cabeza = nuevo;
            cola = nuevo;
            return;
        }
        // Se busca el primer nodo que debe quedar DESPUÉS del nuevo
        Nodo<T> actual = cabeza;
        while (actual != null && cmp.compare(dato, actual.dato) >= 0) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            // Inserción al final: se enlaza con la cola actual
            nuevo.anterior = cola;
            cola.siguiente = nuevo;
            cola = nuevo;
        } else if (actual == cabeza) {
            // Inserción al inicio: la antigua cabeza apunta atrás al nuevo
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        } else {
            // Inserción en medio: se ajustan los 4 punteros
            nuevo.anterior = actual.anterior;
            nuevo.siguiente = actual;
            actual.anterior.siguiente = nuevo;
            actual.anterior = nuevo;
        }
    }
}
