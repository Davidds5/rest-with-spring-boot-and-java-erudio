package br.com.davidd5.request.converter;

import br.com.davidd5.exception.UnsupportedMathOperationExceptions;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationExceptions("Please set a numeric value");
        String number = strNumber.replace(", ", ".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;

        String number = strNumber.replace(", ", ".");  // trocar toda ocorrencia de virgula por ponto
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
