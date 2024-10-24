package DAO;


import javafx.application.Platform;
import javafx.concurrent.Task;
import netscape.javascript.JSObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryDAO
{
    public void consultarClientes() {
        Task<Void> tarea = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try (Connection conexion = ConexionDB.conectar();
                     Statement sentencia = conexion.createStatement();
                     ResultSet resultado = sentencia.executeQuery("SELECT * FROM res_partner_category")) {

                    while (resultado.next()) {
                        Integer id =  resultado.getInt("id");
                        Character parent_path = resultado.("apellido");
                        JSObject





                        Platform.runLater(() -> {
                            // Actualizar la interfaz gráfica con los valores de nombre y apellido
                            // Por ejemplo, añadirlos a un ListView, Label, etc.
                        });
                    }

                } catch (SQLException e) {
                    System.err.println("Error de SQL al consultar: " + e.getMessage());
                    Platform.runLater(() -> {
                        // Mostrar un mensaje de error en la interfaz gráfica
                    });
                }
                return null;
            }
        };

        Thread hilo = new Thread(tarea);
        hilo.start();
    }

}




Character parent_path = apellido != null && !apellido.isEmpty() ? apellido.charAt(0) : null;

// Crear un objeto JSON con los datos
JSONObject jsonObject = new JSONObject();
                        jsonObject.put("id", id);
                        jsonObject.put("parent_path", parent_path != null ? parent_path.toString() : ""); // Convertir Character a String

// Si necesitas pasar datos a un JSObject (por ejemplo, en una interfaz WebView)
JSObject jsObject = null; // Inicializa tu JSObject si es necesario para tu caso
                        if (jsObject != null) {
        jsObject.setMember("data", jsonObject.toString()); // Envía los datos al JSObject
        }