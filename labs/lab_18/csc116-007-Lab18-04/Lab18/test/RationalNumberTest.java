import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests RationalNumber class
 * @author Om Pandey
 * @author Anthony Du
 * @author Jessica Young Schmidt
 */
public class RationalNumberTest {

    /** Rational number 1/4 */
    private RationalNumber quarter;

    /** Rational number -1/4 */
    private RationalNumber quarterNeg;

    /** Rational number 2/8 which is 1/4 */
    private RationalNumber twoOverEight;

    /** Rational number 1/3 */
    private RationalNumber third;

    /** Rational number 1/2 */
    private RationalNumber half;

    /** Rational number 3/1 */
    private RationalNumber three;

    /** Rational number 1/8 */
    private RationalNumber eighth;

    /** Rational number -1/8 */
    private RationalNumber eighthNeg;

    /** Rational number 1/16 */
    private RationalNumber sixteenth;

    /** Rational number -1/16 */
    private RationalNumber sixteenthNeg;

    /** Rational number 2/1 */
    private RationalNumber two;

    /** Rational number 4/8 which is 1/2 */
    private RationalNumber fourOverEight;

    /**
     * Set up fields
     */
    @BeforeEach
    public void setUp() {
        quarter = new RationalNumber(1, 4);
        quarterNeg = new RationalNumber(1, -4);
        twoOverEight = new RationalNumber(2, 8);
        third = new RationalNumber(1, 3);
        half = new RationalNumber(1, 2);
        three = new RationalNumber(6, 2);
        eighth = new RationalNumber(1, 8);
        eighthNeg = new RationalNumber(1, -8);
        sixteenth = new RationalNumber(1, 16);
        sixteenthNeg = new RationalNumber(1, -16);
        two = new RationalNumber(2, 1);
        fourOverEight = new RationalNumber(4, 8);
    }

    /**
     * Testing constructor
     */
    @Test
    public void testConstructor() {
        RationalNumber def = new RationalNumber();
        assertEquals(0, def.getNumerator(), "Default constructor getNumerator");
        assertEquals(1, def.getDenominator(), "Default constructor getDenominator");
        RationalNumber rn = new RationalNumber(2, -4);
        assertEquals(-1, rn.getNumerator(), "getNumerator");
        assertEquals(2, rn.getDenominator(), "getDenominator");
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> new RationalNumber(3, 0),
                "Testing constructor with denominator 0");
        assertEquals("Denominator is 0", exception.getMessage(),
                "Testing constructor with denominator 0 - exception message");
    }

    /**
     * Test toString
     */
    @Test
    public void testToStringTS() {
        assertEquals("1/4", quarter.toString(), "quarter toString");
        assertEquals("-1/4", quarterNeg.toString(), "quarterNeg toString");
        assertEquals("1/4", twoOverEight.toString(), "twoOverEight toString");
        assertEquals("1/3", third.toString(), "third toString");
        assertEquals("1/2", half.toString(), "half toString");
        assertEquals("3", three.toString(), "three toString");
    }

    /**
     * Test toString
     */
    @Test
    public void testToString() {
        assertEquals("1/8", eighth.toString(), "eighth toString");
        assertEquals("-1/8", eighthNeg.toString(), "eighthNeg toString");
        assertEquals("1/16", sixteenth.toString(), "sixteenth toString");
        assertEquals("-1/16", sixteenthNeg.toString(), "sixteenthNeg toString");
        assertEquals("2", two.toString(), "two toString");
        assertEquals("1/2", fourOverEight.toString(), "fourOverEight toString");
    }


    /**
     * Test equals
     */
    @Test
    public void testEqualsTS() {
        String desc = "quarter.equals(twoOverEight)";
        boolean actB = quarter.equals(twoOverEight);
        assertTrue(actB, desc);
    }

    /**
     * Test equals
     */
    @Test
    public void testEquals() {
        String desc = "half.equals(fourOverEight)";
        boolean actB = half.equals(fourOverEight);
        assertTrue(actB, desc);
    }

    /**
     * Test add
     */
    @Test
    public void testAddTS() {
        String desc = "quarter.add(twoOverEight)";
        RationalNumber exp = half;
        RationalNumber act = quarter.add(twoOverEight);
        assertEquals(exp, act, desc);
        // check that rational number variables were not changed
        assertEquals(new RationalNumber(1, 4), quarter);
        assertEquals(new RationalNumber(1, 4), twoOverEight);
    }

    /**
     * Test add
     */
    @Test
    public void testAdd() {
        String desc = "half.add(quarterNeg)";
        RationalNumber exp = quarter;
        RationalNumber act = half.add(quarterNeg);
        assertEquals(exp, act, desc);
        // check that rational number variables were not changed
        assertEquals(new RationalNumber(1, 2), half);
        assertEquals(new RationalNumber(-1, 4), quarterNeg);
    }

    /**
     * Test subtract
     */
    @Test
    public void testSubtractTS() {
        String desc = "quarter.subtract(twoOverEight)";
        RationalNumber exp = new RationalNumber();
        RationalNumber act = quarter.subtract(twoOverEight);
        assertEquals(exp, act, desc);
        // check that rational number variables were not changed
        assertEquals(new RationalNumber(1, 4), quarter);
        assertEquals(new RationalNumber(1, 4), twoOverEight);
    }

    /**
     * Test subtract
     */
    @Test
    public void testSubtract() {
        String desc = "eighth.subtract(sixteenth)";
        RationalNumber exp = new RationalNumber(1, 16);
        RationalNumber act = eighth.subtract(sixteenth);
        assertEquals(exp, act, desc);
        // check that rational number variables were not changed
        assertEquals(new RationalNumber(1, 8), eighth);
        assertEquals(new RationalNumber(1, 16), sixteenth);
    }

    /**
     * Test multiply
     */
    @Test
    public void testMultiplyTS() {
        String desc = "quarter.multiply(twoOverEight)";
        RationalNumber exp = new RationalNumber(1, 16);
        RationalNumber act = quarter.multiply(twoOverEight);
        assertEquals(exp, act, desc);
        // check that rational number variables were not changed
        assertEquals(new RationalNumber(1, 4), quarter);
        assertEquals(new RationalNumber(1, 4), twoOverEight);
    }

    /**
     * Test multiply
     */
    @Test
    public void testMultiply() {
        String desc = "half.multiply(twoOverEight)";
        RationalNumber exp = new RationalNumber(1, 8);
        RationalNumber act = half.multiply(twoOverEight);
        assertEquals(exp, act, desc);
        // check that rational number variables were not changed
        assertEquals(new RationalNumber(1, 2), half);
        assertEquals(new RationalNumber(1, 4), twoOverEight);
    }

    /**
     * Test divide
     */
    @Test
    public void testDivideTS() {
        String desc = "quarter.divide(twoOverEight)";
        RationalNumber exp = new RationalNumber(1, 1);
        RationalNumber act = quarter.divide(twoOverEight);
        assertEquals(exp, act, desc);
        // check that rational number variables were not changed
        assertEquals(new RationalNumber(1, 4), quarter);
        assertEquals(new RationalNumber(1, 4), twoOverEight);
    }

    /**
     * Test divide
     */
    @Test
    public void testDivide() {
        String desc = "fourOverEight.divide(two)";
        RationalNumber exp = new RationalNumber(1, 4);
        RationalNumber act = fourOverEight.divide(two);
        assertEquals(exp, act, desc);
        // check that rational number variables were not changed
        assertEquals(new RationalNumber(1, 2), fourOverEight);
        assertEquals(new RationalNumber(2, 1), two);
    }
}
