/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jos9
 */
package inventariotienda.model;

public class Producto {

    private String id;
    private String nombre;
    private int cantidad;
    private double precio;
    private String categoria;

    // los límites definidos por el usuario
    private int limitePedir;      // esto dira por ejemplo conseguir mas si es que es cierto numero
    private int limiteAceptable;  // cuando este en un cierto numero dira aceptable

    public Producto(String id, String nombre, int cantidad, double precio, String categoria,
                    int limitePedir, int limiteAceptable) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
        this.limitePedir = limitePedir;
        this.limiteAceptable = limiteAceptable;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getLimitePedir() { return limitePedir; }
    public void setLimitePedir(int limitePedir) { this.limitePedir = limitePedir; }

    public int getLimiteAceptable() { return limiteAceptable; }
    public void setLimiteAceptable(int limiteAceptable) { this.limiteAceptable = limiteAceptable; }

    // Esto revisara el estado del producto
    public String getEstado() {
        if (cantidad < limitePedir) {
            return "Conseguir más";
        } else if (cantidad < limiteAceptable) {
            return "Cantidad aceptable";
        } else {
            return "Buen estado";
        }
    }
}
