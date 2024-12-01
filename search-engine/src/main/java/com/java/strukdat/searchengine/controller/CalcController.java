package com.java.strukdat.searchengine.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalcController {
    @FXML
    private TextField display;

    private String currentOperator = "";
    private double firstOperand = 0;
    private boolean isNewInput = true;

    @FXML
    public void handleNumber(javafx.event.ActionEvent event) {
        String number = ((javafx.scene.control.Button) event.getSource()).getText();
        if (isNewInput) {
            display.setText(number);
            isNewInput = false;
        } else {
            display.setText(display.getText() + number);
        }
    }

    @FXML
    public void handleOperator(javafx.event.ActionEvent event) {
        String operator = ((javafx.scene.control.Button) event.getSource()).getText();
        firstOperand = Double.parseDouble(display.getText());
        currentOperator = operator;
        isNewInput = true;
    }

    @FXML
    public void handleEquals() {
        double secondOperand = Double.parseDouble(display.getText());
        double result;

        switch (currentOperator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "x":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
            default:
                return;
        }

        display.setText(String.valueOf(result));
        isNewInput = true;
    }

    @FXML
    public void handleClear() {
        display.setText("");
        firstOperand = 0;
        currentOperator = "";
        isNewInput = true;
    }

    @FXML
    public void handleDelete() {
        String currentText = display.getText();
        if (!currentText.isEmpty()) {
            display.setText(currentText.substring(0, currentText.length() - 1));
        }
    }
}
