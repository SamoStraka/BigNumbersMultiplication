package sk.strakas.multiplication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.strakas.multiplication.api.MultiplyApi;
import sk.strakas.multiplication.api.model.AlgorithmType;
import sk.strakas.multiplication.service.MultiplicationService;

@RestController
public class RestMultiplicationController implements MultiplyApi {

    private final MultiplicationService multiplicationService;

    public RestMultiplicationController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @Override
    public ResponseEntity<String> multiplyGet(AlgorithmType algorithm, String number1, String number2) {
        return ResponseEntity.ok(multiplicationService.multiply(algorithm,number1, number2));
    }
}
