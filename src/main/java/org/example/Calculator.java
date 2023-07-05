package org.example;

import java.util.ArrayList;
import java.util.Stack;

public class Calculator {
    public int calculate(String text) {
        if (text == null) {
            return 0;
        }
        if (text.isEmpty()) {
            return 0;
        }

        return stackCalc(parseInput(text));

    }

    public String[] parseInput(String input) {
        return input.split(" ");
    }

    public int stackCalc(String[] tokens) {
        int result = 0;
        int prev = -1;

        for (String token : tokens) {
            if (isNumber(token)) {
                if (prev == -1) {
                    result += Integer.parseInt(token);
                } else {
                    switch (prev){
                        case 0 -> result += Integer.parseInt(token);
                        case 1 -> result -= Integer.parseInt(token);
                        case 2 -> result *= Integer.parseInt(token);
                        case 3 -> result /= Integer.parseInt(token);
                    }
                }
            } else {
                prev = switch (token) {
                    case "+" -> 0;
                    case "-" -> 1;
                    case "*" -> 2;
                    case "/" -> 3;
                    default -> -1;
                };
            }
        }
        return result;
    }

    public boolean isNumber(String strValue) {
        return strValue != null && strValue.matches("[-+]?\\d*\\.?\\d+");
    }
}