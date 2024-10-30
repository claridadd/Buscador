package com.example.buscador.Controladores;

import com.example.buscador.DAO.CategoryDAO;
import com.example.buscador.modelos.Category;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

public class HelloController {


    @FXML
    private ImageView ivBuscar;
    @FXML
    private TableColumn columnaActive;
    @FXML
    private ImageView ivEditar;
    @FXML
    private Button btnBorrar;
    @FXML
    private TableColumn columnaParentPath;
    @FXML
    private ImageView ivBorrar;
    @FXML
    private VBox vbFondo;
    @FXML
    private Button btnEditar;
    @FXML
    private TableColumn columnaColor;
    @FXML
    private TableColumn columnaId;
    @FXML
    private TableView tvTabla;
    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnBuscar;
    @FXML
    private ImageView ivAñadir;
    @FXML
    private TableColumn columnaCreateDate;
    @FXML
    private TextField tfVisor;

    @FXML
    protected void onHelloButtonClick()
    {
        columnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    @FXML
    public void onClickBuscar(ActionEvent actionEvent)
    {
        Task<Void> tarea = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try{
                    String palabra = "";

                    List<Category> categorias = CategoryDAO.obtenerCategorias(palabra);
                    ObservableList<Category> datos = FXCollections.observableArrayList(categorias);

                    Platform.runLater(() -> { tvTabla.setItems(datos); });

                } catch (SQLException e) {
                    System.err.println("Error de SQL al consultar: " + e.getMessage());
                    Platform.runLater(() -> {

                    });
                }
                return null;
            }
        };

        Thread hilo = new Thread(tarea);
        hilo.start();
    }




}