import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sk.strakas.multiplication.api.model.AlgorithmType;
import sk.strakas.multiplication.service.MultiplicationService;

public class MultiplicationServiceTest {
    private MultiplicationService multiplicationService;

    @BeforeEach
    void setUp() {
        multiplicationService = new MultiplicationService();
    }

    @Test
    void testMultiplyAlg1() {
        var result1 = multiplicationService.multiply(AlgorithmType.ALG1, "123", "123");
        Assertions.assertEquals("15129", result1);

        var result2 = multiplicationService.multiply(AlgorithmType.ALG1, "12345678912345678912345678912", "12345678912345678912345678912");
        Assertions.assertEquals("152415787806736785461057783106843499052522501398201503744", result2);

        var result3 = multiplicationService.multiply(AlgorithmType.ALG1, "-12345678912345678912345678912", "12345678912345678912345678912");
        Assertions.assertEquals("-152415787806736785461057783106843499052522501398201503744", result3);
    }

    @Test
    void testMultiplyAlg2() {
        var result1 = multiplicationService.multiply(AlgorithmType.ALG2, "123", "123");
        Assertions.assertEquals("15129", result1);

        var result2 = multiplicationService.multiply(AlgorithmType.ALG2, "12345678912345678912345678912", "12345678912345678912345678912");
        Assertions.assertEquals("152415787806736785461057783106843499052522501398201503744", result2);

        var result3 = multiplicationService.multiply(AlgorithmType.ALG2, "-12345678912345678912345678912", "12345678912345678912345678912");
        Assertions.assertEquals("-152415787806736785461057783106843499052522501398201503744", result3);
    }

    @Test
    void testMultiplyEqualsUsingBothAlgorithms() {
        var result1 = multiplicationService.multiply(AlgorithmType.ALG1, "13298428391512387479182", "892137481927387123894789213748971283947");
        var result2 = multiplicationService.multiply(AlgorithmType.ALG2, "13298428391512387479182", "892137481927387123894789213748971283947");

        Assertions.assertEquals(result1, result2);
    }
}
