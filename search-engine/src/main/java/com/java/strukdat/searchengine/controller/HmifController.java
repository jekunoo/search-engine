package com.java.strukdat.searchengine.controller;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class HmifController {

    @FXML
    private ImageView hmifImg;

    @FXML
    public void initialize() {
        startImageRotation();
    }

    // Method untuk memulai rotasi gambar
    private void startImageRotation() {
        // Membuat animasi rotasi
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(hmifImg);
        rotateTransition.setDuration(Duration.seconds(2)); // Durasi satu rotasi penuh
        rotateTransition.setByAngle(360); // Sudut rotasi (360 derajat)
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE); // Rotasi tanpa batas
        rotateTransition.setAutoReverse(false); // Tidak membalik arah rotasi

        // Memulai animasi
        rotateTransition.play();
    }
}
