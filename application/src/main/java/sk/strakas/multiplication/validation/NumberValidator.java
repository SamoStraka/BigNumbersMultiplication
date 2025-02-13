package sk.strakas.multiplication.validation;

/**
 * A utility class for validating if a given string represents a valid number.
 */
public class NumberValidator {

    /**
     * Validates if the provided string is a valid number.
     * A valid number is defined as a non-null, non-empty string that optionally starts with a '-'
     * and is followed by one or more digits.
     *
     * @param number the string to validate
     * @return true if the string is a valid number, false otherwise
     */
    public static boolean validate(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }

        int validationIndexStart = 0;

        if (number.charAt(0) == '-') {
            validationIndexStart = 1;
        }

        for (int index = validationIndexStart; index < number.length(); index++) {
            if (!Character.isDigit(number.charAt(index))) {
                return false;
            }
        }

        return true;
    }
}
