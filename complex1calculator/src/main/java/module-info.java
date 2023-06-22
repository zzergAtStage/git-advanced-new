module oop.seminars.s071.complex1calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens oop.seminars.s071.complex1calculator to javafx.fxml;
    exports oop.seminars.s071.complex1calculator;
}