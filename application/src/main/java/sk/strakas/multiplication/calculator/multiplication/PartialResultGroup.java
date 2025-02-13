package sk.strakas.multiplication.calculator.multiplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a group of partial results of a multiplication.
 * <p></p>
 *    1234
 *      54
 *  * ----
 *    4936 --|
 *           |--> Partinal group
 *   61700 --|
 *  + ----
 *   66636
 */
public class PartialResultGroup {
    private int maxResultSize;
    private final List<PartialResult> partialResults;

    public PartialResultGroup() {
        this.partialResults = new ArrayList<>();
    }

    public void add(PartialResult partialResult) {
        partialResults.add(partialResult);
        maxResultSize = Math.max(maxResultSize, partialResult.size());
    }

    public PartialResult get(int index) {
        return partialResults.get(index);
    }

    public int size() {
        return partialResults.size();
    }

    /**
     * Sums up all the partial results.
     * <p></p>
     * 1 5 7 6 5 6 - Partial result 1
     *  +
     *  _ _ 3 5 6 7 - Partial result 2
     *  +
     *  _ _ _ _ 2 3 - Partial result 3
     *  =
     *  1 9 1 2 4 6 - Result
     * @return the sum of all the partial results
     */
    public List<Integer> sum() {
        var result = new ArrayList<Integer>();
        int carry = 0;

        for (int resultIndexFromEnd = 0; resultIndexFromEnd < maxResultSize; resultIndexFromEnd++) {
            int sum = carry;

            for (PartialResult partialResult : partialResults) {
                if (resultIndexFromEnd < partialResult.size()) {
                    sum += partialResult.get(partialResult.size() - 1 - resultIndexFromEnd);
                }
            }
            result.add(sum % 10);
            carry = sum / 10;
        }

        while (carry > 0) {
            result.add(carry % 10);
            carry /= 10;
        }

        while (result.size() > 1 && result.getLast() == 0) {
            result.removeLast();
        }

        return result.reversed();
    }
}
