

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author jos9
 */
package inventariotienda.model;
import java.util.ArrayList;

public class Inventario {

    public static ArrayList<Producto> productos = new ArrayList<>();

    public static void agregarProducto(Producto p) {
        productos.add(p);
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
                return;
            }
        }
    }

    public static void eliminarProducto(String id) {
        productos.removeIf(p -> p.getId().equals(id));
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

