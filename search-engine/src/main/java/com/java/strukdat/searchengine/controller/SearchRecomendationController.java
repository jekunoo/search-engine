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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SearchRecomendationController {


    @FXML
    private Pane rootPane; // Root Pane untuk animasi
    @FXML
    private TextField searchField;
    @FXML
    private ListView<String> suggestionsList;
    @FXML
    private VBox suggestionsRecomendationItem;
    @FXML
    private Text resultText; // Text untuk menampilkan hasil pencarian

    private ObservableList<String> filteredItems = FXCollections.observableArrayList();
    private static final int ITEM_HEIGHT = 26; // Tinggi setiap item
    private int MAX_VISIBLE_ITEMS = 5; // Maksimal jumlah item yang ditampilkan
    private String keyword;

    @FXML
    public void initialize() {
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
                suggestionsList.setPrefHeight(0); // Reset height
            } else {
                // Perform the search in the RedBlackTree
                String lowerCaseSearch = newValue.toLowerCase();
                List<Node> results = tree.searchByPrefix(lowerCaseSearch);

                // Add matching keys to the filteredItems list
                for (Node node : results) {
                    filteredItems.add(node.getKey());
                }

                // Update the visibility and height of the suggestionsList
                suggestionsList.setVisible(!filteredItems.isEmpty());
                int visibleItems = Math.min(filteredItems.size(), MAX_VISIBLE_ITEMS);
                suggestionsList.setPrefHeight(ITEM_HEIGHT * visibleItems); // Adjust height dynamically
            }
        });

        // Customize how items in the suggestionsList are displayed
        suggestionsList.setCellFactory(listView -> new ListCell<String>() {
            private final Text text = new Text();

            {
                // Bind wrapping width to the ListView width minus padding
                text.wrappingWidthProperty().bind(listView.widthProperty().subtract(30)); // Adjust padding if needed
                text.setStyle("-fx-padding: 5; -fx-font-size: 14px;");
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                    setText(null);
                } else {
                    text.setText(item);
                    setGraphic(text);
                }
            }
        });

        // Handle clicks on items in the suggestionsList
        suggestionsList.setOnMouseClicked(event -> {
            String selectedItem = suggestionsList.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Set the selected suggestion in the search field
                searchField.setText(selectedItem);

                // Hide the suggestions list
                suggestionsList.setVisible(false);
                suggestionsList.setPrefHeight(0); // Reset height

            }
        });

    }

    // Method to load the detail page
    private void openDetailPage(Node node) {
        try {
            // Load FXML for the detail page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/java/strukdat/searchengine/view/detail-page.fxml"));
            Parent detailPage = loader.load();

            // Get the controller for the detail page
            DetailPageController controller = loader.getController();

            if (node != null) {
                controller.setNodeData(node);  // Only set data if the node is not null
            } else {
                System.out.println("Node is null, cannot set data in detail page.");
            }

            // Pass the current scene to the DetailPageController
            controller.setPreviousScene(rootPane.getScene()); // rootPane is part of SearchRecomendationController

            // Create a new scene and show it
            Scene detailScene = new Scene(detailPage);
            Stage stage = (Stage) rootPane.getScene().getWindow(); // Now rootPane should be correctly initialized
            stage.setScene(detailScene); // Change scene to detail page
            stage.show(); // Show the new scene
        } catch (IOException e) {
            e.printStackTrace();
        }
    }












    public void searchInitialize(String keyword) {
        RedBlackTree tree = TreeInstance.getInstance().getTree();

        // Clear previous search results
        suggestionsRecomendationItem.getChildren().clear();

        // Start timing the search
        long startTime = System.nanoTime();

        // Call tree.searchByPrefix to get suggestions based on the substring
        List<Node> searchResults = tree.searchByPrefix(keyword);

        // End timing the search
        long endTime = System.nanoTime();
        long durationInNano = endTime - startTime;
        double durationInMillis = durationInNano / 1_000_000.0; // Convert to milliseconds

        // Display search results
        displaySearchResults(keyword, searchResults, durationInMillis);
    }

    /**
     * Helper method to truncate a description to a maximum number of words.
     */
    private String truncateDescription(String description, int maxWords) {
        String[] words = description.split("\\s+"); // Split by whitespace
        if (words.length <= maxWords) {
            return description;
        }
        return String.join(" ", java.util.Arrays.copyOfRange(words, 0, maxWords)) + "...";
    }

    // Handle ListView item clicks
    private void handleResultClick(String selectedItem) {
        System.out.println("You clicked on: " + selectedItem);
    }

    // Method to set the keyword for the search
    public void setKeyword(String keyword){
        if (keyword != null && !keyword.isEmpty()) {
            searchInitialize(keyword);
        }
    }

    @FXML
    public void onActionSearchButton(ActionEvent event) throws IOException {
        String searchInput = searchField.getText().trim();

        if (!searchInput.isEmpty()) {
            // Start timing the search
            long startTime = System.nanoTime();

            // Get search results from the tree
            RedBlackTree tree = TreeInstance.getInstance().getTree();
            List<Node> searchResults = tree.searchByPrefix(searchInput);

            // End timing the search
            long endTime = System.nanoTime();
            long durationInNano = endTime - startTime;
            double durationInMillis = durationInNano / 1_000_000.0; // Convert to milliseconds

            // Clear previous search results
            suggestionsRecomendationItem.getChildren().clear();

            // Display search results and duration
            displaySearchResults(searchInput, searchResults, durationInMillis);

            // Update result text with search duration
            resultText.setText(String.format("Results for \"%s\" (%.2f ms)", searchInput, durationInMillis));
        }
    }

    private void displaySearchResults(String keyword, List<Node> searchResults, double durationInMillis) {
        // Update resultText to show search duration
        resultText.setText(String.format("Results for \"%s\" (%.2f ms)", keyword, durationInMillis));

        // Add search results to VBox
        for (Node node : searchResults) {
            VBox resultItem = new VBox();
            resultItem.setSpacing(10);
            resultItem.setStyle("-fx-background-color: #eee; -fx-padding: 10; -fx-border-color: #C0C0C0; -fx-border-radius: 5;");

            Text titleText = new Text(node.getKey());
            titleText.setFont(new Font("Arial Bold", 18));

            String fullDescription = node.getValue() != null ? node.getValue() : "No description available.";
            String truncatedDescription = truncateDescription(fullDescription, 20);

            Text descriptionText = new Text(truncatedDescription);
            descriptionText.setFont(new Font("Arial", 14));

            resultItem.getChildren().addAll(titleText, descriptionText);

            // Set event handler for when the result item is clicked
            resultItem.setOnMouseClicked(event -> {
                System.out.println("Item clicked: " + node.getKey()); // Debugging line
                openDetailPage(node); // Open the detail page for the selected node
            });

            // Add the result item to the VBox that holds all the search results
            suggestionsRecomendationItem.getChildren().add(resultItem);
        }
    }
}
