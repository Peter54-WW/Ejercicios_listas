/**
 * Problema: Ticket de compras ordenado por precio
 * Autor: Pedro Garcia Mata
 * Grupo: GTID244
 * Fecha: 26/10/2026
 * Descripción: Nodo genérico de lista simple.
 */
/**
 * Nodo de una lista enlazada simple.
 *
 * @param <T> tipo de dato almacenado
 */
public class Nodo<T> {
    /** Dato almacenado. */
    T dato;
    /** Siguiente nodo (null si es el último). */
    Nodo<T> siguiente;

    /**
     * Crea un nodo sin siguiente.
     *
     * @param dato valor que guardará el nodo
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
