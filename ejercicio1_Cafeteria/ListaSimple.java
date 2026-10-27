/**
 * Problema: Cafetería UAM (colas de alumnos y trabajadores)
 * Autor: Pedro Garcia Mata
 * Grupo: GTID244
 * Fecha: 26/10/2026
 * Descripción: Lista simple con puntero a cabeza y cola, usada como cola (FIFO).
 */
/**
 * Lista enlazada simple con referencias a la cabeza y a la cola, de modo que
 * insertar al final y eliminar al inicio son operaciones O(1).
 *
 * @param <T> tipo de dato almacenado
 */
public class ListaSimple<T> {
    /** Primer nodo de la lista. */
    private Nodo<T> cabeza;
    /** Último nodo de la lista. */
    private Nodo<T> cola;

    /** Crea una lista vacía. */
    public ListaSimple() {
        cabeza = null;
        cola = null;
    }

    /**
     * Indica si la lista está vacía.
     *
     * @return true si no tiene elementos
     */
    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * Inserta un elemento al final de la lista.
     *
     * @param dato valor a insertar
     */
    public void insertarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            // Lista vacía: el nuevo nodo es cabeza y cola a la vez
            cabeza = nuevo;
            cola = nuevo;
        } else {
            // El último nodo apunta al nuevo y la cola avanza
            cola.siguiente = nuevo;
            cola = nuevo;
        }
    }

    /**
     * Elimina y devuelve el primer elemento de la lista.
     *
     * @return el dato del primer nodo, o null si la lista está vacía
     */
    public T eliminarAlInicio() {
        if (cabeza == null) return null;
        T dato = cabeza.dato;
        // La cabeza avanza al siguiente nodo
        cabeza = cabeza.siguiente;
        if (cabeza == null) {
            // La lista quedó vacía: también se limpia la cola
            cola = null;
        }
        return dato;
    }
}
