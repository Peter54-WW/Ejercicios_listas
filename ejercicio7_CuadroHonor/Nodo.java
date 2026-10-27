/**
 * Problema: Cuadro de honor
 * Autor: Pedro Garcia Mata
 * Grupo: GTID244
 * Fecha: 26/10/2026
 * Descripción: Nodo genérico de lista doble.
 */
/**
 * Nodo de una lista doblemente enlazada.
 *
 * @param <T> tipo de dato almacenado
 */
public class Nodo<T> {
    /** Dato almacenado. */
    T dato;
    /** Nodo siguiente (null si es el último). */
    Nodo<T> siguiente;
    /** Nodo anterior (null si es el primero). */
    Nodo<T> anterior;

    /**
     * Crea un nodo sin vecinos.
     *
     * @param dato valor que guardará el nodo
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
