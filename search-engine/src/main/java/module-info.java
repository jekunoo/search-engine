module com.java.strukdat.searchengine {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.java.strukdat.searchengine to javafx.fxml;
    exports com.java.strukdat.searchengine;
    exports com.java.strukdat.searchengine.controller;
    opens com.java.strukdat.searchengine.controller to javafx.fxml;
}