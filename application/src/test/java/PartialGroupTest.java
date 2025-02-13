import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sk.strakas.multiplication.calculator.multiplication.PartialResult;
import sk.strakas.multiplication.calculator.multiplication.PartialResultGroup;

import java.util.ArrayList;

public class PartialGroupTest {
    @Test
    void testSimpleSum() {
        var partialResult1 = new PartialResult();
        partialResult1.addFirst(123);

        var partialResult2 = new PartialResult();
        partialResult2.addFirst(123);

        var group = new PartialResultGroup();
        group.add(partialResult1);
        group.add(partialResult2);

        var expected = new ArrayList<Integer>();
        expected.add(2);
        expected.add(4);
        expected.add(6);

        Assertions.assertEquals(expected, group.sum());
    }

    @Test
    void testZeros() {
        var partialResult1 = new PartialResult();
        partialResult1.addFirst(0);

        var partialResult2 = new PartialResult();
        partialResult2.addFirst(0);

        var group = new PartialResultGroup();
        group.add(partialResult1);
        group.add(partialResult2);

        var expected = new ArrayList<Integer>();
        expected.add(0);

        Assertions.assertEquals(expected, group.sum());
    }

    @Test
    void testSumWithCarry() {
        var partialResult1 = new PartialResult();
        partialResult1.addFirst(123);

        var partialResult2 = new PartialResult();
        partialResult2.addFirst(923);

        var group = new PartialResultGroup();
        group.add(partialResult1);
        group.add(partialResult2);

        var expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(0);
        expected.add(4);
        expected.add(6);

        Assertions.assertEquals(expected, group.sum());
    }
}
