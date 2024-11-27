package com.java.strukdat.searchengine.controller;

import java.io.IOException;

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

    private Gimmick<String> gimmick;

    @FXML
    public void initialize() {
        
        // inisiasi gimmick
        gimmick = new Gimmick<>(rootPane);
    }

    // method menerima keyword
    public void setKeyword(String keyword){
        if (keyword != null && !keyword.isEmpty()) {
            // menampilkan hasil gimmick
            String result = gimmick.gimmick(keyword);
            System.out.println(result);
            
        }
    }
    @FXML
    public void onActionSearchButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/java/strukdat/searchengine/view/search-recomendation.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();

        stage.setScene(new Scene(root));
        stage.show();
    }

    
}
