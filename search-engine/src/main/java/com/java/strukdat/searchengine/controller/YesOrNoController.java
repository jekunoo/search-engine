package com.java.strukdat.searchengine.controller;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class YesOrNoController {

    @FXML
    private ImageView Wheel; // ImageView with id "Wheel"

    @FXML
    private Button spinButton; // Spin button

    // Random instance to generate random stopping angles
    private final Random random = new Random();

    @FXML
    public void initialize() {
        // Attach event handler to the spin button
        spinButton.setOnAction(event -> spinWheel());
    }

    private void spinWheel() {
        // Create a RotateTransition to rotate the wheel
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(Wheel);
        rotateTransition.setDuration(Duration.seconds(3)); // Total rotation duration
        rotateTransition.setByAngle(360 * 5); // Spin for 5 full rotations

        // Generate a random stopping angle between 0 and 360 degrees
        int randomAngle = random.nextInt(90);

        // Set an onFinished event to stop the wheel at the random angle
        rotateTransition.setOnFinished(event -> {
            // Create a new RotateTransition for stopping at the random angle
            RotateTransition stopTransition = new RotateTransition();
            stopTransition.setNode(Wheel);
            stopTransition.setDuration(Duration.seconds(1)); // Smooth stop
            stopTransition.setByAngle(randomAngle);
            stopTransition.play(); // Play the stop transition
        });

        rotateTransition.play(); // Play the initial spin transition
    }
}
