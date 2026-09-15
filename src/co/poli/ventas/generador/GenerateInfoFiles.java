package co.poli.ventas.generador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Clase con método {@code main} encargada de generar, de forma
 * pseudoaleatoria, los archivos planos que sirven como entrada para el
 * programa principal del proyecto.
 * <p>
 * Genera tres tipos de archivo dentro de la carpeta {@code datos}:
 * <ul>
 *   <li>Un archivo de ventas por cada vendedor.</li>
 *   <li>Un único archivo con la información de todos los vendedores.</li>
 *   <li>Un único archivo con la información de todos los productos.</li>
 * </ul>
 * Corresponde a la Entrega 1 del proyecto grupal del módulo "Conceptos
 * Fundamentales de Programación".
 *
 * @author Grupo XX
 * @version 1.0
 */
public class GenerateInfoFiles {

    /** Generador de números pseudoaleatorios reutilizado por toda la clase. */
    private static final Random RANDOM = new Random();

    /** Nombres reales usados para generar vendedores coherentes. */
    private static final String[] NOMBRES = {
            "Carlos", "Maria", "Andres", "Laura", "Juan", "Camila", "Diego",
            "Valentina", "Santiago", "Sofia", "Felipe", "Daniela", "Miguel",
            "Paula", "Alejandro", "Natalia", "Ricardo", "Carolina", "Jorge", "Isabella"
    };

    /** Apellidos reales usados para generar vendedores coherentes. */
    private static final String[] APELLIDOS = {
            "Gomez", "Rodriguez", "Martinez", "Lopez", "Garcia", "Perez",
            "Sanchez", "Ramirez", "Torres", "Flores", "Rivera", "Diaz",
            "Castro", "Ortiz", "Morales", "Vargas", "Suarez", "Rojas", "Herrera", "Mendoza"
    };

    /** Nombres base usados para generar productos coherentes. */
    private static final String[] NOMBRES_PRODUCTO = {
            "Cuaderno", "Lapiz", "Esfero", "Marcador", "Borrador", "Regla",
            "Tijeras", "Pegante", "Carpeta", "Resaltador", "Calculadora",
            "Mochila", "Agenda", "Corrector", "Tajalapiz", "Colores",
            "Grapadora", "Perforadora", "Sobre de manila", "Block de hojas"
    };

    /** Tipos de documento válidos usados para los datos generados. */
    private static final String[] TIPOS_DOCUMENTO = {"CC", "CE", "TI"};

    /** Carpeta donde se dejan todos los archivos generados. */
    private static final String CARPETA_DATOS = "datos";

    /**
     * Punto de entrada del generador de archivos. Crea la carpeta de datos
     * (si no existe) y genera el archivo de vendedores, el de productos y
     * un archivo de ventas por cada vendedor.
     * <p>
     * No solicita ninguna información al usuario.
     *
     * @param args argumentos de línea de comandos (no se usan).
     */
    public static void main(String[] args) {
        int cantidadVendedores = 5;
        int cantidadProductos = 12;

        try {
            crearCarpetaDatos();
            createSalesManInfoFile(cantidadVendedores);
            createProductsFile(cantidadProductos);

            for (int i = 1; i <= cantidadVendedores; i++) {
                long idVendedor = 1000000000L + i;
                int cantidadVentas = 5 + RANDOM.nextInt(10);
                createSalesMenFile(cantidadVentas, "vendedor" + i, idVendedor);
            }

            System.out.println("Generacion de archivos completada exitosamente. "
                    + "Los archivos quedaron en la carpeta '" + CARPETA_DATOS + "'.");
        } catch (IOException e) {
            System.out.println("Error al generar los archivos: " + e.getMessage());
        }
    }

    /**
     * Crea la carpeta donde se almacenan todos los archivos generados, en
     * caso de que todavía no exista.
     */
    private static void crearCarpetaDatos() {
        File carpeta = new File(CARPETA_DATOS);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }

    /**
     * Genera un archivo de ventas pseudoaleatorio para un único vendedor.
     * <p>
     * La primera línea del archivo tiene el tipo y número de documento del
     * vendedor; cada línea siguiente representa una venta, con el id del
     * producto vendido y la cantidad vendida.
     *
     * @param randomSalesCount cantidad de ventas (líneas) a generar.
     * @param name             nombre base usado para construir el nombre del archivo.
     * @param id               número de documento del vendedor dueño de las ventas.
     * @throws IOException si ocurre un error al escribir el archivo.
     */
    public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
        crearCarpetaDatos();
        String tipoDocumento = TIPOS_DOCUMENTO[RANDOM.nextInt(TIPOS_DOCUMENTO.length)];
        String rutaArchivo = CARPETA_DATOS + File.separator + "ventas_" + name + "_" + id + ".txt";

        try (FileWriter escritor = new FileWriter(rutaArchivo)) {
            escritor.write(tipoDocumento + ";" + id + "\n");
            for (int i = 0; i < randomSalesCount; i++) {
                String idProducto = "P" + String.format("%02d", 1 + RANDOM.nextInt(20));
                int cantidadVendida = 1 + RANDOM.nextInt(15);
                escritor.write(idProducto + ";" + cantidadVendida + ";\n");
            }
        }
    }

    /**
     * Genera el archivo con la información pseudoaleatoria de todos los
     * productos disponibles, uno por línea, en el formato
     * {@code id;nombre;precioPorUnidad}.
     *
     * @param productsCount cantidad de productos a generar.
     * @throws IOException si ocurre un error al escribir el archivo.
     */
    public static void createProductsFile(int productsCount) throws IOException {
        crearCarpetaDatos();
        String rutaArchivo = CARPETA_DATOS + File.separator + "productos.txt";

        try (FileWriter escritor = new FileWriter(rutaArchivo)) {
            for (int i = 1; i <= productsCount; i++) {
                String idProducto = "P" + String.format("%02d", i);
                String nombreBase = NOMBRES_PRODUCTO[RANDOM.nextInt(NOMBRES_PRODUCTO.length)];
                String nombreProducto = nombreBase + " " + i;
                double precio = 1000 + RANDOM.nextInt(50) * 500;
                escritor.write(idProducto + ";" + nombreProducto + ";" + precio + "\n");
            }
        }
    }

    /**
     * Genera el archivo con la información pseudoaleatoria de todos los
     * vendedores, uno por línea, en el formato
     * {@code tipoDocumento;numeroDocumento;nombres;apellidos}.
     * <p>
     * Los nombres y apellidos se toman de listas de nombres reales de
     * personas, tal como lo pide el enunciado.
     *
     * @param salesmanCount cantidad de vendedores a generar.
     * @throws IOException si ocurre un error al escribir el archivo.
     */
    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
        crearCarpetaDatos();
        String rutaArchivo = CARPETA_DATOS + File.separator + "vendedores.txt";

        try (FileWriter escritor = new FileWriter(rutaArchivo)) {
            for (int i = 1; i <= salesmanCount; i++) {
                String tipoDocumento = TIPOS_DOCUMENTO[RANDOM.nextInt(TIPOS_DOCUMENTO.length)];
                long numeroDocumento = 1000000000L + i;
                String nombres = NOMBRES[RANDOM.nextInt(NOMBRES.length)];
                String apellidos = APELLIDOS[RANDOM.nextInt(APELLIDOS.length)];
                escritor.write(tipoDocumento + ";" + numeroDocumento + ";" + nombres + ";" + apellidos + "\n");
            }
        }
    }
}
