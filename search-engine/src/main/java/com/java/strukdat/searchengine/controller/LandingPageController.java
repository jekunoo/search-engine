package com.java.strukdat.searchengine.controller;

import java.io.IOException;

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
    
    // List of all items to suggest
    private ObservableList<String> allItems = FXCollections.observableArrayList(
            "Apple", "anjing", "Ayam", "Apel", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew","pornhub","pinaple","bokep viral indo"
    );

    // Filtered list of items based on the search query
    private ObservableList<String> filteredItems = FXCollections.observableArrayList();

    private static final int ITEM_HEIGHT = 25; // Height of each item in pixels
    private int MAX_VISIBLE_ITEMS; // Maximum number of items to display

    @FXML
    public void initialize() {

        // Initialize MAX_VISIBLE_ITEMS based on allItems size or set a cap
        MAX_VISIBLE_ITEMS = Math.min(allItems.size(), 5); // For example, limit to a maximum of 5 items

        // Bind the ListView to the filteredItems list
        suggestionsList.setItems(filteredItems);

        // Set a preferred width for the ListView
          // Adjust to your preferred width

        suggestionsList.setVisible(false);

        // Add a listener to the search field to filter suggestions
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredItems.clear();
            if (newValue.isEmpty()) {
                suggestionsList.setVisible(false); // Hide suggestions if search field is empty
            } else {
                String lowerCaseSearch = newValue.toLowerCase(); // Convert the input to lowercase
                for (String item : allItems) {
                    // Check if the item starts with the input search string
                    if (item.toLowerCase().startsWith(lowerCaseSearch)) {
                        filteredItems.add(item);
                    }
                }
                // Show suggestions if there are any matching items
                suggestionsList.setVisible(!filteredItems.isEmpty());

                // Set the maximum height of the suggestionsList based on the number of filtered items
                int visibleItems = Math.min(filteredItems.size(), MAX_VISIBLE_ITEMS);
                suggestionsList.setMaxHeight(ITEM_HEIGHT * visibleItems); // Set max height
            }
        });

        // Set up the cell factory for the ListView to enable text wrapping
        suggestionsList.setCellFactory(listView -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item);  // Set the text directly
                    setWrapText(true);  // Enable text wrapping
                    setMaxWidth(Double.MAX_VALUE); // Allow cell to grow to available width
                }
            }
        });


        // Handle selection from the ListView
        suggestionsList.setOnMouseClicked(event -> {
            String selectedItem = suggestionsList.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                searchField.setText(selectedItem);  // Set selected item in search field
                suggestionsList.setVisible(false);   // Hide suggestions list
            }
        });
    }

    @FXML
    public void onActionSearchButton(ActionEvent event) throws IOException {
        String searchInput = searchField.getText().trim();

        if (!searchInput.isEmpty()) {
            openSearchRecommendation(searchInput);
        }
    }

    private void openSearchRecommendation(String keyword) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/java/strukdat/searchengine/view/search-recomendation.fxml"));
        Parent root = fxmlLoader.load();

        // get keyword to search recommendation
        SearchRecomendationController controller = fxmlLoader.getController();

        // send keyword to search recommendation
        controller.setKeyword(keyword);

        // show the search recommendation window
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }
}