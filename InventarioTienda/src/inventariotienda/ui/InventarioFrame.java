/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author jos9
 */
package inventariotienda.ui;

import inventariotienda.model.Inventario;
import inventariotienda.model.Producto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventarioFrame extends JFrame {

    private JTable tablaProductos;
    private JButton btnAgregar, btnEditar, btnEliminar, btnActualizar;

    public InventarioFrame() {

        setTitle("Inventario de la Tienda");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // Tabla
        tablaProductos = new JTable();
        actualizarTabla();

        add(new JScrollPane(tablaProductos), BorderLayout.CENTER);

        // Botones
        JPanel panelBotones = new JPanel();

        btnAgregar = new JButton("Agregar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        btnActualizar = new JButton("Actualizar Tabla");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnActualizar);

        add(panelBotones, BorderLayout.SOUTH);

        // acciones
        btnAgregar.addActionListener(e -> abrirAgregarProducto());
        btnActualizar.addActionListener(e -> actualizarTabla());
    
    }

    private void abrirAgregarProducto() {
        new AgregarProductoFrame(this).setVisible(true);
    }

    // Actualiza la tabla
    public void actualizarTabla() {
        String[] columnas = {
            "ID", "Nombre", "Cantidad", "Precio",
            "Categoría", "Lim. Pedir", "Lim. Aceptable"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Producto p : Inventario.productos) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getCantidad(),
                p.getPrecio(),
                p.getCategoria(),
                p.getLimitePedir(),
                p.getLimiteAceptable()
            });
        }

        tablaProductos.setModel(modelo);
    }
}
