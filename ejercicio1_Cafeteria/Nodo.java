/**
 * Problema: Cafetería UAM (colas de alumnos y trabajadores)
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
    /** Dato almacenado en el nodo. */
    T dato;
    /** Referencia al siguiente nodo (null si es el último). */
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
