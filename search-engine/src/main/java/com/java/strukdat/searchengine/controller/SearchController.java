package com.java.strukdat.searchengine.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SearchController {

    @FXML
    private TextField searchField;

    @FXML
    private ListView<String> resultsList;

    @FXML
    private TextArea detailsArea;

    @FXML
    private void onSearchAction() {
        // Example search logic
        String query = searchField.getText();
        if (query != null && !query.isEmpty()) {
            resultsList.getItems().clear();
            resultsList.getItems().addAll("Result 1 for: " + query, "Result 2 for: " + query);
            detailsArea.setText("Details about: " + query);
        } else {
            resultsList.getItems().clear();
            detailsArea.setText("");
        }
    }
}
