package org.example;

public class Calculator {
    public int calculate(String text) {
        if (text == null) {
            return 0;
        }
        if (text.isEmpty()) {
            return 0;
        }

        String[] tokens = text.split(",|:");
        int result = 0;
        for (String s : tokens) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}