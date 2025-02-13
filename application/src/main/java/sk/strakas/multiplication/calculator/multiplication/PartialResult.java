package sk.strakas.multiplication.calculator.multiplication;

import java.util.ArrayList;

/**
 * Represents a partial result of a multiplication.
 * <p>
 *    1234
 *      54
 *  * ----
 *    4936 --> Partial result
 *   61700 --> Partial result
 *  + ----
 *   66636
 */
public class PartialResult {
    ArrayList<Integer> result;

    public PartialResult() {
        this.result = new ArrayList<>();
    }

    public void addFirst(int number) {
        // handle numbers greater than 9
        var carry = number / 10;
        result.addFirst(number % 10);
        while (carry > 0) {
            result.addFirst(carry % 10);
            carry /= 10;
        }
    }

    public int get(int index) {
        return result.get(index);
    }

    public int size() {
        return result.size();
    }

    public void addZerosToTheEnd(int numberOfZeros) {
        for (int i = 0; i < numberOfZeros; i++) {
            result.add(0);
        }
    }
}
