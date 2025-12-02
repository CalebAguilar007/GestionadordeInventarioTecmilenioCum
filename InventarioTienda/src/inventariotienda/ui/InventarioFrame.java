/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author jos9
 */
package inventariotienda.ui;

import inventariotienda.model.Producto;
import inventariotienda.model.Inventario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class InventarioFrame extends JFrame {

    private JTable tabla;
    private DefaultTableModel modeloTabla;

    private JButton btnAgregar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JButton btnMenuPrincipal;

    public InventarioFrame() {
        setTitle("Gestión de Inventario");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Crear la tabla ---
        String[] columnas = {"ID", "Nombre", "Cantidad", "Precio", "Categoria", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // esto es para que no puedan editar directamente 
            }
        };

        tabla = new JTable(modeloTabla);
        tabla.setAutoCreateRowSorter(true);

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // panel de botones
        JPanel panelBotones = new JPanel();

        btnAgregar = new JButton("Agregar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        btnActualizar = new JButton("Actualizar");
        btnMenuPrincipal = new JButton("Menu Principal");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnMenuPrincipal);

        add(panelBotones, BorderLayout.SOUTH);

        // Accion de botones
        btnAgregar.addActionListener(e -> abrirVentanaAgregar());
        btnEditar.addActionListener(e -> editarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());
        btnActualizar.addActionListener(e -> actualizarTabla());
        btnMenuPrincipal.addActionListener(e -> {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            dispose();
        });



        actualizarTabla();
    }

    // botones

    private void abrirVentanaAgregar() {
        AgregarProductoFrame ventana = new AgregarProductoFrame(this);
        ventana.setVisible(true);
    }

    private void editarProducto() {
        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para editar");
            return;
        }

        String id = tabla.getValueAt(fila, 0).toString();
        Producto p = Inventario.buscarProductoPorId(id);

        if (p == null) {
            JOptionPane.showMessageDialog(this, "producto no existe");
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Función de editar pendiente.");
    }

    private void eliminarProducto() {
        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un producto para eliminar");
            return;
        }

        String id = tabla.getValueAt(fila, 0).toString();

        Inventario.eliminarProducto(id);
        actualizarTabla();

        JOptionPane.showMessageDialog(this, "El Producto fue eliminado");
    }

    // Actualiza tabla

    public void actualizarTabla() {
        modeloTabla.setRowCount(0); 

        List<Producto> lista = Inventario.getProductos();

        for (Producto p : lista) {
            modeloTabla.addRow(new Object[]{
                    p.getId(),
                    p.getNombre(),
                    p.getCantidad(),
                    p.getPrecio(),
                    p.getCategoria(),
                    p.getEstado()
            });
        }
    }
}
