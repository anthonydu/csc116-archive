import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests SandwichFilling class
 *
 * @author Om Pandey, Anthony Du
 */
public class SandwichFillingTest {

    /** The SandwichFilling turkey object */
    private SandwichFilling turkey;

    /** The SandwichFilling chicken object */
    private SandwichFilling chicken;

    /**
     * Set up fields
     */
    @BeforeEach
    public void setUp() {
        turkey = new SandwichFilling("Turkey", 54);
        chicken = new SandwichFilling("Chicken", 68);
    }

    /**
     * Test getter methods for turkey
     */
    @Test
    public void testGettersTurkey() {
        assertEquals("Turkey", turkey.getType(), "Turkey type");
        assertEquals(54, turkey.getCalories(), "Turkey calories");
    }

    /**
     * Test getType method for chicken
     */
    @Test
    public void testGetTypeChicken() {
        assertEquals("Chicken", chicken.getType(), "Chicken type");
    }

    /**
     * Test getCalories method for chicken
     */
    @Test
    public void testGetCaloriesChicken() {
        assertEquals(68, chicken.getCalories(), "Chicken calories");
    }

    /**
     * Test equals method for turkey
     */
    @Test
    public void testEqualsTurkey() {
        assertTrue(turkey.equals(turkey), "Test same object");
        assertTrue(turkey.equals(new SandwichFilling("Turkey", 54)),
                "Test objects with same fields");
        assertFalse(turkey.equals(new SandwichFilling("Turkey", 60)),
                "Test with different calories");
        assertFalse(turkey.equals(new SandwichFilling("turkey", 54)),
                "Test with different name");
        assertFalse(turkey.equals(null), "Test with null");
        assertFalse(turkey.equals("Hello"), "Test with string");
    }

    /**
     * Test equals method for chicken
     */
    @Test
    public void testEqualsChicken() {
        assertTrue(chicken.equals(chicken), "Test same object");
        assertTrue(chicken.equals(new SandwichFilling("Chicken", 68)),
                "Test objects with same fields");
        assertFalse(chicken.equals(new SandwichFilling("Chicken", 60)),
                "Test with different calories");
        assertFalse(chicken.equals(new SandwichFilling("chicken", 68)),
                "Test with different name");
        assertFalse(chicken.equals(null), "Test with null");
        assertFalse(chicken.equals("Hello"), "Test with string");
    }

    /**
     * Test toString method for turkey
     */
    @Test
    public void testToStringTurkey() {
        assertEquals("Turkey (54 calories per serving)", turkey.toString(),
                "Test toString");
    }

    /**
     * Test toString method for chicken
     */
    @Test
    public void testToStringChicken() {
        assertEquals("Chicken (68 calories per serving)", chicken.toString(),
                "Test toString");
    }
}
