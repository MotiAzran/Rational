package com.moti;

public class Rational {
    private int _numerator;
    private int _denominator;

    public Rational(int numerator, int denominator) {
        if (denominator < 0) {
            _numerator = 0;
            _denominator = 0;
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
        int sum_numerator = (_numerator * frac._denominator) + (frac._numerator * _denominator);
        int sum_denominator = _denominator * frac._denominator;

        return new Rational(sum_numerator, sum_denominator);
    }

    public Rational minus(Rational frac) {
        int diff_numerator = (_numerator * frac._denominator) - (frac._numerator * _denominator);
        int diff_denominator = _denominator * frac._denominator;

        return new Rational(diff_numerator, diff_denominator);
    }

    public Rational multiply(Rational frac) {
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
        int common_divisor = gcd(_numerator, _denominator);

        return new Rational(_numerator / common_divisor, _denominator / common_divisor);
    }
}
