/**
 * Problema: Ticket de compras ordenado por precio
 * Autor: Pedro Garcia Mata
 * Grupo: GTID244
 * Fecha: 26/10/2026
 * Descripción: Producto con nombre y precio exacto.
 */
import java.math.BigDecimal;

/** Producto comprado: nombre y precio (BigDecimal para evitar errores de redondeo). */
public class Producto {
    /** Nombre del producto. */
    final String nombre;
    /** Precio del producto. */
    final BigDecimal precio;

    /**
     * Crea un producto.
     *
     * @param nombre nombre del producto
     * @param precio precio del producto
     */
    public Producto(String nombre, BigDecimal precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
