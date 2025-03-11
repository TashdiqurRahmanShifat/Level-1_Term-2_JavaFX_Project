module com.example.moviejava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires javafx.web;

    opens com.example.moviejava to javafx.fxml;
    exports com.example.moviejava;
    exports ServerClient;
    opens ServerClient to javafx.fxml;
    exports Controller;
    opens Controller to javafx.fxml;


}