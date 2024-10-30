package com.example.buscador.DAO;

import com.example.buscador.modelos.Category;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO
{
    public void consultarClientes(String palabra) {
        Task<Void> tarea = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                List<Category> categorias = new ArrayList<>();
                String comando;

                if(palabra.strip().isEmpty())
                    comando = "SELECT * FROM res_partner_category";
                else
                    comando = "SELECT * FROM res_partner_category WHERE id = '" + palabra + " ' ";

                try (
                     Connection conexion = ConexionDB.conectar();
                     Statement sentencia = conexion.createStatement();
                     ResultSet resultado = sentencia.executeQuery(comando))
                {

                    while (resultado.next()) {

                        Integer id = resultado.getInt("id");
                        Integer color = resultado.getInt("color");
                        Integer parent_id = resultado.getInt("parent_id");

                        String parent_path = resultado.getString("Ruta padre:");

                        Boolean active = resultado.getBoolean("active");
                        Timestamp created = resultado.getTimestamp("created");

                        categorias.add((new Category(id, color, parent_id, parent_path, active, created)));

                        ObservableList<Category>

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



//
//Character parent_path = apellido != null && !apellido.isEmpty() ? apellido.charAt(0) : null;
//
//// Crear un objeto JSON con los datos
//JSONObject jsonObject = new JSONObject();
//                        jsonObject.put("id", id);
//                        jsonObject.put("parent_path", parent_path != null ? parent_path.toString() : ""); // Convertir Character a String
//
//// Si necesitas pasar datos a un JSObject (por ejemplo, en una interfaz WebView)
//JSObject jsObject = null; // Inicializa tu JSObject si es necesario para tu caso
//                        if (jsObject != null) {
//        jsObject.setMember("data", jsonObject.toString()); // Envía los datos al JSObject
//        }