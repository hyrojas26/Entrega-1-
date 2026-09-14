# Entrega 1 — Semana 3

Proyecto de Eclipse listo para importar (`File > Import > Existing Projects into Workspace`).

## Contenido

- `co.poli.ventas.modelo.Producto` — clase modelo de un producto.
- `co.poli.ventas.modelo.Vendedor` — clase modelo de un vendedor.
- `co.poli.ventas.generador.GenerateInfoFiles` — **única clase con método `main`**
  de esta entrega. Al ejecutarla genera, dentro de una carpeta `datos/`:
  - `vendedores.txt`
  - `productos.txt`
  - un archivo `ventas_vendedorN_<id>.txt` por cada vendedor generado.

## Cómo ejecutar

1. Importar el proyecto en Eclipse para Java Developers (JRE 1.8).
2. Ejecutar `GenerateInfoFiles` como aplicación Java.
3. Revisar la carpeta `datos/` que se crea en la raíz del proyecto.

## Pendiente para las siguientes entregas

- Clase `main` (paquete `co.poli.ventas.procesador`) que lea estos archivos
  y genere los dos reportes (vendedores por recaudo y productos por cantidad
  vendida).
- Elementos extra: soportar varios archivos de ventas por vendedor, trabajar
  con archivos serializados, y detectar archivos con formato erróneo o
  información incoherente.

## Personalizar

Reemplazar "Grupo XX" en el `@author` de cada clase por los nombres reales
del grupo antes de entregar.
