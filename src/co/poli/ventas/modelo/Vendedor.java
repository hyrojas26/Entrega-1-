package co.poli.ventas.modelo;

/**
 * Representa un vendedor de la compañía.
 * <p>
 * Un vendedor se identifica de forma única por la combinación de su tipo
 * y número de documento, y tiene además nombres y apellidos.
 *
 * @author Grupo XX
 * @version 1.0
 */
public class Vendedor {

    /** Tipo de documento del vendedor (por ejemplo "CC", "CE", "TI"). */
    private String tipoDocumento;

    /** Número de documento del vendedor. */
    private long numeroDocumento;

    /** Nombres del vendedor. */
    private String nombres;

    /** Apellidos del vendedor. */
    private String apellidos;

    /**
     * Crea un nuevo vendedor con la información recibida.
     *
     * @param tipoDocumento   tipo de documento del vendedor.
     * @param numeroDocumento número de documento del vendedor.
     * @param nombres         nombres del vendedor.
     * @param apellidos       apellidos del vendedor.
     */
    public Vendedor(String tipoDocumento, long numeroDocumento, String nombres, String apellidos) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    /**
     * Retorna el tipo de documento del vendedor.
     *
     * @return el tipo de documento.
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Retorna el número de documento del vendedor.
     *
     * @return el número de documento.
     */
    public long getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Retorna los nombres del vendedor.
     *
     * @return los nombres del vendedor.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Retorna los apellidos del vendedor.
     *
     * @return los apellidos del vendedor.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Retorna el nombre completo (nombres + apellidos) del vendedor.
     *
     * @return el nombre completo.
     */
    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    /**
     * Retorna la llave única que identifica al vendedor, formada por la
     * combinación de su tipo y número de documento. Esta llave se usa para
     * relacionar los archivos de ventas con el vendedor correspondiente,
     * sin importar en cuántos archivos estén repartidas sus ventas.
     *
     * @return la llave única del vendedor, en formato {@code tipoDocumento;numeroDocumento}.
     */
    public String getLlave() {
        return tipoDocumento + ";" + numeroDocumento;
    }
}
