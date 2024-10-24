package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB
{
        public static Connection conectar() {
            // Reemplaza con tus datos de conexión
            String url = "jdbc:postgresql://localhost:8080/postgres";
            String usuario = "odoo";
            String contrasena = "odoo";

            try {
                return DriverManager.getConnection(url, usuario, contrasena);
            } catch (SQLException e) {
                System.err.println("Error de SQL al conectar: " + e.getMessage());
                return null;
            }
        }
    }
