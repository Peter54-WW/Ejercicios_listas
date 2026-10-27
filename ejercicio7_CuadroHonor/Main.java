/**
 * Problema: Cuadro de honor
 * Autor: Pedro Garcia Mata
 * Grupo: GTID244
 * Fecha: 26/10/2026
 * Descripción: Filtra alumnos con promedio >= 9.5 y los ordena alfabéticamente con una ListaDoble.
 */
import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;

/** Programa principal del problema del cuadro de honor. */
public class Main {
    /** Promedio mínimo para entrar al cuadro de honor. */
    private static final BigDecimal MINIMO = new BigDecimal("9.5");

    /**
     * Lee la siguiente línea no vacía de la entrada.
     *
     * @param lector lector de entrada
     * @return la línea sin espacios en los extremos, o null si terminó la entrada
     * @throws IOException si falla la lectura
     */
    private static String siguienteLinea(BufferedReader lector) throws IOException {
        String linea;
        while ((linea = lector.readLine()) != null) {
            linea = linea.trim();
            if (!linea.isEmpty()) return linea;
        }
        return null;
    }

    /**
     * Lee los alumnos, guarda en la lista (ordenada) a quienes alcanzan el
     * cuadro de honor e imprime sus nombres.
     *
     * @param args no se utilizan
     * @throws IOException si falla la lectura
     */
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));
        PrintStream out = new PrintStream(System.out, false, "UTF-8");

        int n = Integer.parseInt(siguienteLinea(lector));

        // Orden alfabético (sin distinguir mayúsculas; desempata con orden normal)
        Comparator<String> alfabetico = (a, b) -> {
            int c = a.compareToIgnoreCase(b);
            return c != 0 ? c : a.compareTo(b);
        };

        ListaDoble<String> cuadro = new ListaDoble<>();
        for (int i = 0; i < n; i++) {
            String nombre = siguienteLinea(lector);
            BigDecimal promedio = new BigDecimal(siguienteLinea(lector));
            if (promedio.compareTo(MINIMO) >= 0) {
                cuadro.insertarOrdenado(nombre, alfabetico);
            }
        }

        StringBuilder salida = new StringBuilder();
        for (Nodo<String> actual = cuadro.obtenerCabeza(); actual != null; actual = actual.siguiente) {
            salida.append(actual.dato).append('\n');
        }
        out.print(salida);
        out.flush();
    }
}
