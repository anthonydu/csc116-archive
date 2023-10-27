import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Bread class
 *
 * @author Om Pandey, Anthony Du
 */
public class BreadTest {

    /** The Bread rye object */
    private Bread rye;

    /** The Bread sourdough object */
    private Bread sourdough;

    /**
     * Set up fields
     */
    @BeforeEach
    public void setUp() {
        rye = new Bread("Rye", 65);
        sourdough = new Bread("Sourdough", 55);
    }

    /**
     * Test getter methods for rye
     */
    @Test
    public void testGettersRye() {
        assertEquals("Rye", rye.getType(), "Rye type");
        assertEquals(65, rye.getCalories(), "Rye calories");
    }

    /**
     * Test getType method for sourdough
     */
    @Test
    public void testGetTypeSourdough() {
        assertEquals("Sourdough", sourdough.getType(), "Sourdough type");
    }

    /**
     * Test getCalories method for sourdough
     */
    @Test
    public void testGetCaloriesSourdough() {
        assertEquals(55, sourdough.getCalories(), "Sourdough calories");
    }

    /**
     * Test equals method for rye
     */
    @Test
    public void testEqualsRye() {
        assertTrue(rye.equals(rye), "Test equals for same object");
        assertTrue(rye.equals(new Bread("Rye", 65)), "Test equals with bread with same fields");
        assertFalse(rye.equals(new Bread("Rye", 60)), "Test equals with different calories");
        assertFalse(rye.equals(new Bread("rye", 65)), "Test equals with different case");
        assertFalse(rye.equals(null), "Test equals with null");
        assertFalse(rye.equals("Hello"), "Test equals with string");
    }

    /**
     * Test equals method for sourdough
     */
    @Test
    public void testEqualsSourdough() {
        assertTrue(sourdough.equals(sourdough), "Test equals for same object");
        assertTrue(sourdough.equals(new Bread("Sourdough", 55)),
                "Test equals with bread with same fields");
        assertFalse(sourdough.equals(new Bread("Sourdough", 60)),
                "Test equals with different calories");
        assertFalse(sourdough.equals(new Bread("sourdough", 55)),
                "Test equals with different case");
        assertFalse(sourdough.equals(null), "Test equals with null");
        assertFalse(sourdough.equals("Hello"), "Test equals with string");
    }

    /**
     * Test toString method for rye
     */
    @Test
    public void testToStringRye() {
        assertEquals("Rye (65 calories per slice)", rye.toString(), "Test toString");
    }

    /**
     * Test toString method for sourdough
     */
    @Test
    public void testToStringSourdough() {
        assertEquals("Sourdough (55 calories per slice)", sourdough.toString(), "Test toString");
    }
}
