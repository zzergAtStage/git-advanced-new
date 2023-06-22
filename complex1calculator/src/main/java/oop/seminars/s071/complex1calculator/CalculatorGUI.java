package oop.seminars.s071.complex1calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import oop.seminars.s071.complex1calculator.model.Calculator;
import oop.seminars.s071.complex1calculator.model.CalculatorInterface;
import oop.seminars.s071.complex1calculator.model.ComplexNumber;
import oop.seminars.s071.complex1calculator.model.FileLogger;


public class CalculatorGUI extends Application {
    private CalculatorInterface calculator;

    public CalculatorGUI() {
        this.calculator = new Calculator();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FileLogger logger = new FileLogger();
        primaryStage.setTitle("Complex Numbers Calculator");
        logger.logEvent(" Complex Numbers Calculator starts...");
        // Create UI elements
        Label num1Label = new Label("Number 1:");
        Label num2Label = new Label("Number 2:");
        Label resultLabel = new Label("Result:");
        TextField num1RealField = new TextField();
        TextField num1ImaginaryField = new TextField();
        TextField num2RealField = new TextField();
        TextField num2ImaginaryField = new TextField();
        TextField resultRealField = new TextField();
        TextField resultImaginaryField = new TextField();
        Button addButton = new Button("Add");
        Button subtractButton = new Button("Subtract");
        Button multiplyButton = new Button("Multiply");
        //Button divideButton = new Button("Divide");

        // Set event handlers for the buttons
        addButton.setOnAction(event -> {
            ComplexNumber num1 = createComplexNumber(num1RealField.getText(), num1ImaginaryField.getText());
            ComplexNumber num2 = createComplexNumber(num2RealField.getText(), num2ImaginaryField.getText());
            ComplexNumber result = calculator.add(num1, num2);
            logger.logEvent("Calculated add: " + result);
            displayResult(result, resultRealField, resultImaginaryField);
        });

        subtractButton.setOnAction(event -> {
            ComplexNumber num1 = createComplexNumber(num1RealField.getText(), num1ImaginaryField.getText());
            ComplexNumber num2 = createComplexNumber(num2RealField.getText(), num2ImaginaryField.getText());
            ComplexNumber result = calculator.subtract(num1, num2);
            logger.logEvent("Calculated substraction: " + result);
            displayResult(result, resultRealField, resultImaginaryField);
        });

        multiplyButton.setOnAction(event -> {
            ComplexNumber num1 = createComplexNumber(num1RealField.getText(), num1ImaginaryField.getText());
            ComplexNumber num2 = createComplexNumber(num2RealField.getText(), num2ImaginaryField.getText());
            ComplexNumber result = calculator.multiply(num1, num2);
            logger.logEvent("Calculated multiplication: " + result);
            displayResult(result, resultRealField, resultImaginaryField);
        });

        // Расставим элементы по панели
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(num1Label, 0, 0);
        gridPane.add(num1RealField, 1, 0);
        gridPane.add(new Label("+"), 2, 0);
        gridPane.add(num1ImaginaryField, 3, 0);
        gridPane.add(num2Label, 0, 1);
        gridPane.add(num2RealField, 1, 1);
        gridPane.add(new Label("+"), 2, 1);
        gridPane.add(num2ImaginaryField, 3, 1);
        gridPane.add(addButton, 0, 2);
        gridPane.add(subtractButton, 1, 2);
        gridPane.add(multiplyButton, 2, 2);
        gridPane.add(resultLabel, 0, 3);
        gridPane.add(resultRealField, 1, 3);
        gridPane.add(new Label("+"), 2, 3);
        gridPane.add(resultImaginaryField, 3, 3);

        // отображение
        primaryStage.setScene(new Scene(gridPane));
        primaryStage.show();
    }

    private ComplexNumber createComplexNumber(String realPart, String imaginaryPart) {
        try {
            double real = Double.parseDouble(realPart);
            double imaginary = Double.parseDouble(imaginaryPart);
            return new ComplexNumber(real, imaginary);
        } catch (NumberFormatException e) {
            showError("Irregular цыфирь!");
            return null;
        }
    }
    private void displayResult(ComplexNumber result, TextField realField, TextField imaginaryField) {
        if (result != null) {
            realField.setText(String.valueOf(result.getRealPart()));
            imaginaryField.setText(String.valueOf(result.getImaginaryPart()));
        } else {
            realField.clear();
            imaginaryField.clear();
        }
    }
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
