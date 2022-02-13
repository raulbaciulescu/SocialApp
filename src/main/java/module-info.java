module com.example.socialapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.socialapp to javafx.fxml;
    exports com.example.socialapp;
}