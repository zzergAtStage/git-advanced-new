package oop.seminars.s071.complex1calculator.model;

public class Calculator implements CalculatorInterface {
    private CalculatorModel model;
    private FileLogger logger;

    public Calculator() {
        this.model = new CalculatorModel();
    }

    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        return model.add(num1, num2);
    }

    public ComplexNumber subtract(ComplexNumber num1, ComplexNumber num2) {
        return model.subtract(num1, num2);
    }

    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        return model.multiply(num1, num2);
    }
}
