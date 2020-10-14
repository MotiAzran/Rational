/*
 * Moti Azran
 *
 * Implements rational number class
 */
package com.moti;

/**
 * Rational number class.
 * The numerator is an integer
 * and the denominator is a positive integer
 */
public class Rational {
    private final int _numerator;
    private final int _denominator;

    /**
     * Initialize the rational number,
     * if the denominator is equal to 0
     * or less than 0, the number initializes to 0
     * @param numerator the rational numerator
     * @param denominator the rational denominator
     */
    public Rational(int numerator, int denominator) {
        if (denominator <= 0) {
            // Invalid denominator set the fraction to zero
            _numerator = 0;
            _denominator = 1;
        } else {
            _numerator = numerator;
            _denominator = denominator;
        }
    }

    /**
     * Checks if this number is greater than
     * the parameter number
     * @param frac another rational for comparison
     * @return true if this number is greater than frac number, otherwise false
     */
    public boolean greaterThan(Rational frac) {
        return (_numerator * frac._denominator) > (frac._numerator * _denominator);
    }

    /**
     * Checks if this number is equal to the
     * frac number
     * @param frac another rational for comparison
     * @return true if the numbers are equals, otherwise false
     */
    public boolean equals(Rational frac) {
        return (_numerator * frac._denominator) == (frac._numerator * _denominator);
    }

    /**
     * Add this number to the frac number
     * @param frac number to add
     * @return The sum of both rationals
     */
    public Rational plus(Rational frac) {
        // Calculate the numerator and denominator of the sum
        int sumNumerator = (_numerator * frac._denominator) + (frac._numerator * _denominator);
        int sumDenominator = _denominator * frac._denominator;

        return new Rational(sumNumerator, sumDenominator);
    }

    /**
     * reduce frac number from this number
     * @param frac number to reduce
     * @return The difference of both rationals
     */
    public Rational minus(Rational frac) {
        // Calculate the numerator and denominator of the difference
        int diffNumerator = (_numerator * frac._denominator) - (frac._numerator * _denominator);
        int diffDenominator = _denominator * frac._denominator;

        return new Rational(diffNumerator, diffDenominator);
    }

    /**
     * Multiply this number to the frac number
     * @param frac number to multiply
     * @return The product of both rationals
     */
    public Rational multiply(Rational frac) {
        // Calculate the numerator and denominator of the product
        int prodNumerator = _numerator * frac._numerator;
        int prodDenominator = _denominator * frac._denominator;

        return new Rational(prodNumerator, prodDenominator);
    }

    /**
     * Get the rational numerator
     * @return the rational numerator
     */
    public int getNumerator() {
        return _numerator;
    }

    /**
     * Get the rational denominator
     * @return the rational denominator
     */
    public int getDenominator() {
        return _denominator;
    }

    /**
     * Get string representation of the rational
     * @return string representation of the rational
     */
    public String toString() {
        return String.format("%d/%d", _numerator, _denominator);
    }

    /**
     * Get the greatest common divisor
     * of num1 and num2
     * @param num1 the first number
     * @param num2 the second number
     * @return the greatest common divisor of num1 and num2
     */
    static private int gcd(int num1, int num2) {
        if (0 == num2) {
            return num1;
        }

        return gcd(num2, num1 % num2);
    }

    /**
     * Reduce the fraction
     * @return the reduced fraction
     */
    public Rational reduce() {
        // Find the greatest common divisor of the numerator and the denominator
        int commonDivisor = Math.abs(gcd(_numerator, _denominator));

        int reducedNumerator = _numerator / commonDivisor;
        int reducedDenominator = _denominator / commonDivisor;

        return new Rational(reducedNumerator, reducedDenominator);
    }
}
