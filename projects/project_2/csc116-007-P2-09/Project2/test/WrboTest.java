import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test Wrbo methods
 * @author Suzanne Balik
 * @author Michelle Glatz
 * @author Anthony Du
 */
public class WrboTest {

    /**
     * Tests Wrbo.isValidStartDate(6, 11)
     */
    @Test
    public void testIsValidStartDateValidJune() {

        assertTrue(Wrbo.isValidStartDate(6, 11), "Wrbo.isValidStartDate(6, 11)");

    }

    /**
     * Tests Wrbo.isValidStartDate(9, 10)
     */
    @Test
    public void testIsValidStartDateInvalidSaturdaySeptember() {

        assertFalse(Wrbo.isValidStartDate(9, 10), "Wrbo.isValidStartDate(9, 10)");

    }

    /**
     * Tests Wrbo.isValidStartDate(5, 30)
     */
    @Test
    public void testIsValidStartDateInvalidMay() {

        assertFalse(Wrbo.isValidStartDate(5, 30), "Wrbo.isValidStartDate(5, 30)");

    }

    /**
     * Tests Wrbo.isValidStartDate(8, -1)
     */
    @Test
    public void testIsValidStartDateAugustInvalidDayNegative() {

        assertFalse(Wrbo.isValidStartDate(8, -1), "Wrbo.isValidStartDate(8, -1)");

    }

    /**
     * Tests Wrbo.isValidStartDate(0, 1)
     */
    @Test
    public void testIsValidStartDateInvalidMonthZer0() {

        assertFalse(Wrbo.isValidStartDate(0, 1), "Wrbo.isValidStartDate(0, 1)");

    }

    /**
     * Tests Wrbo.isValidStartDate(5, 21)
     */
    @Test
    public void testIsValidStartDateValidMay() {

        assertTrue(Wrbo.isValidStartDate(5, 21), "Wrbo.isValidStartDate(5, 21)");

    }

    /**
     * Tests Wrbo.isValidStartDate(7, 4)
     */
    @Test
    public void testIsValidStartDateInvalidJuly() {

        assertFalse(Wrbo.isValidStartDate(7, 4), "Wrbo.isValidStartDate(7, 4)");

    }

    /**
     * Tests Wrbo.isValidStartDate(8, 13)
     */
    @Test
    public void testIsValidStartDateValidAugust() {

        assertTrue(Wrbo.isValidStartDate(8, 13), "Wrbo.isValidStartDate(8, 13)");

    }

    /**
     * Tests Wrbo.isValidStartDate(4, 30)
     */
    @Test
    public void testIsValidStartDateInvalidSaturdayDayApril() {

        assertFalse(Wrbo.isValidStartDate(4, 30), "Wrbo.isValidStartDate(4, 30)");

    }

    /**
     * Tests Wrbo.isValidStartDate(7, 30)
     */
    @Test
    public void testIsValidStartDateValidDayJuly() {

        assertTrue(Wrbo.isValidStartDate(7, 30), "Wrbo.isValidStartDate(7, 30)");

    }

    /**
     * Tests Wrbo.isValidStartDate(5, 0)
     */
    @Test
    public void testIsValidStartDateMayInvalidDayZero() {

        assertFalse(Wrbo.isValidStartDate(5, 0), "Wrbo.isValidStartDate(5, 0)");

    }

    /**
     * Tests Wrbo.isValidStartDate(6, 31)
     */
    @Test
    public void testIsValidStartDateJune31() {

        assertFalse(Wrbo.isValidStartDate(6, 31), "Wrbo.isValidStartDate(6, 31)");

    }

    /**
     * Tests Wrbo.getRentalCost('b', 7, 9)
     */
    @Test
    public void testGetRentalCostBeachJuly() {
        assertEquals(1200, Wrbo.getRentalCost('b', 7, 9),
                     "Wrbo.getRentalCost('b', 7, 9)");

    }

    /**
     * Tests Wrbo.getRentalCost('S', 5, 28)
     */
    @Test
    public void testGetRentalCostSunnyMemorial() {
        assertEquals(1575, Wrbo.getRentalCost('S', 5, 28),
                     "Wrbo.getRentalCost('S', 5, 28)");

    }

    /**
     * Tests Wrbo.getRentalCost('c', 5, 7)
     */
    @Test
    public void testGetRentalCostCoastalMay() {
        assertEquals(1150, Wrbo.getRentalCost('c', 5, 7),
                     "Wrbo.getRentalCost('c', 5, 7)");

    }

    /**
     * Tests Wrbo.getRentalCost('B', 7, 2)
     */
    @Test
    public void testGetRentalCostBeachIndependence() {
        assertEquals(1600, Wrbo.getRentalCost('B', 7, 2),
                     "Wrbo.getRentalCost('B', 7, 2)");

    }

    /**
     * Tests Wrbo.getRentalCost('s', 8, 27)
     */
    @Test
    public void testGetRentalCostSunnyAugust() {
        assertEquals(1425, Wrbo.getRentalCost('s', 8, 27),
                     "Wrbo.getRentalCost('s', 8, 27)");

    }

    /**
     * Tests Wrbo.getRentalCost('c', 7, 2)
     */
    @Test
    public void testGetRentalCostCoastalIndependence() {
        assertEquals(1700, Wrbo.getRentalCost('c', 7, 2),
                     "Wrbo.getRentalCost('c', 7, 2)");
    }

    /**
     * Tests Wrbo.getRentalCost('S', 7, 2)
     */
    @Test
    public void testGetRentalCostSunnyIndependence() {
        assertEquals(1725, Wrbo.getRentalCost('S', 7, 2),
                     "Wrbo.getRentalCost('S', 7, 2)");
    }

    /**
     * Tests Wrbo.getRentalCost('B', 5, 28)
     */
    @Test
    public void testGetRentalCostBeachMemorial() {
        assertEquals(1500, Wrbo.getRentalCost('B', 5, 28),
                     "Wrbo.getRentalCost('B', 5, 28)");
    }

    /**
     * Tests Wrbo.getRentalCost('C', 5, 28)
     */
    @Test
    public void testGetRentalCostCoastalMemorial() {
        assertEquals(1550, Wrbo.getRentalCost('C', 5, 28),
                     "Wrbo.getRentalCost('C', 5, 28)");
    }

    /**
     * Tests Wrbo.getRentalCost('B', 6, 4)
     */
    @Test
    public void testGetRentalCostBeachJune() {
        assertEquals(1000, Wrbo.getRentalCost('B', 6, 4),
                     "Wrbo.getRentalCost('B', 6, 4)");
    }

    /**
     * Tests Wrbo.getRentalCost('s', 5, 14)
     */
    @Test
    public void testGetRentalCostSunnyMay() {
        assertEquals(1245, Wrbo.getRentalCost('s', 5, 14),
                     "Wrbo.getRentalCost('s', 5, 14)");
    }

    /**
     * Tests Wrbo.getRentalCost('c', 7, 16)
     */
    @Test
    public void testGetRentalCostCoastalJuly() {
        assertEquals(1310, Wrbo.getRentalCost('c', 7, 16),
                     "Wrbo.getRentalCost('c', 7, 16)");
    }

    /**
     * Tests Wrbo.getRentalTerm(7, 9)
     */
    @Test
    public void testGetRentalTermJuly9() {
        assertEquals("7/9/2022-7/16/2022", Wrbo.getRentalTerm(7, 9),
                     "Wrbo.getRentalTerm(7, 9)");

    }

    /**
     * Tests Wrbo.getRentalTerm(5, 7)
     */
    @Test
    public void testGetRentalTermMay28() {
        assertEquals("5/7/2022-5/14/2022", Wrbo.getRentalTerm(5, 7),
                     "Wrbo.getRentalTerm(5, 7)");

    }

    /**
     * Tests Wrbo.getRentalTerm(5, 28)
     */
    @Test
    public void testGetRentalTermMay7() {
        assertEquals("5/28/2022-6/4/2022", Wrbo.getRentalTerm(5, 28),
                     "Wrbo.getRentalTerm(5, 28)");

    }

    /**
     * Tests Wrbo.getRentalTerm(6, 11)
     */
    @Test
    public void testGetRentalTermJune11() {
        assertEquals("6/11/2022-6/18/2022", Wrbo.getRentalTerm(6, 11),
                     "Wrbo.getRentalTerm(6, 11)");

    }

    /**
     * Tests Wrbo.getRentalTerm(6, 25)
     */
    @Test
    public void testGetRentalTermJune25() {
        assertEquals("6/25/2022-7/2/2022", Wrbo.getRentalTerm(6, 25),
                     "Wrbo.getRentalTerm(6, 25)");
    }

    /**
     * Tests Wrbo.getRentalTerm(7, 30)
     */
    @Test
    public void testGetRentalTermJuly30() {
        assertEquals("7/30/2022-8/6/2022", Wrbo.getRentalTerm(7, 30),
                     "Wrbo.getRentalTerm(7, 30)");

    }

    /**
     * Tests Wrbo.getRentalTerm(8, 6)
     */
    @Test
    public void testGetRentalTermAugust6() {
        assertEquals("8/6/2022-8/13/2022", Wrbo.getRentalTerm(8, 6),
                     "Wrbo.getRentalTerm(8, 6)");

    }

    /**
     * Tests Wrbo.getRentalTerm(8, 27)
     */
    @Test
    public void testGetRentalTermAugust27() {
        assertEquals("8/27/2022-9/3/2022", Wrbo.getRentalTerm(8, 27),
                     "Wrbo.getRentalTerm(8, 27)");
    }


    /**
     * Test the Wrbo methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!

        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Wrbo.getRentalCost('X', 5, 28),
                                 "Wrbo.getRentalCost('X', 5, 28)");
        assertEquals("Invalid house", exception.getMessage(),
                     "Testing Wrbo.getRentalCost('X', 5, 28) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> Wrbo.getRentalCost('X', 5, 26),
                                 "Wrbo.getRentalCost('X', 5, 26)");
        assertEquals("Invalid house", exception.getMessage(),
                     "Testing Wrbo.getRentalCost('X', 5, 26) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> Wrbo.getRentalCost('s', 5, 26),
                                 "Wrbo.getRentalCost('s', 5, 26)");
        assertEquals("Invalid date", exception.getMessage(),
                     "Testing Wrbo.getRentalCost('s', 5, 26) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> Wrbo.getRentalTerm(2, 28),
                                           "Wrbo.getRentalTerm(2, 28)");
        assertEquals("Invalid date", exception.getMessage(),
                     "Testing Wrbo.getRentalTerm(2, 28) - exception message");
    }
}
