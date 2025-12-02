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
import javax.swing.*;
import java.awt.*;

public class EditarProductoFrame extends JFrame {

    private JTextField txtId, txtNombre, txtCantidad, txtPrecio, txtCategoria;
    private JTextField txtLimitePedir, txtLimiteAceptable;
    private JButton btnGuardar, btnCancelar;

    private Producto producto;
    private InventarioFrame inventarioFrame;

    public EditarProductoFrame(InventarioFrame inventarioFrame, Producto producto) {
        this.producto = producto;
        this.inventarioFrame = inventarioFrame;

        setTitle("Editar Producto");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(9, 2, 5, 5));

        // Campos
        add(new JLabel("ID:"));
        txtId = new JTextField(producto.getId());
        add(txtId);

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField(producto.getNombre());
        add(txtNombre);

        add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField(String.valueOf(producto.getCantidad()));
        add(txtCantidad);

        add(new JLabel("Precio:"));
        txtPrecio = new JTextField(String.valueOf(producto.getPrecio()));
        add(txtPrecio);

        add(new JLabel("Categoría:"));
        txtCategoria = new JTextField(producto.getCategoria());
        add(txtCategoria);

        add(new JLabel("Límite 'Conseguir más':"));
        txtLimitePedir = new JTextField(String.valueOf(producto.getLimitePedir()));
        add(txtLimitePedir);

        add(new JLabel("Límite 'Aceptable':"));
        txtLimiteAceptable = new JTextField(String.valueOf(producto.getLimiteAceptable()));
        add(txtLimiteAceptable);

        btnGuardar = new JButton("Guardar Cambios");
        btnCancelar = new JButton("Cancelar");

        add(btnGuardar);
        add(btnCancelar);

        btnGuardar.addActionListener(e -> guardarCambios());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void guardarCambios() {
        try {
            String id = txtId.getText().trim();
            String nombre = txtNombre.getText().trim();
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            String categoria = txtCategoria.getText().trim();
            int limitePedir = Integer.parseInt(txtLimitePedir.getText().trim());
            int limiteAceptable = Integer.parseInt(txtLimiteAceptable.getText().trim());

            // Actualizar objeto existente
            producto.setId(id);
            producto.setNombre(nombre);
            producto.setCantidad(cantidad);
            producto.setPrecio(precio);
            producto.setCategoria(categoria);
            producto.setLimitePedir(limitePedir);
            producto.setLimiteAceptable(limiteAceptable);

            // Actualizar tabla
            inventarioFrame.actualizarTabla();

            JOptionPane.showMessageDialog(this,
                    "Producto actualizado correctamente");

            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Valores numéricos inválidos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
