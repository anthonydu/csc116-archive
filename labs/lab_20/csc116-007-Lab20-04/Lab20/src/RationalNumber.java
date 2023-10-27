/**
 * This class will perform all the kinds of operations with two rational terms
 * @author Om Pandey
 * @author Anthony Du
 */
public class RationalNumber {

    /** The numerator of the rational number */
    private int numerator;

    /** The denominator of the rational number */
    private int denominator;

    /**
     * Constructs a new rational number to represent the ratio (0/1)
     * This constructor should call the constructor with two parameters using this(0, 1)
     */
    public RationalNumber() {
        this(0, 1);
    }

    /**
     * Constructs a new rational number to represent the ratio (numerator/denominator)
     * The denominator cannot be 0, so throw an IllegalArgumentException
     * (with message: "Denominator is 0") if 0 is passed
     * HINT: call reduce method so that all instances of RationalNumber are reduced
     * @param numerator the numerator of the fraction
     * @param denominator the denominator of the fraction
     * @throws IllegalArgumentException with the message "Denominator is 0" if 0 is passed
     */
    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator is 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    /**
     * Eliminates any common factors and ensures that denominator > 0
     * For example, if the RationalNumber is 2/-4,
     * this method should convert the RationalNumber to be -1/2
     * to ensure the denominator is a positive number
     * and common factors are eliminated
     */
    private void reduce() {
        int greatestCommonFactor = 1;
        if (denominator < 0) {
            denominator *= -1;
            numerator *= -1;
        }
        if (numerator == 0) {
            denominator = 1;
        }
        for (int i = Math.min(Math.abs(numerator), Math.abs(denominator)); i > 0; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                greatestCommonFactor = i;
                break;
            }
        }
        numerator /= greatestCommonFactor;
        denominator /= greatestCommonFactor;
    }

    /**
     * Returns this rational number’s numerator value;
     * for example, if the ratio is (3/5), returns 3
     * @return the numerator of the rational fraction
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Returns this rational number’s denominator value;
     * for example, if the ratio is (3/5), returns 5
     * @return the denominator of the rational fraction
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Returns a String representation of this rational number, such as "3/5"
     * You may wish to omit denominators of 1, returning "4" instead of "4/1"
     * @return the String representation of the resulting rational number
     */
    public String toString() {
        if (denominator == 1) {
            return "" + numerator;
        }
        else {
            return "" + numerator + "/" + denominator;
        }
    }

    /**
     * Returns true if this and other are equivalent rational numbers
     * @param other the instance object
     * @return true if a this and an other are equivalent rational numbers
     */
    public boolean equals(Object other) {
        if (other instanceof RationalNumber) {
            RationalNumber orn = (RationalNumber) other;
            return numerator == orn.getNumerator() && denominator == orn.getDenominator();
        }
        else {
            return false;
        }
    }

    /**
     * Returns rational number that is (this + other)
     * @param other the other rational number to operate with
     * @return the sum of the this and the other rational numbers
     */
    public RationalNumber add(RationalNumber other) {
        int newNumerator = 0;
        int newDenominator;
        // set newDenominator to the product of both denominators
        newDenominator = denominator * other.getDenominator();
        // add both of the cross products of the numerators
        newNumerator += numerator * other.getDenominator();
        newNumerator += other.getNumerator() * denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    /**
     * Returns rational number that is (this - other)
     * @param other the other rational number to operate with
     * @return the difference of the this and the other rational numbers
     */
    public RationalNumber subtract(RationalNumber other) {
        int newNumerator = 0;
        int newDenominator;
        // set newDenominator to the product of both denominators
        newDenominator = denominator * other.getDenominator();
        // add and subtract the cross products of the numerators
        newNumerator += numerator * other.getDenominator();
        newNumerator -= other.getNumerator() * denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    /**
     * Returns rational number that is (this * other)
     * @param other the other rational number to operate with
     * @return the product of the this and the other rational numbers
     */
    public RationalNumber multiply(RationalNumber other) {
        int newNumerator, newDenominator;
        // set newDenominator to the product of both denominators
        newDenominator = denominator * other.getDenominator();
        // set newNumerator to the product of both numerators
        newNumerator = numerator * other.getNumerator();
        return new RationalNumber(newNumerator, newDenominator);
    }

    /**
     * Returns rational number that is (this / other)
     * @param other the other rational number to operate with
     * @return the quotient of the this and the other rational numbers
     */
    public RationalNumber divide(RationalNumber other) {
        RationalNumber copy = this;
        // flip the second rational number and multiply them
        return copy.multiply(new RationalNumber(other.getDenominator(), other.getNumerator()));
    }
}
