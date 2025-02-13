package sk.strakas.multiplication.calculator.multiplication;


import java.util.List;

/**
 * Multiplies two positive numbers represented as strings.
 */
public class Multiplication {
    /**
     * Multiplies two positive numbers represented as strings.
     *
     * @param number1 the first positive number as a string
     * @param number2 the second positive number as a string
     * @return the multiplication result as a string
     */
    public String multiplyPositive(String number1, String number2) {
        PartialResultGroup calculation = new PartialResultGroup();

        // Convert each number into an array of its digits.
        int[] number1AsIntArr = number1.chars().map(Character::getNumericValue).toArray();
        int[] number2AsIntArr = number2.chars().map(Character::getNumericValue).toArray();

        // For each digit in number2 (right-to-left), multiply by number1.
        for (int n2Index = number2.length() - 1; n2Index >= 0; n2Index--) {
            PartialResult result = new PartialResult();
            int carry = 0;
            for (int n1Index = number1.length() - 1; n1Index >= 0; n1Index--) {
                int product = number1AsIntArr[n1Index] * number2AsIntArr[n2Index] + carry;
                result.addFirst(product % 10);
                carry = product / 10;
            }
            if (carry > 0) {
                result.addFirst(carry);
            }
            // Append zeros corresponding to the current digit's place.
            result.addZerosToTheEnd(number2.length() - 1 - n2Index);
            calculation.add(result);
        }

        // Sum up all the partial results to get the final product.
        List<Integer> resultDigits = calculation.sum();
        StringBuilder sb = new StringBuilder();
        for (Integer digit : resultDigits) {
            sb.append(digit);
        }
        return sb.toString();
    }
}
