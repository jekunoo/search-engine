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

    private ObservableList<String> allItems = FXCollections.observableArrayList(
            "Apple", "anjing", "Ayam", "Apel", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew", "pornhub", "pineapple", "bokep viral indo"
    );

    private ObservableList<String> filteredItems = FXCollections.observableArrayList();

    private static final int ITEM_HEIGHT = 25;
    private int MAX_VISIBLE_ITEMS;

    @FXML
    public void initialize() {
        MAX_VISIBLE_ITEMS = Math.min(allItems.size(), 5);

        suggestionsList.setItems(filteredItems);
        suggestionsList.setVisible(false);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredItems.clear();
            if (newValue.isEmpty()) {
                suggestionsList.setVisible(false);
            } else {
                String lowerCaseSearch = newValue.toLowerCase();
                for (String item : allItems) {
                    if (item.toLowerCase().startsWith(lowerCaseSearch)) {
                        filteredItems.add(item);
                    }
                }
                suggestionsList.setVisible(!filteredItems.isEmpty());
                int visibleItems = Math.min(filteredItems.size(), MAX_VISIBLE_ITEMS);
                suggestionsList.setMaxHeight(ITEM_HEIGHT * visibleItems);
            }
        });

        suggestionsList.setCellFactory(listView -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item);
                    setWrapText(true);
                    setMaxWidth(Double.MAX_VALUE);
                }
            }
        });

        suggestionsList.setOnMouseClicked(event -> {
            String selectedItem = suggestionsList.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                searchField.setText(selectedItem);
                suggestionsList.setVisible(false);
            }
        });
    }

    @FXML
    public void onActionSearchButton(ActionEvent event) throws IOException {
        String searchInput = searchField.getText().trim();
        if (!searchInput.isEmpty()) {
            // Replace the scene in the same window
            Stage currentStage = (Stage) searchButton.getScene().getWindow();
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
