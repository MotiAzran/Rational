package com.moti;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        // Get first fraction
        System.out.print("Enter numerator: ");
        int numerator = stdin.nextInt();
        System.out.print("Enter denominator: ");
        int denominator = 0;
        do {
            denominator = stdin.nextInt();
            if (0 == denominator) {
                System.out.println("Error: denominator can't be zero!");
            }
        } while (0 == denominator);

        Rational frac1 = new Rational(numerator, denominator);

        // Get second fraction
        System.out.print("Enter numerator: ");
        numerator = stdin.nextInt();
        System.out.print("Enter denominator: ");
        do {
            denominator = stdin.nextInt();
            if (0 == denominator) {
                System.out.println("Error: denominator can't be zero!");
            }
        } while (0 == denominator);

        Rational frac2 = new Rational(numerator, denominator);

        System.out.printf("%s > %s: %s\n", frac1, frac2, frac1.greaterThan(frac2)? "True" : "False");
        System.out.printf("%s == %s: %s\n", frac1, frac2, frac1.equals(frac2)? "True" : "False");
        System.out.printf("%s + %s = %s\n", frac1, frac2, frac1.plus(frac2).reduce());
        System.out.printf("%s - %s = %s\n", frac1, frac2, frac1.minus(frac2).reduce());
        System.out.printf("%s * %s = %s\n", frac1, frac2, frac1.multiply(frac2).reduce());
    }
}
