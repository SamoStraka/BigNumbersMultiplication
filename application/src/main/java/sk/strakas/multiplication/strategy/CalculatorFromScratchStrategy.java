package sk.strakas.multiplication.strategy;


import sk.strakas.multiplication.calculator.CalculatorFromScratch;

public class CalculatorFromScratchStrategy implements MultiplicationStrategy{
    @Override
    public String multiply(String number1, String number2) {
        var calculator = new CalculatorFromScratch();
        return calculator.multiply(number1, number2);
    }
}
