/**
 * Problema: Botella de agua más barata
 * Autor: Pedro Garcia Mata
 * Grupo: GTID244
 * Fecha: 26/10/2026
 * Descripción: Lee N precios en una ListaSimple e imprime el menor.
 */
import java.io.*;
import java.util.StringTokenizer;

/** Programa principal del problema de la botella de agua. */
public class Main {
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
     * Lee los precios, los guarda en la lista y muestra el menor.
     *
     * @param args no se utilizan
     * @throws IOException si falla la lectura
     */
    public static void main(String[] args) throws IOException {
        lector = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(siguienteToken());
        ListaSimple precios = new ListaSimple();
        for (int i = 0; i < n; i++) {
            precios.insertarAlFinal(Integer.parseInt(siguienteToken()));
        }
        System.out.println(precios.obtenerMenor());
    }
}
