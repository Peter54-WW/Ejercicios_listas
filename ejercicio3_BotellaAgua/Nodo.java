/**
 * Problema: Botella de agua más barata
 * Autor: Pedro Garcia Mata
 * Grupo: GTID244
 * Fecha: 26/10/2026
 * Descripción: Nodo de lista simple de enteros.
 */
/** Nodo de una lista enlazada simple que guarda un precio entero. */
public class Nodo {
    /** Precio almacenado. */
    int dato;
    /** Siguiente nodo (null si es el último). */
    Nodo siguiente;

    /**
     * Crea un nodo sin siguiente.
     *
     * @param dato precio que guardará el nodo
     */
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
