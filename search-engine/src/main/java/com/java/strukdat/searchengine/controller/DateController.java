package com.java.strukdat.searchengine.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateController {

    @FXML
    private Text dayText;

    @FXML
    private Text dateText;

    @FXML
    private Text yearText;

    @FXML
    private Text todayText;

    public void initialize() {
        // Mendapatkan tanggal sekarang
        LocalDate now = LocalDate.now();

        // Format hari (contoh: Sunday)
        String day = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        dayText.setText(day);

        // Format tanggal (contoh: 11th December)
        int dayOfMonth = now.getDayOfMonth();
        String daySuffix = getDaySuffix(dayOfMonth);
        String month = now.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        dateText.setText(dayOfMonth + daySuffix + " " + month);

        // Format tahun (contoh: 2024)
        yearText.setText(String.valueOf(now.getYear()));

        // Teks "Today" tetap tidak berubah
        todayText.setText("Today");
    }

    private String getDaySuffix(int dayOfMonth) {
        if (dayOfMonth >= 11 && dayOfMonth <= 13) {
            return "th"; // untuk 11, 12, 13
        }
        switch (dayOfMonth % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }
}
