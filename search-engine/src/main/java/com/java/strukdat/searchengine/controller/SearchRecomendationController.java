package com.java.strukdat.searchengine.controller;

import java.io.IOException;

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
    @FXML

    private Gimmick<String> gimmick;

    private String keyword;

    @FXML
    public void initialize() {
        // Pastikan rootPane telah terhubung
        if (rootPane == null) {
            System.err.println("rootPane belum diinisialisasi! Periksa FXML.");
        } else {
            // Inisialisasi Gimmick setelah rootPane tersedia
            gimmick = new Gimmick<>(rootPane);
        }
    }

    // Method untuk menerima keyword
    public void setKeyword(String keyword) {
        this.keyword = keyword;
        if (keyword != null && !keyword.isEmpty()) {
            if (gimmick != null) {
                // Menampilkan hasil gimmick
                String result = gimmick.gimmick(keyword);
                System.out.println("Hasil Gimmick: " + result);
            } else {
                System.err.println("Gimmick belum diinisialisasi!");
            }
        }
    }

    @FXML
    public void onActionSearchButton(ActionEvent event) throws IOException {
        // Ganti scene di window yang sama
        Stage currentStage = (Stage) searchField.getScene().getWindow(); // Dapatkan stage saat ini
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/java/strukdat/searchengine/view/Updated-Search-Result.fxml"));
        Parent root = loader.load();

        // Atur scene baru ke stage saat ini
        currentStage.setScene(new Scene(root));
    }
}
