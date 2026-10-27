/**
 * Problema: Botella de agua más barata
 * Autor: Pedro Garcia Mata
 * Grupo: GTID244
 * Fecha: 26/10/2026
 * Descripción: Lista simple de precios con búsqueda del mínimo.
 */
/** Lista enlazada simple de enteros con referencia a cabeza y cola. */
public class ListaSimple {
    /** Primer nodo. */
    private Nodo cabeza;
    /** Último nodo. */
    private Nodo cola;

    /** Crea una lista vacía. */
    public ListaSimple() {
        cabeza = null;
        cola = null;
    }

    /**
     * Inserta un precio al final de la lista.
     *
     * @param dato precio a insertar
     */
    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            // El último nodo apunta al nuevo, luego la cola avanza
            cola.siguiente = nuevo;
            cola = nuevo;
        }
    }

    /**
     * Recorre la lista y obtiene el menor valor.
     *
     * @return el menor precio, o -1 si la lista está vacía
     */
    public int obtenerMenor() {
        if (cabeza == null) return -1;
        int menor = cabeza.dato;
        Nodo actual = cabeza.siguiente;
        while (actual != null) {
            if (actual.dato < menor) menor = actual.dato;
            // Se avanza al siguiente nodo
            actual = actual.siguiente;
        }
        return menor;
    }
}
