module com.example.socialapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    exports com.example.socialapp.domain;
    exports com.example.socialapp.controller;

    opens com.example.socialapp to javafx.fxml;
    opens com.example.socialapp.controller to javafx.fxml;
    opens com.example.socialapp.domain to javafx.fxml;
    exports com.example.socialapp;


}