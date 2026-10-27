/**
 * Problema: Ticket de compras ordenado por precio
 * Autor: Pedro Garcia Mata
 * Grupo: GTID244
 * Fecha: 26/10/2026
 * Descripción: Ordena productos de mayor a menor precio con una ListaSimple e imprime el ticket.
 */
import java.io.*;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.StringTokenizer;

/** Programa principal del problema del ticket. */
public class Main {
    /** Cadena que separa las columnas del ticket. */
    private static final String SEPARADOR = "|";
    /** Lector de entrada con buffer. */
    private static BufferedReader lector;
    /** Tokens pendientes de la línea actual. */
    private static StringTokenizer tokens;

    /**
     * Devuelve el siguiente token de la entrada (sin importar los saltos de línea).
     *
     * @return el siguiente token, o null si la entrada terminó
     * @throws IOException si falla la lectura
     */
    private static String siguienteToken() throws IOException {
        while (tokens == null || !tokens.hasMoreTokens()) {
            String linea = lector.readLine();
            if (linea == null) return null;
            tokens = new StringTokenizer(linea);
        }
        return tokens.nextToken();
    }

    /**
     * Convierte un precio a texto sin ceros sobrantes (23.00 -> 23, 23.60 -> 23.6).
     *
     * @param valor precio a formatear
     * @return el precio como texto
     */
    private static String formatear(BigDecimal valor) {
        return valor.stripTrailingZeros().toPlainString();
    }

    /**
     * Lee los productos, los ordena de mayor a menor precio (empates por nombre)
     * e imprime el ticket con el total.
     *
     * @param args no se utilizan
     * @throws IOException si falla la lectura
     */
    public static void main(String[] args) throws IOException {
        lector = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(siguienteToken());

        // Mayor precio primero; si empatan, orden alfabético por nombre
        Comparator<Producto> orden = (a, b) -> {
            int c = b.precio.compareTo(a.precio);
            return c != 0 ? c : a.nombre.compareTo(b.nombre);
        };

        ListaSimple<Producto> lista = new ListaSimple<>();
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < n; i++) {
            String nombre = siguienteToken();
            BigDecimal precio = new BigDecimal(siguienteToken());
            lista.insertarOrdenado(new Producto(nombre, precio), orden);
            total = total.add(precio);
        }

        StringBuilder salida = new StringBuilder();
        int posicion = 1;
        for (Nodo<Producto> actual = lista.obtenerCabeza(); actual != null; actual = actual.siguiente) {
            salida.append(posicion++).append(SEPARADOR)
                  .append(actual.dato.nombre).append(SEPARADOR)
                  .append(formatear(actual.dato.precio)).append('\n');
        }
        salida.append(formatear(total)).append('\n');
        System.out.print(salida);
    }
}
