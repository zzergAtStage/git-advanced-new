package oop.seminars.s071.complex1calculator.model;

public class CalculatorModel {
    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        // Perform addition of two complex numbers
        double realPart = num1.getRealPart() + num2.getRealPart();
        double imaginaryPart = num1.getImaginaryPart() + num2.getImaginaryPart();
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber subtract(ComplexNumber num1, ComplexNumber num2) {
        // Perform subtraction of two complex numbers
        double realPart = num1.getRealPart() - num2.getRealPart();
        double imaginaryPart = num1.getImaginaryPart() - num2.getImaginaryPart();
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        // Perform multiplication of two complex numbers
        double realPart = (num1.getRealPart() * num2.getRealPart())
                - (num1.getImaginaryPart() * num2.getImaginaryPart());
        double imaginaryPart = (num1.getRealPart() * num2.getImaginaryPart())
                + (num1.getImaginaryPart() * num2.getRealPart());
        return new ComplexNumber(realPart, imaginaryPart);
    }
}
