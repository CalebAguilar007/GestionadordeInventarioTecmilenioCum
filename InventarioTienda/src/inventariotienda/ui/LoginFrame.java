/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author jos9
 */
package inventariotienda.ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("Login - Inventario");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Muestra la palabra Usuario
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Usuario:"), gbc);

        // Caja para introducir Usuario
        txtUsuario = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtUsuario, gbc);

        // Muestra la palabra contrasena
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Contrasena:"), gbc);

        // Caja para introducir contrasena
        txtContrasena = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtContrasena, gbc);

        // Boton para iniciar la sesion
        btnLogin = new JButton("Iniciar sesion");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(btnLogin, gbc);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarLogin();
            }
        });
    }

    private void validarLogin() {
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());

        if (usuario.equals("Usuario1") && contrasena.equals("Tienda246")) {
            JOptionPane.showMessageDialog(this, "Acceso concedido");
            
            // Esto abre el menu principal
            new MenuPrincipal().setVisible(true);
            this.dispose(); // Cierra el login
        } else {
            JOptionPane.showMessageDialog(this,
                    "Usuario o contraseña incorrectos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
