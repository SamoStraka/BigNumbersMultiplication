package sk.strakas.multiplication.cmd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sk.strakas.multiplication.api.model.AlgorithmType;
import sk.strakas.multiplication.service.MultiplicationService;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    private final MultiplicationService multiplicationService;

    public AppCommandLineRunner(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    /**
     * This method is called when the application is started.
     * @param args the command-line arguments
     */
    @Override
    public void run(String... args) {
        // Expected : --alg1 12345678901234567890 11111111111111111111
        if (args.length >= 3) {
            try {
                String algorithmFlag = args[0];
                String algorithmName = algorithmFlag.replaceFirst("^-+", "");
                AlgorithmType algorithm = AlgorithmType.valueOf(algorithmName.toUpperCase());

                String number1 = args[1];
                String number2 = args[2];

                String result = multiplicationService.multiply(algorithm, number1, number2);

                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.err.println("Error during multiplication: " + e.getMessage());
            }
            System.exit(0);
        }
    }
}