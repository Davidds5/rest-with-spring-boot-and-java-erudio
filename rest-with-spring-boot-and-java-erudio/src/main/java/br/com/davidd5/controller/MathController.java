package br.com.davidd5.controller;

import br.com.davidd5.exception.UnsupportedMathOperationExceptions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/math")
@RestController
public class MathController {


    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
           @PathVariable("numberOne") String numberOne,
           @PathVariable("numberTwo") String numberTwo)throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationExceptions("Please set a numeric value");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
           @PathVariable("numberOne") String numberOne,
           @PathVariable("numberTwo") String numberTwo)throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationExceptions("Please set a numeric value");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }


    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
           @PathVariable("numberOne") String numberOne,
           @PathVariable("numberTwo") String numberTwo)throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationExceptions("Please set a numeric value");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
           @PathVariable("numberOne") String numberOne,
           @PathVariable("numberTwo") String numberTwo)throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationExceptions("Please set a numeric value");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
           @PathVariable("numberOne") String numberOne,
           @PathVariable("numberTwo") String numberTwo)throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationExceptions("Please set a numeric value");
        return (convertToDouble(numberOne) + convertToDouble(numberTwo))/ 2;
    }

    @RequestMapping("/squareRoot/{number}")
    public Double squareRoot(
           @PathVariable("number") String number)
            throws Exception{

        if (!isNumeric(number))
            throw new UnsupportedMathOperationExceptions("Please set a numeric value");
        Double result = Math.sqrt(convertToDouble(number));
        return result;
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationExceptions("Please set a numeric value");
        String number = strNumber.replace(", ", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;

        String number = strNumber.replace(", ", ".");  // trocar toda ocorrencia de virgula por ponto
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

        }
    }

