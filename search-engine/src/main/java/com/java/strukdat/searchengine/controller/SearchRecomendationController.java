package com.java.strukdat.searchengine.controller;

import java.io.IOException;
import java.util.List;

import com.java.strukdat.searchengine.TreeInstance;
import com.java.strukdat.searchengine.model.Node;
import com.java.strukdat.searchengine.model.RedBlackTree;
import com.java.util.Gimmick;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SearchRecomendationController {

    @FXML
    private Pane rootPane; // Root Pane untuk animasi
    @FXML
    private TextField searchField;
    @FXML
    private ListView<String> suggestionsList;

    private Gimmick<String> gimmick;

    @FXML
    public void initialize() {
        gimmick = new Gimmick<>(rootPane);

        suggestionsList.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Detect double-click
                String selectedItem = suggestionsList.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    handleResultClick(selectedItem);
                }
            }
        });
    }

    private void searchInitialize(String keyword) {
        RedBlackTree tree = TreeInstance.getInstance().getTree();
        tree.visualize(); // Optional: Update the UI with tree visualization

        List<Node> searchResults = tree.searchBySubstring(keyword);
        for (Node node : searchResults) {
            suggestionsList.getItems().add(node.getKey());
            System.out.println(node.getKey());
        }
    }

    // Handle ListView item clicks
    private void handleResultClick(String selectedItem) {
        System.out.println("You clicked on: " + selectedItem);
    }

    // method menerima keyword
    public void setKeyword(String keyword){
        if (keyword != null && !keyword.isEmpty()) {
            searchInitialize(keyword);

            // Trigger gimmick
            String result = gimmick.gimmick(keyword);
            System.out.println("Gimmick result: " + result);
        }
    }
    @FXML
    public void onActionSearchButton(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/java/strukdat/searchengine/view/search-recomendation.fxml"));
//        Parent root = loader.load();
//        Stage stage = new Stage();
//
//        stage.setScene(new Scene(root));
//        stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/java/strukdat/searchengine/view/search-recomendation.fxml"));
        Parent root = fxmlLoader.load();

        // Pass the keyword to the controller
        SearchRecomendationController controller = fxmlLoader.getController();
        controller.setKeyword(searchField.getText());
        Stage currentStage = (Stage) searchField.getScene().getWindow();
        Scene newScene = new Scene(root);
        currentStage.setScene(newScene);
    }

    
}
