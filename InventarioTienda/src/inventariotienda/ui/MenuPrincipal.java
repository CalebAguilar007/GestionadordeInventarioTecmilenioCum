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

public class MenuPrincipal extends JFrame {

    private JButton btnInventario, btnSalir;

    public MenuPrincipal() {

        setTitle("Menú Principal");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(2, 1, 10, 10));

        btnInventario = new JButton("Inventario de Productos");
        btnSalir = new JButton("Salir");

        add(btnInventario);
        add(btnSalir);

        // ABRIR INVENTARIOFRAME
        btnInventario.addActionListener(e -> {
            InventarioFrame inv = new InventarioFrame();
            inv.setVisible(true);
            dispose();
        });

        btnSalir.addActionListener(e -> System.exit(0));
    }
}

