import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sk.strakas.multiplication.calculator.multiplication.Multiplication;

public class MultiplicationTest {

    private final Multiplication multiplication = new Multiplication();

    @Test
    void testMultiplySmallNumbers() {
        Assertions.assertEquals("2", multiplication.multiplyPositive("1", "2"));
        Assertions.assertEquals("10", multiplication.multiplyPositive("5", "2"));
        Assertions.assertEquals("100", multiplication.multiplyPositive("10", "10"));
        Assertions.assertEquals("246", multiplication.multiplyPositive("123", "2"));
        Assertions.assertEquals("4000", multiplication.multiplyPositive("200", "20"));
    }

    @Test
    void testMultiplyZeroFirst() {
        String number1 = "0";
        String number2 = "123";

        String result = multiplication.multiplyPositive(number1, number2);
        Assertions.assertEquals("0", result);
    }

    @Test
    void testMultiplyZeroSecond() {
        String number1 = "123";
        String number2 = "0";

        String result = multiplication.multiplyPositive(number1, number2);
        Assertions.assertEquals("0", result);
    }

    @Test
    void testMultiplyZeroBoth() {
        String number1 = "0";
        String number2 = "0";

        String result = multiplication.multiplyPositive(number1, number2);
        Assertions.assertEquals("0", result);
    }

    @Test
    void testMultiplyBigNumbers() {
        Assertions.assertEquals("121932631112635269", multiplication.multiplyPositive("123456789", "987654321"));
        Assertions.assertEquals("121932631112635269", multiplication.multiplyPositive("987654321", "123456789"));
        Assertions.assertEquals("137174210013717420998628257899862825790", multiplication.multiplyPositive("11111111111111111111", "12345678901234567890"));
        Assertions.assertEquals("137174210013717420998628257899862825790", multiplication.multiplyPositive("12345678901234567890", "11111111111111111111"));
    }


}
