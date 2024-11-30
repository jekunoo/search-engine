package com.java.strukdat.searchengine.controller;

import java.io.IOException;
import java.util.List;

import com.java.strukdat.searchengine.TreeInstance;
import com.java.strukdat.searchengine.model.Node;
import com.java.strukdat.searchengine.model.RedBlackTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LandingPageController {

    @FXML
    private Button searchButton;
    @FXML
    private TextField searchField;
    @FXML
    private ListView<String> suggestionsList;
//
//    private ObservableList<String> allItems = FXCollections.observableArrayList(
//            "Apple","ata","anjing", "anjing", "Ayam", "Apel", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew", "pornhub", "pineapple", "bokep viral indo"
//    );

    private ObservableList<String> filteredItems = FXCollections.observableArrayList();

    private static final int ITEM_HEIGHT = 25;
    private int MAX_VISIBLE_ITEMS;

    @FXML
    public void initialize() {
        MAX_VISIBLE_ITEMS = 5;
        filteredItems = FXCollections.observableArrayList();
        RedBlackTree tree = TreeInstance.getInstance().getTree(); // Get the singleton tree instance

        // Set the initial visibility and items for the suggestionsList
        suggestionsList.setItems(filteredItems);
        suggestionsList.setVisible(false);

        // Add a listener to the searchField to trigger the search
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredItems.clear();
            if (newValue.isEmpty()) {
                suggestionsList.setVisible(false); // Hide the suggestions list if the input is empty
            } else {
                // Perform the search in the RedBlackTree
                String lowerCaseSearch = newValue.toLowerCase();
                List<Node> results = tree.searchByPrefix(lowerCaseSearch);

                // Add matching keys to the filteredItems list
                for (Node node : results) {
                    System.out.println("Adding to filteredItems: " + node.getKey());
                    filteredItems.add(node.getKey());
                }

                // Debug: Check the size of filteredItems
                System.out.println("Filtered Items Size: " + filteredItems.size());

                // Update the visibility and height of the suggestionsList
                suggestionsList.setVisible(!filteredItems.isEmpty());
                int visibleItems = Math.min(filteredItems.size(), MAX_VISIBLE_ITEMS);
                suggestionsList.setMaxHeight(ITEM_HEIGHT * visibleItems);
            }
        });

        // Customize how items in the suggestionsList are displayed
        suggestionsList.setCellFactory(listView -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item); // Correctly display the item
                    setWrapText(true); // Optional: Allow text wrapping
                    setMaxWidth(Double.MAX_VALUE); // Ensure the cell fits the list width
                }
            }
        });

        // Handle clicks on items in the suggestionsList
        suggestionsList.setOnMouseClicked(event -> {
            String selectedItem = suggestionsList.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                searchField.setText(selectedItem); // Set the selected suggestion in the search field
                suggestionsList.setVisible(false); // Hide the suggestions list
            }
        });
    }
    @FXML
    public void onActionSearchButton(ActionEvent event) throws IOException {
        String searchInput = searchField.getText().trim();
        if (!searchInput.isEmpty()) {
            // Replace the scene in the same window
            Stage currentStage = (Stage) searchButton.getScene().getWindow();
            System.out.println("Input: " + searchInput);
            openSearchRecommendation(searchInput, currentStage);
        }
    }

    private void openSearchRecommendation(String keyword, Stage currentStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/java/strukdat/searchengine/view/search-recomendation.fxml"));
        Parent root = fxmlLoader.load();

        // Pass the keyword to the controller
        SearchRecomendationController controller = fxmlLoader.getController();
        controller.setKeyword(keyword);

        // Set the new scene on the same stage
        Scene newScene = new Scene(root);
        currentStage.setScene(newScene);
    }
}
