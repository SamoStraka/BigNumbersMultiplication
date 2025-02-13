package sk.strakas.multiplication.strategy;

import java.math.BigDecimal;

/**
 * Multiplies two numbers using the BigDecimal class.
 */
public class BigDecimalMultiplicationStrategy implements MultiplicationStrategy{

    @Override
    public String multiply(String number1, String number2) {
        var resultAsBigDecimal = new BigDecimal(number1).multiply(new BigDecimal(number2));
        return resultAsBigDecimal.toString();
    }
}
