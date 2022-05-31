package BBDD;

import javax.swing.*;
import java.sql.*;

public class Metodos {

    public static void conectar() {
        try {

            String url = "/Users/laura/BBDD/prueba_bbdd.db"; //Ruta donde se encuentra nuestra base

            //Objeto tipo Connection. Clase DriverManager y método.
            Connection connect = DriverManager.getConnection("jdbc:sqlite:" + url, "root", "");

            //Objeto Statement para ejecutar secuencias SQL
            Statement st = connect.createStatement();

            // El resultado se almacena en el Resulset
            ResultSet rs = st.executeQuery("Select * from Alumno");

            //Recorremos el resulset
            while (rs.next()) {
                System.out.println(rs.getString("id") + " - " + rs.getString("nombre") + " "+ rs.getString("apellido"));
            }
            if (connect != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (Exception ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.out.println("Conexión fallida");
        }
    }


    public static void insertar() {
        try {

            String url = "/Users/laura/BBDD/prueba_bbdd.db"; //Ruta donde se encuentra nuestra base

            //Objeto tipo Connection. Clase DriverManager y método.
            Connection connect = DriverManager.getConnection("jdbc:sqlite:" + url, "root", "");

            //Objeto Statement para ejecutar secuencias SQL
            Statement st = connect.createStatement();

            String insertar = "INSERT INTO Alumno(nombre,apellido,curso, nota) VALUES(?,?,?,?)";

            PreparedStatement pre = connect.prepareStatement(insertar);
            {
                pre.setString(1, JOptionPane.showInputDialog("Nombre del nuevo alumno:"));
                pre.setString(2, JOptionPane.showInputDialog("Apellido:"));
                pre.setString(3, JOptionPane.showInputDialog("Curso:"));
                pre.setString(4, JOptionPane.showInputDialog("Nota:"));
                pre.executeUpdate();
            }

            ResultSet rs = st.executeQuery("Select * from Alumno");
            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("nombre") +
                        " Nota: " + rs.getString("nota"));
            }
            if (connect != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (Exception ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.out.println("Conexión fallida");
        }
    }

    public static void update() {
        try {

            String url = "/Users/laura/BBDD/prueba_bbdd.db"; //Ruta donde se encuentra nuestra base

            //Objeto tipo Connection. Clase DriverManager y método.
            Connection connect = DriverManager.getConnection("jdbc:sqlite:" + url, "root", "");

            //Objeto Statement para ejecutar secuencias SQL
            Statement st = connect.createStatement();

            PreparedStatement pre = connect.prepareStatement("UPDATE Alumno SET nombre=?,apellido=?,curso=?, nota=? WHERE ID=?");
            {
                pre.setString(5, JOptionPane.showInputDialog("Inserte el ID del alumno que quiera modificar: "));
                pre.setString(1, JOptionPane.showInputDialog("Introduzca Nombre"));
                pre.setString(2, JOptionPane.showInputDialog("Introduzca Apellido"));
                pre.setString(3, JOptionPane.showInputDialog("Introduzca Curso"));
                pre.setString(4, JOptionPane.showInputDialog("Introduzca Nota"));
                pre.executeUpdate();
            }

            ResultSet rs = st.executeQuery("Select * from Alumno");

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("nombre") +
                        " Apellido: " + rs.getString("apellido")+
                        " Nota: " + rs.getString("nota") +
                        " Curso: " + rs.getString("curso"));
            }

                if (connect != null) {
                    System.out.println("Conexión exitosa");
                }


        } catch (Exception ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.out.println("Conexión fallida");
        }
    }

    public static void eliminar() {
        try {

            String url = "/Users/laura/BBDD/prueba_bbdd.db"; //Ruta donde se encuentra nuestra base

            //Objeto tipo Connection. Clase DriverManager y método.
            Connection connect = DriverManager.getConnection("jdbc:sqlite:" + url, "root", "");

            //Objeto Statement para ejecutar secuencias SQL
            Statement st = connect.createStatement();

            PreparedStatement pre = connect.prepareStatement("DELETE FROM Alumno WHERE ID=?");
            {
                pre.setString(1, JOptionPane.showInputDialog("Inserte el ID del alumno que quiera elimnar: "));
                pre.executeUpdate();
            }

            ResultSet rs = st.executeQuery("Select * from Alumno");

            while (rs.next()) {
                System.out.println(rs.getString("ID") + " - "+ rs.getString("nombre") +
                         rs.getString("apellido"));
            }

            if (connect != null) {
                System.out.println("Conexión exitosa");
            }


        } catch (Exception ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.out.println("Conexión fallida");
        }
    }

}
