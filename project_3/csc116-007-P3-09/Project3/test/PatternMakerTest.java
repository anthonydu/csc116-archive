import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test PatternMaker methods
 * @author Suzanne Balik
 * @author Anthony Du
 */
public class PatternMakerTest {

    /** Square - 1 row, 1 column */
    public static String SQUARE_1_1 = " _\n" +
                                      "|_|\n";

    /** Square - 2 rows, 3 columns */
    public static String SQUARE_2_3 = " _ _ _\n" +
                                      "|_|_|_|\n" +
                                      "|_|_|_|\n";

    /** Square - 3 rows, 2 columns */
    public static String SQUARE_3_2 = " _ _\n" +
                                      "|_|_|\n" +
                                      "|_|_|\n" +
                                      "|_|_|\n";

    /** Square - 10 rows, 10 columns */
    public static String SQUARE_10_10 = " _ _ _ _ _ _ _ _ _ _\n" +
                                        "|_|_|_|_|_|_|_|_|_|_|\n" +
                                        "|_|_|_|_|_|_|_|_|_|_|\n" +
                                        "|_|_|_|_|_|_|_|_|_|_|\n" +
                                        "|_|_|_|_|_|_|_|_|_|_|\n" +
                                        "|_|_|_|_|_|_|_|_|_|_|\n" +
                                        "|_|_|_|_|_|_|_|_|_|_|\n" +
                                        "|_|_|_|_|_|_|_|_|_|_|\n" +
                                        "|_|_|_|_|_|_|_|_|_|_|\n" +
                                        "|_|_|_|_|_|_|_|_|_|_|\n" +
                                        "|_|_|_|_|_|_|_|_|_|_|\n";

    /** Square - 1 rows, 10 columns */
    public static String SQUARE_1_10 = " _ _ _ _ _ _ _ _ _ _\n" +
                                        "|_|_|_|_|_|_|_|_|_|_|\n";

    /** Square - 10 rows, 1 columns */
    public static String SQUARE_10_1 = " _\n" +
                                        "|_|\n" +
                                        "|_|\n" +
                                        "|_|\n" +
                                        "|_|\n" +
                                        "|_|\n" +
                                        "|_|\n" +
                                        "|_|\n" +
                                        "|_|\n" +
                                        "|_|\n" +
                                        "|_|\n";

    /** Triangle - 1 row */
    public static String TRIANGLE_1 = " /\\\n" +
                                      "/__\\\n";

    /** Triangle - 4 rows */
    public static String TRIANGLE_4 = "       /\\\n" +
                                      "      /__\\\n" +
                                      "     /\\  /\\\n" +
                                      "    /__\\/__\\\n" +
                                      "   /\\  /\\  /\\\n" +
                                      "  /__\\/__\\/__\\\n" +
                                      " /\\  /\\  /\\  /\\\n" +
                                      "/__\\/__\\/__\\/__\\\n";

    /** Triangle - 7 rows */
    public static String TRIANGLE_7 = "             /\\\n" +
                                      "            /__\\\n" +
                                      "           /\\  /\\\n" +
                                      "          /__\\/__\\\n" +
                                      "         /\\  /\\  /\\\n" +
                                      "        /__\\/__\\/__\\\n" +
                                      "       /\\  /\\  /\\  /\\\n" +
                                      "      /__\\/__\\/__\\/__\\\n" +
                                      "     /\\  /\\  /\\  /\\  /\\\n" +
                                      "    /__\\/__\\/__\\/__\\/__\\\n" +
                                      "   /\\  /\\  /\\  /\\  /\\  /\\\n" +
                                      "  /__\\/__\\/__\\/__\\/__\\/__\\\n" +
                                      " /\\  /\\  /\\  /\\  /\\  /\\  /\\\n" +
                                      "/__\\/__\\/__\\/__\\/__\\/__\\/__\\\n";

    /** Triangle - 10 rows */
    public static String TRIANGLE_10 = "                   /\\\n" +
                                       "                  /__\\\n" +
                                       "                 /\\  /\\\n" +
                                       "                /__\\/__\\\n" +
                                       "               /\\  /\\  /\\\n" +
                                       "              /__\\/__\\/__\\\n" +
                                       "             /\\  /\\  /\\  /\\\n" +
                                       "            /__\\/__\\/__\\/__\\\n" +
                                       "           /\\  /\\  /\\  /\\  /\\\n" +
                                       "          /__\\/__\\/__\\/__\\/__\\\n" +
                                       "         /\\  /\\  /\\  /\\  /\\  /\\\n" +
                                       "        /__\\/__\\/__\\/__\\/__\\/__\\\n" +
                                       "       /\\  /\\  /\\  /\\  /\\  /\\  /\\\n" +
                                       "      /__\\/__\\/__\\/__\\/__\\/__\\/__\\\n" +
                                       "     /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\\n" +
                                       "    /__\\/__\\/__\\/__\\/__\\/__\\/__\\/__\\\n" +
                                       "   /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\\n" +
                                       "  /__\\/__\\/__\\/__\\/__\\/__\\/__\\/__\\/__\\\n" +
                                       " /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\\n" +
                                       "/__\\/__\\/__\\/__\\/__\\/__\\/__\\/__\\/__\\/__\\\n";

    /** Diamond - 1 row */
    public static String DIAMOND_1 = "/\\\n" +
                                     "\\/\n";

    /** Diamond - 4 rows */
    public static String DIAMOND_4 = "   /\\\n" +
                                     "  /\\/\\\n" +
                                     " /\\/\\/\\\n" +
                                     "/\\/\\/\\/\\\n" +
                                     "\\/\\/\\/\\/\n";

    /** Diamond - 7 rows */
    public static String DIAMOND_7 = "      /\\\n" +
                                     "     /\\/\\\n" +
                                     "    /\\/\\/\\\n" +
                                     "   /\\/\\/\\/\\\n" +
                                     "  /\\/\\/\\/\\/\\\n" +
                                     " /\\/\\/\\/\\/\\/\\\n" +
                                     "/\\/\\/\\/\\/\\/\\/\\\n" +
                                     "\\/\\/\\/\\/\\/\\/\\/\n";

    /** Diamond - 10 rows */
    public static String DIAMOND_10 = "         /\\\n" +
                                      "        /\\/\\\n" +
                                      "       /\\/\\/\\\n" +
                                      "      /\\/\\/\\/\\\n" +
                                      "     /\\/\\/\\/\\/\\\n" +
                                      "    /\\/\\/\\/\\/\\/\\\n" +
                                      "   /\\/\\/\\/\\/\\/\\/\\\n" +
                                      "  /\\/\\/\\/\\/\\/\\/\\/\\\n" +
                                      " /\\/\\/\\/\\/\\/\\/\\/\\/\\\n" +
                                      "/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\\n" +
                                      "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\n";

    /** Tests PatternMaker.getSquares(1,1) */
    @Test
    public void testGetSquares1Row1Col() {

        assertEquals(SQUARE_1_1, PatternMaker.getSquares(1,1), "PatternMaker.getSquares(1,1)");

    }

    /** Tests PatternMaker.getSquares(2,3) */
    @Test
    public void testGetSquares2Row3Col() {

        assertEquals(SQUARE_2_3, PatternMaker.getSquares(2,3), "PatternMaker.getSquares(2,3)");

    }

    /** Tests PatternMaker.getSquares(3,2) */
    @Test
    public void testGetSquares3Row2Col() {

        assertEquals(SQUARE_3_2, PatternMaker.getSquares(3,2), "PatternMaker.getSquares(3,2)");

    }

    /** Tests PatternMaker.getSquares(10,10) */
    @Test
    public void testGetSquares10Row10Col() {

        assertEquals(SQUARE_10_10,
                                PatternMaker.getSquares(10,10), "PatternMaker.getSquares(10,10)");

    }

    /** Tests PatternMaker.getSquares(10,1) */
    @Test
    public void testGetSquares10Row1Col() {

        assertEquals(SQUARE_10_1, PatternMaker.getSquares(10,1), "PatternMaker.getSquares(10,1)");

    }

    /** Tests PatternMaker.getSquares(1,10) */
    @Test
    public void testGetSquares1Row10Col() {

        assertEquals(SQUARE_1_10, PatternMaker.getSquares(1,10), "PatternMaker.getSquares(1,10)");

    }

    /** Tests PatternMaker.getTriangles(1) */
    @Test
    public void testGetTriangles1Row() {

        assertEquals(TRIANGLE_1, PatternMaker.getTriangles(1), "PatternMaker.getTriangles(1)");

    }

    /** Tests PatternMaker.getTriangles(4) */
    @Test
    public void testGetTriangles4Rows() {

        assertEquals(TRIANGLE_4, PatternMaker.getTriangles(4), "PatternMaker.getTriangles(4)");

    }

    /** Tests PatternMaker.getTriangles(10) */
    @Test
    public void testGetTriangles10Rows() {

        assertEquals(TRIANGLE_10, PatternMaker.getTriangles(10), "PatternMaker.getTriangles(10)");

    }

    /** Tests PatternMaker.getTriangles(7) */
    @Test
    public void testGetTriangles7Rows() {

        assertEquals(TRIANGLE_7, PatternMaker.getTriangles(7), "PatternMaker.getTriangles(7)");

    }

    /** Tests PatternMaker.getDiamonds(1) */
    @Test
    public void testGetDiamonds1Row() {

        assertEquals(DIAMOND_1, PatternMaker.getDiamonds(1), "PatternMaker.getDiamonds(1)");

    }

    /** Tests PatternMaker.getDiamonds(4) */
    @Test
    public void testGetDiamonds4Rows() {

        assertEquals(DIAMOND_4, PatternMaker.getDiamonds(4), "PatternMaker.getDiamonds(4)");

    }

    /** Tests PatternMaker.getDiamonds(10) */
    @Test
    public void testGetDiamonds10Rows() {

        assertEquals(DIAMOND_10, PatternMaker.getDiamonds(10), "PatternMaker.getDiamonds(10)");

    }

    /** Tests PatternMaker.getDiamonds(7) */
    @Test
    public void testGetDiamonds7Rows() {

        assertEquals(DIAMOND_7, PatternMaker.getDiamonds(7), "PatternMaker.getDiamonds(7)");

    }


    /**
     * Test the PatternMaker methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!

        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getSquares(0,-1), "PatternMaker.getSquares(0,-1)");
        assertEquals("Invalid rows", exception.getMessage(),
                     "Testing PatternMaker.getSquares(0,-1) - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getSquares(2,-1), "PatternMaker.getSquares(2,-1)");
        assertEquals("Invalid columns", exception.getMessage(),
                     "Testing PatternMaker.getSquares(2,-1) - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getSquares(11, 11), "PatternMaker.getSquares(11,11)");
        assertEquals("Invalid rows", exception.getMessage(),
                     "Testing PatternMaker.getSquares(11,11) - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getSquares(10,11), "PatternMaker.getSquares(10,11)");
        assertEquals("Invalid columns", exception.getMessage(),
                     "Testing PatternMaker.getSquares(10,11) - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getTriangles(0), "PatternMaker.getTriangles(0)");
        assertEquals("Invalid rows", exception.getMessage(),
                     "Testing PatternMaker.getTriangles(0) - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getTriangles(11), "PatternMaker.getTriangles(11)");
        assertEquals("Invalid rows", exception.getMessage(),
                     "Testing PatternMaker.getTriangles(11) - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getDiamonds(0), "PatternMaker.getDiamonds(0)");
        assertEquals("Invalid rows", exception.getMessage(),
                     "Testing PatternMaker.getDiamonds(0) - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getDiamonds(11), "PatternMaker.getDiamonds(11)");
        assertEquals("Invalid rows", exception.getMessage(),
                     "Testing PatternMaker.getDiamonds(11) - exception message");

    }
}
