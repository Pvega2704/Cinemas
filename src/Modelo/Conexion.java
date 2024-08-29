package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    Connection con = null;
    Connection Conexion = null;
    String base = "cinemas"; //Nombre de la base de datos
    String url = "jdbc:mysql://localhost:3306/" + base; //Direccion, puerto y nombre de la Base de Datos
    String user = "root"; //Usuario de Acceso a MySQL
    String password = ""; //Password del usuario

    public Connection getConexion() {

        try {
            Class.forName("com.mysql.jdbc.Connection");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return con;
    }

    PreparedStatement crearPrepareStatement(String select__from_ticket_WHERE_cedula_LIKE_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Connection closeConexion() {
        try {
            Conexion.close();
            System.out.println("Cerrando la conexion don la base de datos " + url + "...OK");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Conexion = null;
        return Conexion;
    }

    Statement crearStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


