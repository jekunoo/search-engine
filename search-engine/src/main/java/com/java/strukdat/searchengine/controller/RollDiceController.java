package com.java.strukdat.searchengine.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class RollDiceController {

    @FXML
    private ImageView imageView;

    @FXML
    private Button rollButton;


    private final Random random = new Random();

    @FXML
    public void initialize() {
        // Set an initial dice image (optional)
        setImage(1);

        // Set action for the roll button
        rollButton.setOnAction(event -> rollDice());
    }

    private void rollDice() {
        // Generate a random number between 1 and 6
        int diceNumber = random.nextInt(6) + 1;

        // Set the corresponding dice image
        setImage(diceNumber);
    }

    private void setImage(int number) {
        try {
            String path = "/com/java/strukdat/searchengine/view/img/dadu/" + number + ".png"; // Path to images
            System.out.println("Attempting to load: " + path); // Debug output
            var resource = getClass().getResourceAsStream(path);
            if (resource == null) {
                System.err.println("Resource not found: " + path);
            } else {
                Image diceImage = new Image(resource);
                imageView.setImage(diceImage);
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }


}
