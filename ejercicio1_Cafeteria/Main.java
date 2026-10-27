/**
 * Problema: Cafetería UAM (colas de alumnos y trabajadores)
 * Autor: Pedro Garcia Mata
 * Grupo: GTID244
 * Fecha: 26/10/2026
 * Descripción: Atiende primero a trabajadores y luego a alumnos usando dos ListaSimple.
 */
import java.io.*;
import java.util.StringTokenizer;

/** Programa principal del problema de la cafetería. */
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
     * Procesa los N eventos e imprime los nombres de las personas atendidas.
     *
     * @param args no se utilizan
     * @throws IOException si falla la lectura
     */
    public static void main(String[] args) throws IOException {
        lector = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(siguienteToken());

        ListaSimple<String> colaAlumnos = new ListaSimple<>();
        ListaSimple<String> colaTrabajadores = new ListaSimple<>();
        StringBuilder salida = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String evento = siguienteToken();
            if (evento.equals("LLEGA")) {
                String tipo = siguienteToken();
                String nombre = siguienteToken();
                if (tipo.equals("ALUMNO")) {
                    colaAlumnos.insertarAlFinal(nombre);
                } else {
                    colaTrabajadores.insertarAlFinal(nombre);
                }
            } else {
                // ATIENDE: los trabajadores tienen preferencia
                String atendido = !colaTrabajadores.estaVacia()
                        ? colaTrabajadores.eliminarAlInicio()
                        : colaAlumnos.eliminarAlInicio();
                salida.append(atendido).append('\n');
            }
        }
        System.out.print(salida);
    }
}
