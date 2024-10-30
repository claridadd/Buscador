package com.example.buscador.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB
{
        public static Connection conectar() throws RuntimeException
        {
            // Reemplaza con tus datos de conexión
            String dbName   = "odoo";
            String dbPort   = "8080";
            String username = "odoo";
            String password = "odoo";

            try {
                String url = "jdbc:postgresql://localhost:" + dbPort + "/" + dbName;
                return DriverManager.getConnection(url, username, password);

            } catch (SQLException e) {
                System.err.println("Error de SQL al conectar: " + e.getMessage());
                e.printStackTrace();
                System.exit(-1);
            }

            return null;
        }
}
