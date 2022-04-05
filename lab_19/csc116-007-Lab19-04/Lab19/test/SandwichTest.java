import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Sandwich class
 *
 * @author Om Pandey, Anthony Du
 */
public class SandwichTest {

    /** The Bread rye object */
    private Bread rye;

    /** The Bread sourdough object */
    private Bread sourdough;

    /** The SandwichFilling turkey object */
    private SandwichFilling turkey;

    /** The SandwichFilling chicken object */
    private SandwichFilling chicken;
    
    /** The Sandwich ryeTurkey object */
    private Sandwich ryeTurkey;

    /** The Sandwich sourdoughChicken object */
    private Sandwich sourdoughChicken;

    /**
     * Set up fields
     */
    @BeforeEach
    public void setUp() {
        rye = new Bread("Rye", 65);
        sourdough = new Bread("Sourdough", 55);
        turkey = new SandwichFilling("Turkey", 54);
        chicken = new SandwichFilling("Chicken", 68);
        ryeTurkey = new Sandwich("Turkey Sandwich", rye, turkey);
        sourdoughChicken = new Sandwich("Chicken Sandwich", sourdough, chicken);
    }

    /**
     * Test getCalories method for total calories for turkey
     */
    @Test
    public void testTotalCaloriesTurkey() {
        assertEquals(184, ryeTurkey.getCalories(), "Total Calories");
    }

    /**
     * Test getCalories method for total calories for chicken
     */
    @Test
    public void testTotalCaloriesChicken() {
        assertEquals(178, sourdoughChicken.getCalories(), "Total Calories");
    }

    /**
     * Test equals method for rye turkey sandwich
     */
    @Test
    public void testEqualsRyeTurkey() {
        assertTrue(ryeTurkey.equals(ryeTurkey), "Test same object");
        assertTrue(ryeTurkey.equals(new Sandwich("Turkey Sandwich", rye, turkey)),
                "Test same values");
        assertTrue(ryeTurkey.equals(new Sandwich("Turkey Sandwich", new Bread("Rye", 65),
                new SandwichFilling("Turkey", 54))), "Test same components");
        assertFalse(ryeTurkey.equals(new Sandwich("Turkey Sandwich", new Bread("Rye", 65),
                new SandwichFilling("turkey", 54))), "Test filling with different case");
        assertFalse(ryeTurkey.equals(new Sandwich("Turkey Sandwich", new Bread("Rye", 61),
                new SandwichFilling("Turkey", 54))), "Test bread with different calories");
        assertFalse(ryeTurkey.equals(null), "Test with null");
        assertFalse(sourdoughChicken.equals("Hello"), "Test with string");
    }

    /**
     * Test equals method for sourdough chicken sandwich
     */
    @Test
    public void testEqualsSourdoughChicken() {
        assertTrue(sourdoughChicken.equals(sourdoughChicken), "Test same object");
        assertTrue(sourdoughChicken.equals(new Sandwich("Chicken Sandwich", sourdough, chicken)),
                "Test same values");
        assertTrue(sourdoughChicken.equals(new Sandwich("Chicken Sandwich",
                new Bread("Sourdough", 55), new SandwichFilling("Chicken", 68))),
                "Test same components");
        assertFalse(sourdoughChicken.equals(new Sandwich("Chicken Sandwich",
                new Bread("Sourdough", 55), new SandwichFilling("chicken", 68))),
                "Test filling with different case");
        assertFalse(sourdoughChicken.equals(new Sandwich("Chicken Sandwich",
                new Bread("Sourdough", 61), new SandwichFilling("Chicken", 54))),
                "Test bread with different calories");
        assertFalse(sourdoughChicken.equals(null), "Test with null");
        assertFalse(sourdoughChicken.equals("Hello"), "Test with string");
    }

    /**
     * Test toString method for rye turkey sandwich
     */
    @Test
    public void testToStringRyeTurkey() {
        assertEquals("Total Calories (184): Turkey (54 calories per serving) on"
                + " Rye (65 calories per slice)", ryeTurkey.toString(),
                "Test toString");
    }

    /**
     * Test toString method for sourdough chicken sandwich
     */
    @Test
    public void testToStringSourdoughChicken() {
        assertEquals("Total Calories (178): Chicken (68 calories per serving) on"
                + " Sourdough (55 calories per slice)", sourdoughChicken.toString(),
                "Test toString");
    }
}
