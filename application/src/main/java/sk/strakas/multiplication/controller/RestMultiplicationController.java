package sk.strakas.multiplication.controller;

import org.springframework.http.ResponseEntity;
import sk.strakas.multiplication.api.MultiplyApi;
import sk.strakas.multiplication.api.model.AlgorithmType;

public class RestMultiplicationController implements MultiplyApi {

    @Override
    public ResponseEntity<String> multiplyGet(AlgorithmType algorithm, String number1, String number2) {
        return null;
    }
}
