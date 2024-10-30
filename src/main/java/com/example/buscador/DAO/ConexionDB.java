package com.example.buscador.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB
{
        public static Connection connection = null;
        public static Connection conectar() throws RuntimeException
        {
            // Reemplaza con tus datos de conexión
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String usuario = "odoo";
            String contrasena = "odoo";

            try {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection(url, usuario, contrasena);

                return DriverManager.getConnection(url, usuario, contrasena);

            } catch (SQLException | ClassNotFoundException e) {
                System.err.println("Error de SQL al conectar: " + e.getMessage());
                e.printStackTrace();
                System.exit(-1);
            }
            return connection;
        }
    }
