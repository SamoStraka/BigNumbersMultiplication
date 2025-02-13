package sk.strakas.multiplication.service;

import org.springframework.stereotype.Service;
import sk.strakas.multiplication.api.model.AlgorithmType;
import sk.strakas.multiplication.calculator.CalculatorFromScratch;

import java.math.BigDecimal;

/**
 * Service for multiplication.
 */
@Service
public class MultiplicationService {

    private final CalculatorFromScratch calculator;

    public MultiplicationService(CalculatorFromScratch calculator) {
        this.calculator = calculator;
    }


    /**
     * Multiplies two numbers using the specified algorithm.
     *
     * @param algorithmType the algorithm to use
     * @param number1       the first number
     * @param number2       the second number
     * @return the result of the multiplication
     */
    public String multiply(AlgorithmType algorithmType, String number1, String number2) {
        if (algorithmType == AlgorithmType.ALG1) {
            var result = multiplyUsingBigDecimal(number1, number2);
            return result.toString();
        } else {
            return calculator.multiply(number1, number2);
        }
    }

    private BigDecimal multiplyUsingBigDecimal(String number1, String number2) {
        return new BigDecimal(number1).multiply(new BigDecimal(number2));
    }
}
