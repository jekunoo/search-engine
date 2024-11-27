package com.java.util;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class Gimmick<K> implements GimmickAction<K> {

    private Pane rootPane;

    public Gimmick(Pane rootPane) {
        this.rootPane = rootPane;
    }
    
    @Override
    public String gimmick(K key){
        // List<String> list = Arrays.asList("Apple", "anjing", "Ayam", "Apel", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Bokep");
        // Random rand = new Random();
        // String selectedItem = list.get(rand.nextInt(list.size()));

        String keyword = key.toString().toLowerCase();
        String result = "";

        switch (keyword) {
            case "apple":
                result= "Display apple animation.";
                triggerAppleAnimation();
                break;
            default:
                break;
        }

        return result;
    }

    private void triggerAppleAnimation(){
        Image appleImage = new Image(getClass().getResourceAsStream("/com/java/strukdat/searchengine/view/img/apple.png"));
        ImageView appleView = new ImageView(appleImage);

        // setting ukuran gambar  dan mengacak posisi
        appleView.setFitWidth(50);
        appleView.setFitHeight(50);
        appleView.setX(Math.random() * (rootPane.getWidth()-50));
        appleView.setY(0);

        // menambahkan gambar ke rootPane
        rootPane.getChildren().add(appleView);

        // Animation untuk jatuh
        TranslateTransition transition = new TranslateTransition(Duration.seconds(5), appleView);
        transition.setFromY(0);
        transition.setToY(rootPane.getHeight()-50);

        // menghapus gambar setelah animasi selesai
        transition.setOnFinished(event -> {
            rootPane.getChildren().remove(appleView);
        });

        transition.play();
    }
}
