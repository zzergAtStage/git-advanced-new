package oop.seminars.s071.complex1calculator.controllers;

import oop.seminars.s071.complex1calculator.model.Calculator;

public class CalculatorDecorator {
    protected Calculator calculator;

    public CalculatorDecorator(Calculator calculator) {
        this.calculator = calculator;
    }
}
