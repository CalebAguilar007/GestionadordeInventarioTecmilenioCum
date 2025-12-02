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
import java.awt.*;

public class AgregarProductoFrame extends JFrame {

    private JTextField txtId, txtNombre, txtCantidad, txtPrecio, txtCategoria;
    private JTextField txtLimitePedir, txtLimiteAceptable;
    private JButton btnGuardar, btnCancelar;

    private InventarioFrame inventarioFrame;

    public AgregarProductoFrame(InventarioFrame inventarioFrame) {

        this.inventarioFrame = inventarioFrame;

        setTitle("Agregar Producto");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(9, 2, 5, 5));

        add(new JLabel("ID:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        add(txtCantidad);

        add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        add(txtPrecio);

        add(new JLabel("Categoría:"));
        txtCategoria = new JTextField();
        add(txtCategoria);

        add(new JLabel("Límite 'Conseguir más':"));
        txtLimitePedir = new JTextField();
        add(txtLimitePedir);

        add(new JLabel("Límite 'Aceptable':"));
        txtLimiteAceptable = new JTextField();
        add(txtLimiteAceptable);

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        add(btnGuardar);
        add(btnCancelar);

        btnGuardar.addActionListener(e -> guardarProducto());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void guardarProducto() {
        try {
            if (txtId.getText().trim().isEmpty() ||
                    txtNombre.getText().trim().isEmpty() ||
                    txtCantidad.getText().trim().isEmpty() ||
                    txtPrecio.getText().trim().isEmpty() ||
                    txtCategoria.getText().trim().isEmpty() ||
                    txtLimitePedir.getText().trim().isEmpty() ||
                    txtLimiteAceptable.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Todos los campos deben ser llenados",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int cantidad = Integer.parseInt(txtCantidad.getText());
            double precio = Double.parseDouble(txtPrecio.getText());
            int limitePedir = Integer.parseInt(txtLimitePedir.getText());
            int limiteAceptable = Integer.parseInt(txtLimiteAceptable.getText());

            Producto producto = new Producto(
                    txtId.getText(),
                    txtNombre.getText(),
                    cantidad,
                    precio,
                    txtCategoria.getText(),
                    limitePedir,
                    limiteAceptable
            );

            // --- conexión correcta ---
            Inventario.agregarProducto(producto);
            inventarioFrame.actualizarTabla();
            // ---------------------------

            JOptionPane.showMessageDialog(this,
                    "Producto guardado correctamente");

            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Cantidad, precio y límites deben ser numéricos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
