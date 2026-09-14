package co.poli.ventas.modelo;

/**
 * Representa un producto disponible para la venta dentro del sistema.
 * <p>
 * Un producto está identificado por un código único ({@code id}), tiene
 * un nombre descriptivo y un precio de venta por unidad.
 *
 * @author Grupo XX
 * @version 1.0
 */
public class Producto {

    /** Identificador único del producto (por ejemplo "P01"). */
    private String id;

    /** Nombre comercial del producto. */
    private String nombre;

    /** Precio de venta de una unidad del producto. */
    private double precioPorUnidad;

    /**
     * Crea un nuevo producto con la información recibida.
     *
     * @param id              identificador único del producto.
     * @param nombre          nombre comercial del producto.
     * @param precioPorUnidad precio de venta de una unidad.
     */
    public Producto(String id, String nombre, double precioPorUnidad) {
        this.id = id;
        this.nombre = nombre;
        this.precioPorUnidad = precioPorUnidad;
    }

    /**
     * Retorna el identificador único del producto.
     *
     * @return el id del producto.
     */
    public String getId() {
        return id;
    }

    /**
     * Retorna el nombre comercial del producto.
     *
     * @return el nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el precio de venta de una unidad del producto.
     *
     * @return el precio por unidad.
     */
    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    /**
     * Representación en línea de texto plano del producto, en el formato
     * usado por el archivo de productos: {@code id;nombre;precio}.
     *
     * @return la línea de texto correspondiente a este producto.
     */
    @Override
    public String toString() {
        return id + ";" + nombre + ";" + precioPorUnidad;
    }
}
