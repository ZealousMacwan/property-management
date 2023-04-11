package com.zealous.propertymanagement.controller;

import com.zealous.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator") //class level mapping of URL to a controller class
public class CalculatorController {
    @GetMapping("/add") //method level mapping of aURL to a controller function
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2){
        return num1+num2;
    }

    @GetMapping("/substract/{num1}/{num2}")
    public Double substract(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2){
        Double result = null;
        if(num1>num2){
            result = num1-num2;
        }else{
            result = num2-num1;
        }
        return result;
    }

    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null;
        result = calculatorDTO.getNum1()* calculatorDTO.getNum2()* calculatorDTO.getNum3()* calculatorDTO.getNum4();

        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
