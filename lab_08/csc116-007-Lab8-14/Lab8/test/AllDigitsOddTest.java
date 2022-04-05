import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests AllDigitsOdd program, which prints out if all digits of an integer are odd
 *
 * @author Anthony Du
 * @author Shuhao Liu
 */
public class AllDigitsOddTest {

    /**
     * Tests areAllDigitsOdd with false positive.
     */
    @Test
    public void testAreAllDigitsOddA() {
        assertFalse(AllDigitsOdd.areAllDigitsOdd(12));
    }

    /**
     * Tests areAllDigitsOdd with zero.
     */
    @Test
    public void testAreAllDigitsOddZero() {
        assertFalse(AllDigitsOdd.areAllDigitsOdd(0));
    }

    /**
     * Tests areAllDigitsOdd with true negative.
     */
    @Test
    public void testAreAllDigitsOddNTrueNegative() {
        assertTrue(AllDigitsOdd.areAllDigitsOdd(-13579));
    }

    /**
     * Tests areAllDigitsOdd with true positive.
     */
    @Test
    public void testAreAllDigitsOddTruePositive() {
        assertTrue(AllDigitsOdd.areAllDigitsOdd(13579));
    }

    /**
     * Tests lastDigit with a with a two digit integer.
     */
    @Test
    public void testLastDigitA() {
        assertEquals(2, AllDigitsOdd.lastDigit(12));
    }

    /**
     * Tests lastDigit with a 10 digit integer with 0 at the end.
     */
    @Test
    public void testLastDigitZero() {
        assertEquals(0, AllDigitsOdd.lastDigit(1234567890));
    }

    /**
     * Tests lastDigit with a one digit integer.
     */
    @Test
    public void testLastDigitSingle() {
        assertEquals(8, AllDigitsOdd.lastDigit(8));
    }

    /**
     * Tests withoutLastDigit with a two digit integer.
     */
    @Test
    public void testWithoutLastDigitA() {
        assertEquals(1, AllDigitsOdd.withoutLastDigit(12));
    }

    /**
     * Tests withoutLastDigit with a 10 digit integer with 0 at the end.
     */
    @Test
    public void testWithoutLastDigitZero() {
        assertEquals(123456789, AllDigitsOdd.withoutLastDigit(1234567890));
    }

    /**
     * Tests withoutLastDigit with a one digit integer.
     */
    @Test
    public void testWithoutLastDigitSingle() {
        assertEquals(0, AllDigitsOdd.withoutLastDigit(8));
    }

}
