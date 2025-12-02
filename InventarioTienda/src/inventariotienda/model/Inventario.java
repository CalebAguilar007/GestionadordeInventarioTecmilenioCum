

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author jos9
 */
package inventariotienda.model;

import java.io.*;
import java.util.ArrayList;

public class Inventario {

    public static ArrayList<Producto> productos = new ArrayList<>();

    private static final String ARCHIVO = "inventario.txt";  // archivo local

    // =====================================================
    //   CARGAR DATOS DESDE ARCHIVO
    // =====================================================
    public static void cargarDesdeArchivo() {

        productos.clear(); // limpia para evitar duplicados

        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {
            System.out.println("No existe el archivo, se creará al guardar.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(";");

                if (partes.length != 7) continue;

                Producto p = new Producto(
                        partes[0],                    // id
                        partes[1],                    // nombre
                        Integer.parseInt(partes[2]),  // cantidad
                        Double.parseDouble(partes[3]),// precio
                        partes[4],                    // categoria
                        Integer.parseInt(partes[5]),  // limite pedir
                        Integer.parseInt(partes[6])   // limite aceptable
                );

                productos.add(p);
            }

            System.out.println("Inventario cargado desde archivo.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar inventario.");
        }
    }

    // =====================================================
    //   GUARDAR DATOS EN ARCHIVO
    // =====================================================
    public static void guardarEnArchivo() {

        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO))) {

            for (Producto p : productos) {
                pw.println(
                    p.getId() + ";" +
                    p.getNombre() + ";" +
                    p.getCantidad() + ";" +
                    p.getPrecio() + ";" +
                    p.getCategoria() + ";" +
                    p.getLimitePedir() + ";" +
                    p.getLimiteAceptable()
                );
            }

            System.out.println("Inventario guardado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar inventario.");
        }
    }

    // =====================================================
    //     CRUD (compatibles con tu código actual)
    // =====================================================

    public static void agregarProducto(Producto p) {
        productos.add(p);
        guardarEnArchivo(); // guarda automáticamente
    }

    public static Producto buscarProducto(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public static void actualizarProducto(Producto nuevo) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(nuevo.getId())) {
                productos.set(i, nuevo);
                guardarEnArchivo(); // guarda cambios
                return;
            }
        }
    }

    public static void eliminarProducto(String id) {
        productos.removeIf(p -> p.getId().equals(id));
        guardarEnArchivo();
    }

    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
