import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sk.strakas.multiplication.calculator.CalculatorFromScratch;

public class CalculatorTest {

    private final CalculatorFromScratch calculator = new CalculatorFromScratch();

    @Test
    void testMultiplyPositiveNumbers() {
        Assertions.assertEquals("12340", calculator.multiply("1", "12340"));
        Assertions.assertEquals("121932631112635269", calculator.multiply("123456789", "987654321"));
        Assertions.assertEquals("121932631112635269", calculator.multiply("987654321", "123456789"));
        Assertions.assertEquals("137174210013717420998628257899862825790", calculator.multiply("11111111111111111111", "12345678901234567890"));
        Assertions.assertEquals("137174210013717420998628257899862825790", calculator.multiply("12345678901234567890", "11111111111111111111"));
    }

    @Test
    void testMutiplyNegativeNumbers() {
        Assertions.assertEquals("12340", calculator.multiply("-1", "-12340"));
        Assertions.assertEquals("121932631112635269", calculator.multiply("-123456789", "-987654321"));
        Assertions.assertEquals("121932631112635269", calculator.multiply("-987654321", "-123456789"));
        Assertions.assertEquals("137174210013717420998628257899862825790", calculator.multiply("-11111111111111111111", "-12345678901234567890"));
        Assertions.assertEquals("137174210013717420998628257899862825790", calculator.multiply("-12345678901234567890", "-11111111111111111111"));
    }

    @Test
    void testMutiplyNegativeAndPositiveNumbers() {
        Assertions.assertEquals("-12340", calculator.multiply("1", "-12340"));
        Assertions.assertEquals("-121932631112635269", calculator.multiply("-123456789", "987654321"));
        Assertions.assertEquals("-121932631112635269", calculator.multiply("987654321", "-123456789"));
        Assertions.assertEquals("-137174210013717420998628257899862825790", calculator.multiply("11111111111111111111", "-12345678901234567890"));
        Assertions.assertEquals("-137174210013717420998628257899862825790", calculator.multiply("-12345678901234567890", "11111111111111111111"));
    }

    @Test
    void testMultiplyZeros() {
        Assertions.assertEquals("0", calculator.multiply("0", "-20"));
        Assertions.assertEquals("0", calculator.multiply("0", "20"));
        Assertions.assertEquals("0", calculator.multiply("-20", "0"));
        Assertions.assertEquals("0", calculator.multiply("20", "0"));
        Assertions.assertEquals("0", calculator.multiply("0", "0"));
    }

    @Test
    void testMultiplyWithZeroInNumber() {
        Assertions.assertEquals("-40", calculator.multiply("02", "-20"));
        Assertions.assertEquals("400", calculator.multiply("20", "020"));
        Assertions.assertEquals("0", calculator.multiply("-20", "00000"));
        Assertions.assertEquals("400", calculator.multiply("020", "020"));
    }

    @Test
    void testWithSpaces() {
        Assertions.assertEquals("-40", calculator.multiply(" 2", "-20"));
        Assertions.assertEquals("400", calculator.multiply("20", " 020"));
        Assertions.assertEquals("0", calculator.multiply("-20", " 00000"));
        Assertions.assertEquals("400", calculator.multiply("020", "020 "));
        Assertions.assertEquals("4000000", calculator.multiply("2 000", "2 000"));
    }

    @Test
    void testMultiplyInvalidInput() {
        String number1 = "123";
        String number2 = "abc";

        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.multiply(number1, number2));
    }
}
