module com.example.buscador {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires jdk.jsobject;


    opens com.example.buscador to javafx.fxml;
    exports com.example.buscador;
    exports com.example.buscador.Controladores;
    opens com.example.buscador.Controladores to javafx.fxml;
}