package sk.strakas.multiplication.calculator;

import sk.strakas.multiplication.calculator.multiplication.Multiplication;
import sk.strakas.multiplication.validation.NumberValidator;


public class CalculatorFromScratch {

    private final Multiplication multiplication = new Multiplication();

    /**
     * Multiplies two numbers given as strings.
     * Handles negative numbers and strips leading zeros.
     *
     * @param number1 the first number as a string
     * @param number2 the second number as a string
     * @return the multiplication result as a string
     */
    public String multiply(String number1, String number2) {

        boolean negativeResult = false;

        // Check and strip negative sign from number1.
        if (number1.startsWith("-")) {
            negativeResult = true;
            number1 = number1.substring(1);
        }

        // Check and strip negative sign from number2.
        if (number2.startsWith("-")) {
            negativeResult = !negativeResult;
            number2 = number2.substring(1);
        }

        number1 = adjustNumber(number1);
        number2 = adjustNumber(number2);

        if (number1.equals("0") || number2.equals("0")) {
            return "0";
        }

        if (!NumberValidator.validate(number1) || !NumberValidator.validate(number2)) {
            throw new IllegalArgumentException("Invalid input");
        }

        String positiveResult = multiplication.multiplyPositive(number1, number2);
        return negativeResult ? "-" + positiveResult : positiveResult;
    }

    /**
     * Adjusts the number by removing leading zeros and white spaces.
     *
     * @param number the number to adjust
     * @return the adjusted number
     */
    private String adjustNumber(String number) {
        number = number.replaceAll("\\s", "");
        number = stripLeadingZeros(number);
        return number;
    }

    /**
     * Strips leading zeros from the number.
     *
     * @param number the number to strip
     * @return the number without leading zeros
     */
    private String stripLeadingZeros(String number) {
        int i = 0;
        while (i < number.length() - 1 && number.charAt(i) == '0') {
            i++;
        }
        return number.substring(i);
    }

}
