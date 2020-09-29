package com.moti;

public class Rational {
    private int _numerator;
    private int _denominator;

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

    public boolean greaterThan(Rational frac) {
        return (_numerator * frac._denominator) > (frac._numerator * _denominator);
    }

    public boolean equals(Rational frac) {
        return (_numerator * frac._denominator) == (frac._numerator * _denominator);
    }

    public Rational plus(Rational frac) {
        // Calculate the numerator and denominator of the sum
        int sum_numerator = (_numerator * frac._denominator) + (frac._numerator * _denominator);
        int sum_denominator = _denominator * frac._denominator;

        return new Rational(sum_numerator, sum_denominator);
    }

    public Rational minus(Rational frac) {
        // Calculate the numerator and denominator of the difference
        int diff_numerator = (_numerator * frac._denominator) - (frac._numerator * _denominator);
        int diff_denominator = _denominator * frac._denominator;

        return new Rational(diff_numerator, diff_denominator);
    }

    public Rational multiply(Rational frac) {
        // Calculate the numerator and denominator of the product
        int prod_numerator = _numerator * frac._numerator;
        int prod_denominator = _denominator * frac._denominator;

        return new Rational(prod_numerator, prod_denominator);
    }

    public int getNumerator() {
        return _numerator;
    }

    public int getDenominator() {
        return _denominator;
    }

    public String toString() {
        return String.format("%d/%d", _numerator, _denominator);
    }

    static private int gcd(int x, int y) {
        if (0 == y) {
            return x;
        }

        return gcd(y, x % y);
    }

    public Rational reduce() {
        // Find the greatest common divisor of the numerator and the denominator
        int common_divisor = Math.abs(gcd(_numerator, _denominator));

        int reduced_numerator = _numerator / common_divisor;
        int reduced_denominator = _denominator / common_divisor;

        return new Rational(reduced_numerator, reduced_denominator);
    }
}
