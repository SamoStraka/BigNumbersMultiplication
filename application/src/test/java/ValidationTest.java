import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sk.strakas.multiplication.validation.NumberValidator;

public class ValidationTest {
    @Test
    void testNumberValidatorNumber() {
        Assertions.assertTrue(NumberValidator.validate("123"));
        Assertions.assertTrue(NumberValidator.validate("123456789"));
        Assertions.assertTrue(NumberValidator.validate("0"));
        Assertions.assertTrue(NumberValidator.validate("132590"));
    }

    @Test
    void testNumberValidatorNotNumber() {
        Assertions.assertFalse(NumberValidator.validate("abc"));
        Assertions.assertFalse(NumberValidator.validate("123abc"));
        Assertions.assertFalse(NumberValidator.validate("abc123"));
        Assertions.assertFalse(NumberValidator.validate("123abc123"));
    }

    @Test
    void testNumberValidatorNegative() {
        Assertions.assertTrue(NumberValidator.validate("-123"));
    }

    @Test
    void testNumberValidatorEmpty() {
        Assertions.assertFalse(NumberValidator.validate(""));
    }

    @Test
    void testNumberValidatorNull() {
        Assertions.assertFalse(NumberValidator.validate(null));
    }

    @Test
    void testNumberValidatorSpace() {
        Assertions.assertFalse(NumberValidator.validate(" "));
    }

    @Test
    void testNumberValidatorSpecialCharacters() {
        Assertions.assertFalse(NumberValidator.validate("!@#$%^&*()"));
    }

}
