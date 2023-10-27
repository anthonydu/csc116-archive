import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests PackBakery class
 *
 * @author Om Pandey, Anthony Du
 */
public class PackBakeryTest {
    
    /** Declare bakery PackBakery */
    private PackBakery bakery;

    /** Declare turkeySandwich Sandwich */
    private Sandwich turkeySandwich;

    /** Declare pbjSandwich Sandwich */
    private Sandwich pbjSandwich;

    /** Declare bltSandwich Sandwich */
    private Sandwich bltSandwich;

    /** Declare bananaSandwich Sandwich */
    private Sandwich bananaSandwich;

    /**
     * Set up fields
     */
    @BeforeEach
    public void setUp() {
        Bread rye = new Bread("Rye", 65);
        SandwichFilling turkey = new SandwichFilling("Turkey", 54);
        turkeySandwich = new Sandwich("Turkey Sandwich", rye, turkey);

        Bread white = new Bread("White", 50);
        SandwichFilling pbj = new SandwichFilling("Peanut Butter and Jelly", 120);
        pbjSandwich = new Sandwich("PBJ Sandwich", white, pbj);

        Bread french = new Bread("French", 75);
        SandwichFilling blt = new SandwichFilling("Bacon, Lettuce, and Tomato", 200);
        bltSandwich = new Sandwich("BLT Sandwich", french, blt);

        Bread wheat = new Bread("Wheat", 70);
        SandwichFilling banana = new SandwichFilling("Banana", 50);
        bananaSandwich = new Sandwich("Banana", wheat, banana);

        bakery = new PackBakery(3);
    }

    /**
     * Test addSandwich TS
     */
    @Test
    public void testAddSandwich1() {
        assertTrue(bakery.addSandwich(turkeySandwich), "Adds first sandwich");
        assertEquals(turkeySandwich, bakery.getMenu()[0],
                "Checks contents after first sandwich added [0]");
        assertNull(bakery.getMenu()[1], "Checks contents after first sandwich added [1]");
        assertNull(bakery.getMenu()[2], "Checks contents after first sandwich added [2]");
        assertTrue(bakery.addSandwich(bltSandwich), "Adds second sandwich");
        assertEquals(turkeySandwich, bakery.getMenu()[0],
                "Checks contents after second sandwich added [0]");
        assertEquals(bltSandwich, bakery.getMenu()[1],
                "Checks contents after second sandwich added [1]");
        assertNull(bakery.getMenu()[2], "Checks contents after second sandwich added [2]");
        assertTrue(bakery.addSandwich(pbjSandwich), "Adds third sandwich");
        assertEquals(turkeySandwich, bakery.getMenu()[0],
                "Checks contents after third sandwich added [0]");
        assertEquals(bltSandwich, bakery.getMenu()[1],
                "Checks contents after third sandwich added [1]");
        assertEquals(pbjSandwich, bakery.getMenu()[2],
                "Checks contents after third sandwich added [2]");
        assertFalse(bakery.addSandwich(bananaSandwich), "Attempt to add fourth sandwich");
    }

    /**
     * Test addSandwich Student
     */
    @Test
    public void testAddSandwich2() {
        assertTrue(bakery.addSandwich(pbjSandwich), "Adds first sandwich");
        assertEquals(pbjSandwich, bakery.getMenu()[0],
                "Checks contents after first sandwich added [0]");
        assertNull(bakery.getMenu()[1], "Checks contents after first sandwich added [1]");
        assertNull(bakery.getMenu()[2], "Checks contents after first sandwich added [2]");
        assertTrue(bakery.addSandwich(bananaSandwich), "Adds second sandwich");
        assertEquals(pbjSandwich, bakery.getMenu()[0],
                "Checks contents after second sandwich added [0]");
        assertEquals(bananaSandwich, bakery.getMenu()[1],
                "Checks contents after second sandwich added [1]");
        assertNull(bakery.getMenu()[2], "Checks contents after second sandwich added [2]");
        assertTrue(bakery.addSandwich(bltSandwich), "Adds third sandwich");
        assertEquals(pbjSandwich, bakery.getMenu()[0],
                "Checks contents after third sandwich added [0]");
        assertEquals(bananaSandwich, bakery.getMenu()[1],
                "Checks contents after third sandwich added [1]");
        assertEquals(bltSandwich, bakery.getMenu()[2],
                "Checks contents after third sandwich added [2]");
        assertFalse(bakery.addSandwich(turkeySandwich), "Attempt to add fourth sandwich");
    }

    /**
     * Test removeSandwich TS
     */
    @Test
    public void testRemoveSandwich1() {
        assertTrue(bakery.addSandwich(turkeySandwich), "Add one sandwich");
        assertEquals(turkeySandwich, bakery.getMenu()[0], "One sandwich in list");
        assertTrue(bakery.removeSandwich(turkeySandwich), "Remove only sandwich");
        assertNull(bakery.getMenu()[0], "Sandwich has been removed");

        assertTrue(bakery.addSandwich(turkeySandwich), "Add turkey sandwich");
        assertTrue(bakery.addSandwich(bltSandwich), "Add BLT");
        assertTrue(bakery.addSandwich(pbjSandwich), "Add PB&J sandwich");
        assertFalse(bakery.addSandwich(bananaSandwich), "Cannot add fourth sandwich");

        assertTrue(bakery.removeSandwich(turkeySandwich), "Remove turkey sandwich at index 0");
        assertNull(bakery.getMenu()[0], "Removed item is null");
        assertTrue(bakery.removeSandwich(pbjSandwich), "Remove PB&J sandwich at index 2");
        assertNull(bakery.getMenu()[0], "Removed item is null");
        assertNull(bakery.getMenu()[2], "Removed item is null");
        assertTrue(bakery.removeSandwich(bltSandwich), "Remove BLT at index 1");
        assertNull(bakery.getMenu()[0], "Removed item is null");
        assertNull(bakery.getMenu()[1], "Removed item is null");
        assertNull(bakery.getMenu()[2], "Removed item is null");
        assertFalse(bakery.removeSandwich(bananaSandwich), "Cannot remove sandwich not in bakery");
    }

    /**
     * Test removeSandwichStudent
     */
    @Test
    public void testRemoveSandwich2() {
        assertTrue(bakery.addSandwich(pbjSandwich), "Add one sandwich");
        assertEquals(pbjSandwich, bakery.getMenu()[0], "One sandwich in list");
        assertTrue(bakery.removeSandwich(pbjSandwich), "Remove only sandwich");
        assertNull(bakery.getMenu()[0], "Sandwich has been removed");

        assertTrue(bakery.addSandwich(bltSandwich), "Add turkey sandwich");
        assertTrue(bakery.addSandwich(pbjSandwich), "Add BLT");
        assertTrue(bakery.addSandwich(turkeySandwich), "Add PB&J sandwich");
        assertFalse(bakery.addSandwich(bananaSandwich), "Cannot add fourth sandwich");

        assertTrue(bakery.removeSandwich(turkeySandwich), "Remove turkey sandwich at index 2");
        assertNull(bakery.getMenu()[2], "Removed item is null");
        assertTrue(bakery.removeSandwich(bltSandwich), "Remove BLT sandwich at index 0");
        assertNull(bakery.getMenu()[0], "Removed item is null");
        assertNull(bakery.getMenu()[2], "Removed item is null");
        assertTrue(bakery.removeSandwich(pbjSandwich), "Remove PB&J at index 1");
        assertNull(bakery.getMenu()[0], "Removed item is null");
        assertNull(bakery.getMenu()[1], "Removed item is null");
        assertNull(bakery.getMenu()[2], "Removed item is null");
        assertFalse(bakery.removeSandwich(bananaSandwich), "Cannot remove sandwich not in bakery");
    }

    /**
     * Test getSandwich TS
     */
    @Test
    public void testGetSandwich1() {
        assertTrue(bakery.addSandwich(turkeySandwich), "Add turkey sandwich");
        assertTrue(bakery.addSandwich(bltSandwich), "Add BLT");
        assertTrue(bakery.addSandwich(pbjSandwich), "Add PB&J");

        assertEquals(turkeySandwich, bakery.getSandwich("Turkey Sandwich"),
                "Turkey Sandwich for get method");
        assertEquals(pbjSandwich, bakery.getSandwich("PBJ Sandwich"),
                "PBJ Sandwich for get method");
        assertEquals(bltSandwich, bakery.getSandwich("BLT Sandwich"),
                "BLT Sandwich for get method");

        assertNull(bakery.getSandwich("Banana Sandwich"), "Get sandwich not in bakery");
    }

    /**
     * Test getSandwich Student
     */
    @Test
    public void testGetSandwich2() {
        assertTrue(bakery.addSandwich(bltSandwich), "Add BLT Sandwich");
        assertTrue(bakery.addSandwich(bananaSandwich), "Add Banana");
        assertTrue(bakery.addSandwich(turkeySandwich), "Add Turkey Sandwich");

        assertEquals(turkeySandwich, bakery.getSandwich("Turkey Sandwich"),
                "Turkey Sandwich for get method");
        assertEquals(bananaSandwich, bakery.getSandwich("Banana"),
                "Banana for get method");
        assertEquals(bltSandwich, bakery.getSandwich("BLT Sandwich"),
                "BLT Sandwich for get method");

        assertNull(bakery.getSandwich("PBJ Sandwich"), "Get sandwich not in bakery");
    }

    /**
     * Test Constructor TS
     */
    @Test
    public void testConstructor() {
        Sandwich[] menu = bakery.getMenu();
        assertEquals(3, menu.length);
        assertNull(bakery.getMenu()[0], "Checks contents with constructor with 3 [0]");
        assertNull(bakery.getMenu()[1], "Checks contents with constructor with 3 [1]");
        assertNull(bakery.getMenu()[2], "Checks contents with constructor with 3 [2]");
        bakery = new PackBakery();
        menu = bakery.getMenu();
        assertEquals(3, menu.length);
        assertNull(bakery.getMenu()[0], "Checks contents with constructor with no parameter [0]");
        assertNull(bakery.getMenu()[1], "Checks contents with constructor with no parameter [1]");
        assertNull(bakery.getMenu()[2], "Checks contents with constructor with no parameter [2]");
        bakery = new PackBakery(4);
        menu = bakery.getMenu();
        assertEquals(4, menu.length);
        assertNull(bakery.getMenu()[0], "Checks contents with constructor with 4 [0]");
        assertNull(bakery.getMenu()[1], "Checks contents with constructor with 4 [1]");
        assertNull(bakery.getMenu()[2], "Checks contents with constructor with 4 [2]");
        assertNull(bakery.getMenu()[3], "Checks contents with constructor with 4 [3]");
    }
}
