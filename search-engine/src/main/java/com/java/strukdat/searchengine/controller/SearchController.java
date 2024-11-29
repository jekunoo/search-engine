package com.java.strukdat.searchengine.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class SearchController {

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    private VBox textContainer;

    @FXML
    private ImageView imageView;

    @FXML
    private TextArea detailsArea;

    @FXML
    private Button detailsButton;

    /**
     * Method to handle the search button action.
     */
    @FXML
    private void onActionSearchButton() {
        // Clear existing results
        textContainer.getChildren().clear();

        // Get search query
        String query = searchField.getText();

        if (query.isEmpty()) {
            addResult("Please enter a search query.");
        } else {
            // Simulate search and populate results
            performSearch(query);
        }
    }

    /**
     * Simulates a search operation and displays results.
     *
     * @param query The search query entered by the user.
     */
    private void performSearch(String query) {
        // Example results based on the query
        addResult("Result for: " + query);
        addResult("Example result 1");
        addResult("Example result 2");
        addResult("Example result 3");

        // Update details and image as an example
        updateDetailsAndImage("Details about " + query, "path/to/your/image.jpg");
    }

    /**
     * Adds a result as a label to the textContainer VBox.
     *
     * @param text The result text to display.
     */
    private void addResult(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 14; -fx-padding: 5;");
        textContainer.getChildren().add(label);

        // Optional: Add click event to each result
        label.setOnMouseClicked(event -> {
            detailsArea.setText("You selected: " + text);
        });
    }

    /**
     * Updates the details area and the image view.
     *
     * @param details The details text to display.
     * @param imagePath The path to the image to display.
     */
    private void updateDetailsAndImage(String details, String imagePath) {
        detailsArea.setText(details);

        // Update image
        try {
            Image image = new Image(imagePath);
            imageView.setImage(image);
        } catch (Exception e) {
            detailsArea.setText(details + "\n\n(Note: Image could not be loaded)");
        }
    }

    /**
     * Updates details and image based on data from the previous UI.
     *
     * @param details The details from the previous UI.
     */
    public void updateDetailsFromPreviousUI(String details) {
        detailsArea.setText(details);
        updateDetailsAndImage(details, "path/to/default/image.jpg");
    }
}
