package com.example.buscador.DAO;

import com.example.buscador.modelos.Category;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO
{
    public static List<Category> obtenerCategorias(String palabra) throws SQLException {


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

            while (resultado.next())
            {
                Integer id = resultado.getInt("id");
                Integer color = resultado.getInt("color");
                Integer parent_id = resultado.getInt("parent_id");

                String parent_path = resultado.getString("parent_path");

                Boolean active = resultado.getBoolean("active");
                Timestamp created = resultado.getTimestamp("created");

                categorias.add((new Category(id, color, parent_id, parent_path, active, created)));
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return categorias;

    }

}

