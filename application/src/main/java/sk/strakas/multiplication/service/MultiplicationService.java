package sk.strakas.multiplication.service;

import org.springframework.stereotype.Service;
import sk.strakas.multiplication.api.model.AlgorithmType;
import sk.strakas.multiplication.strategy.BigDecimalMultiplicationStrategy;
import sk.strakas.multiplication.strategy.CalculatorFromScratchStrategy;
import sk.strakas.multiplication.strategy.MultiplicationStrategy;

/**
 * Service for multiplication.
 */
@Service
public class MultiplicationService {

    public MultiplicationService() {
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
        var strategy = determineStrategy(algorithmType);

        return strategy.multiply(number1, number2);
    }

    private MultiplicationStrategy determineStrategy(AlgorithmType algorithmType) {
        if (algorithmType == AlgorithmType.ALG1) {
            return new BigDecimalMultiplicationStrategy();
        }
        return new CalculatorFromScratchStrategy();
    }
}
