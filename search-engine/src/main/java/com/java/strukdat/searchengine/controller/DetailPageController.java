package com.java.strukdat.searchengine.controller;

import com.java.strukdat.searchengine.model.Node;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DetailPageController {
    @FXML
    private Text nodeTitle; // For the `key`
    @FXML
    private Text nodeDescription; // For the `value`
    @FXML
    private ImageView nodeImage; // For the `imgPath`
    @FXML
    private Button backButton; // For navigation

    private Scene previousScene; // Store the previous scene

    // Method to pass Node data to this controller
    public void setNodeData(Node nodeData) {
        if (nodeData != null) {
            nodeTitle.setText(nodeData.getKey());
            nodeDescription.setText(nodeData.getValue());

//            // Load image from the provided path
//            if (nodeData.getContent() != null) {
//                nodeImage.setImage(new Image(getClass().getResourceAsStream(nodeData.getContent())));
//            }
        }
    }

    // Set the previous scene to allow going back
    public void setPreviousScene(Scene scene) {
        this.previousScene = scene;
    }

    @FXML
    public void handleBackButton() {
        if (previousScene != null) {
            // Get the stage from the current scene and set the previous scene
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(previousScene);
            stage.show();
        }
    }


}
