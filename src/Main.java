/*
 * Moti Azran
 */

import java.util.Scanner;

/**
 * The main class program
 */
public class Main {

    /**
     * The program entry point,
     * Get from the user two rational numbers
     * and prints the sum, difference, product, ...
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Rational frac1 = getRationalFromUser();
        Rational frac2 = getRationalFromUser();

        // Print fractions relations
        System.out.printf("%s > %s: %s\n", frac1, frac2, frac1.greaterThan(frac2)? "True" : "False");
        System.out.printf("%s == %s: %s\n", frac1, frac2, frac1.equals(frac2)? "True" : "False");
        System.out.printf("%s + %s = %s\n", frac1, frac2, frac1.plus(frac2).reduce());
        System.out.printf("%s - %s = %s\n", frac1, frac2, frac1.minus(frac2).reduce());
        System.out.printf("%s * %s = %s\n", frac1, frac2, frac1.multiply(frac2).reduce());
    }

    public static Rational getRationalFromUser() {
        Scanner stdin = new Scanner(System.in);

        System.out.print("Enter numerator: ");
        int numerator = stdin.nextInt();
        int denominator = 0;
        do {
            System.out.print("Enter denominator: ");
            denominator = stdin.nextInt();
            if (0 == denominator) {
                System.out.println("Error: denominator can't be zero!");
            }
        } while (0 == denominator);

        return new Rational(numerator, denominator);
    }
}
