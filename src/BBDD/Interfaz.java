package BBDD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz implements ActionListener {
    JFrame ventana;
    JPanel panel;
    JButton añadir;
    JButton modificar;
    JButton eliminar;
    JButton buscar;

    DefaultTableModel modelo = new DefaultTableModel();

    JTable tabla = new JTable(modelo);


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==añadir){
            Metodos.insertar();
        }
        if(e.getSource()==eliminar){
            Metodos.eliminar();
        }
        if(e.getSource()==modificar){
            Metodos.update();
        }

    }

    public void run() {

        ventana = new JFrame();
        ventana.setBounds(1200, 50, 350, 350);
        ventana.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 350, 350);
        panel.setLayout(null);


        añadir = new JButton("AÑADIR");
        añadir.setBounds(85, 100, 180, 30);

        modificar = new JButton("MODIFICAR");
        modificar.setBounds(85, 140, 180, 30);

        eliminar = new JButton("ELIMINAR");
        eliminar.setBounds(85, 180, 180, 30);


        panel.add(añadir);
        panel.add(modificar);
        panel.add(eliminar);
        panel.add(tabla);


        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra Aplicacion cuando X;
        ventana.setVisible(true);

        añadir.addActionListener(this);
        eliminar.addActionListener(this);
        modificar.addActionListener(this);
    }


}

