package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(text));
    }
}