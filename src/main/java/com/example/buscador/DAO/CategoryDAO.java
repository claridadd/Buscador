package com.example.buscador.DAO;

import com.example.buscador.modelos.Category;
import javafx.application.Platform;
import javafx.concurrent.Task;

import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO
{
    public void consultarClientes() {
        Task<Void> tarea = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                List<Category> categorias = new ArrayList<>();

                try (
                     Connection conexion = ConexionDB.conectar();
                     Statement sentencia = conexion.createStatement();
                     ResultSet resultado = sentencia.executeQuery("SELECT * FROM res_partner_category"))
                {

                    while (resultado.next()) {

                        Category categoria = new Category();
                        categoria.setId(resultado.getInt("id"));
                        categorias.add(categoria);
                        System.out.println(resultado.getInt("id"));


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