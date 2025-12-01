/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author jos9
 */
package inventariotienda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventarioFrame extends JFrame {

    private JTable tablaInventario;
    private DefaultTableModel modeloTabla;

    private JButton btnAgregar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnActualizar;

    public InventarioFrame() {
        setTitle("Gestión de Inventario");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tabla mostrando informacion de los productos
        modeloTabla = new DefaultTableModel(
                new Object[]{
                    "ID", 
                    "Nombre", 
                    "Cantidad", 
                    "Precio", 
                    "Categoría",
                    "Estado" 
                }, 
                0
        );

        tablaInventario = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaInventario);
        add(scroll, BorderLayout.CENTER);

        //botones interactuables
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        btnAgregar = new JButton("Agregar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");
        btnActualizar = new JButton("Actualizar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnActualizar);

        add(panelBotones, BorderLayout.SOUTH);

        //datos de prueba
        agregarProductoDemo("1", "Pan Bimbo", 20, 32.50, "Abarrotes");
        agregarProductoDemo("2", "Coca-Cola 600ml", 3, 15.00, "Bebidas");

        // la interaccion con los botones
        btnAgregar.addActionListener(e -> JOptionPane.showMessageDialog(this, "en produccion"));
        btnEditar.addActionListener(e -> JOptionPane.showMessageDialog(this, "en produccion"));
        btnEliminar.addActionListener(e -> JOptionPane.showMessageDialog(this, "en produccion"));
        btnBuscar.addActionListener(e -> JOptionPane.showMessageDialog(this, "en produccion"));
        btnActualizar.addActionListener(e -> JOptionPane.showMessageDialog(this, "en produccion"));
    }

    private void agregarProductoDemo(String id, String nombre, int cantidad, double precio, String categoria) {
        // Valores Temporales de prueba para los estado
        int limitePedir = 5;
        int limiteAceptable = 10;

        String estado = calcularEstado(cantidad, limitePedir, limiteAceptable);

        modeloTabla.addRow(new Object[]{id, nombre, cantidad, precio, categoria, estado});
    }

    //Estos calcularan los limites del estado
    private String calcularEstado(int cantidad, int limitePedir, int limiteAceptable) {
        if (cantidad < limitePedir) {
            return "Conseguir más";
        } else if (cantidad < limiteAceptable) {
            return "Cantidad aceptable";
        } else {
            return "Buen estado";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InventarioFrame().setVisible(true);
        });
    }
}

