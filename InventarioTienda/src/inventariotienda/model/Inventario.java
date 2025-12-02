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

    private static ArrayList<Producto> lista = new ArrayList<>();

    public static void agregarProducto(Producto p) {
        lista.add(p);
    }

    public static ArrayList<Producto> getProductos() {
        return lista;
    }
}
