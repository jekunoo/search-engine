package com.java.strukdat.searchengine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.java.strukdat.searchengine.model.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/landing-page.fxml"));

        primaryStage.setTitle("Search with Suggestions");
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.show();
        populateRBT();
    }

    private void populateRBT(){
        RedBlackTree tree = TreeInstance.getInstance().getTree();
        tree.insert("anjay", "a", "as");
        tree.insert("anjay1", "a", "as");
        tree.insert("anjay2", "a", "as");
        tree.insert("hhh", "a", "as");

    }

    public static void main(String[] args) {
        launch(args);
    }
}
