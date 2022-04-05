import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

/**
 * Tests SortedDoubleArray
 *
 * @author Jessica Young Schmidt
 * @author Anthony Du
 * @auther Bowen Deng
 */
public class SortedDoubleArrayTest {

    /** Delta for comparing doubles */
    public static final double DELTA = 0.0001;

    /**
     * Teaching staff (TS) test for getNewArray of three elements
     */
    @Test
    public void testGetNewArrayTS() {
        double[] expected = { 0, .0, 0.0 };
        assertEquals(3, expected.length);
        double[] actual = SortedDoubleArray.getNewArray(3);
        assertEquals(3, actual.length);
        assertArrayEquals(expected, actual, DELTA);
    }

    /**
     * student test for getNewArray of empty array
     */
    @Test
    public void testGetNewArrayEmpty() {
        double[] expected = {};
        assertEquals(0, expected.length);
        double[] actual = SortedDoubleArray.getNewArray(0);
        assertEquals(0, actual.length);
        assertArrayEquals(expected, actual, DELTA);
    }

    /**
     * Teaching staff (TS) test for getNewArray with invalid parameter
     */
    @Test
    public void testGetNewArrayNegTS() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SortedDoubleArray.getNewArray(-1), "Testing negative number of elements");
        assertEquals("Invalid number of elements", exception.getMessage(),
                "Testing negative number of elements message");
    }

    /**
     * Teaching staff (TS) test for isSorted with duplicate elements
     */
    @Test
    public void testIsSortedTS() {
        double[] arr = { 1, 2, 2.0, 3, 4 };
        assertTrue(SortedDoubleArray.isSorted(arr));
        // Test size after method
        assertEquals(5, arr.length);
        // Test that method does not modify
        double[] copy = { 1.0, 2.0, 2.0, 3.0, 4.0 };
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * Teaching staff (TS) test for isSorted with null array
     */
    @Test
    public void testIsSortedNullTS() {
        double[] arr = null;

        // Test invalid parameters
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SortedDoubleArray.isSorted(arr), "Testing null array");
        assertEquals("Null array", exception.getMessage(), "Testing null array message");

        // Test that method does not modify
        double[] copy = null;
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * Student test for isSorted with unsorted array
     */
    @Test
    public void testIsSortedUnsorted() {
        double[] arr = {10.0, 3.0, 4.0};
        assertFalse(SortedDoubleArray.isSorted(arr));
        // Test size after method
        assertEquals(3, arr.length);
        // Test that method does not modify
        double[] copy = {10.0, 3.0, 4.0};
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * Student test for isSorted with reverse sorted array
     */
    @Test
    public void testIsSortedReverseSorted() {
        double[] arr = {10.0, 4.0, 3.0};
        assertFalse(SortedDoubleArray.isSorted(arr));
        // Test size after method
        assertEquals(3, arr.length);
        // Test that method does not modify
        double[] copy = {10.0, 4.0, 3.0};
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * Student test for isSorted with empty array
     */
    @Test
    public void testIsSortedEmpty() {
        double[] arr = {};
        assertFalse(SortedDoubleArray.isSorted(arr));
        // Test size after method
        assertEquals(0, arr.length);
        // Test that method does not modify
        double[] copy = {};
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * Teaching staff (TS) test for sequentialSearch for element not in array and
     * insertion point not at 0 or length
     */
    @Test
    public void testSequentialSearchTS() {
        double[] arr = { 1.0, 3.0, 4.0 };
        assertEquals(-2, SortedDoubleArray.sequentialSearch(arr, 2.2));
        // Test size after method
        assertEquals(3, arr.length);
        // Test that method does not modify
        double[] copy = { 1.0, 3.0, 4.0 };
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * Teaching staff (TS) test for sequentialSearch for null array
     */
    @Test
    public void testSequentialSearchNullTS() {
        double[] arr = null;
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SortedDoubleArray.sequentialSearch(arr, 9.0),
                "Test that exception is thrown with null array");
        assertEquals("Null Array", exception.getMessage(),
                "Test exception message with null array");
    }

    /**
     * Student test for sequentialSearch for unsorted array
     */
    @Test
    public void testSequentialSearchUnsorted() {
        double[] arr = {10, 3, 4};
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SortedDoubleArray.sequentialSearch(arr, 10.0));
        assertEquals("Unsorted Array", exception.getMessage());
    }

    /**
     * Student test for sequentialSearch for element in array
     */
    @Test
    public void testSequentialSearchFound() {
        double[] arr = { 1.0, 3.0, 4.0 };
        assertEquals(1, SortedDoubleArray.sequentialSearch(arr, 3.0));
        // Test size after method
        assertEquals(3, arr.length);
        // Test that method does not modify
        double[] copy = { 1.0, 3.0, 4.0 };
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * Student test for sequentialSearch for empty array
     */
    @Test
    public void testSequentialSearchEmpty() {
        double[] arr = {};
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SortedDoubleArray.sequentialSearch(arr, 10.0));
        assertEquals("Unsorted Array", exception.getMessage());
    }

    /**
     * Student test for sequentialSearch for searches where element is not found
     * and where the insertion point would be at beginning or end of array
     */
    @Test
    public void testSequentialSearchBeginning() {
        double[] arr = { 1.0, 3.0, 4.0 };
        assertEquals(-1, SortedDoubleArray.sequentialSearch(arr, 0.5));
        // Test size after method
        assertEquals(3, arr.length);
        // Test that method does not modify
        double[] copy = { 1.0, 3.0, 4.0 };
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * Teaching staff (TS) test for addElement with three element array
     */
    @Test
    public void testAddElementTS() {
        double[] arr = { 1.0, 3.0, 4.0 };
        double[] expected = { 1.0, 2.2, 3.0, 4.0 };
        assertEquals(4, expected.length);
        double[] actual = SortedDoubleArray.addElement(arr, 2.2);
        assertArrayEquals(expected, actual);
        // Test size after method
        assertEquals(3, arr.length);
        // Test that method does not modify
        double[] copy = { 1.0, 3.0, 4.0 };
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * Teaching staff (TS) test for addElement with null array
     */
    @Test
    public void testAddElementNullTS() {
        double[] arr = null;
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SortedDoubleArray.addElement(arr, 9.0),
                "Test that exception is thrown with null array");
        assertEquals("Null Array", exception.getMessage(),
                "Test exception message with null array");
    }

    /**
     *test for addElement with unsorted array
     */
    @Test
    public void testAddElementUnsorted() {
        double[] arr = { 4.0, 3.0, 2.0 };
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SortedDoubleArray.addElement(arr, 10.0));
        assertEquals("Unsorted Array", exception.getMessage());
    }

    /**
     *test for addElement with duplicate element
     */
    @Test
    public void testAddElementDuplicateElement() {
        double[] arr = { 2.0, 3.0, 4.0 };
        double[] expected = { 2.0, 2.0, 3.0, 4.0 };
        assertEquals(4, expected.length);
        double[] actual = SortedDoubleArray.addElement(arr, 2.0);
        assertArrayEquals(expected, actual);
        // Test size after method
        assertEquals(3, arr.length);
        // Test that method does not modify
        double[] copy = { 2.0, 3.0, 4.0 };
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     *test for addElement with adding to various index
     */
    @Test
    public void testAddElementToVariousIndex() {
        double[] arr = { 2.0, 3.0, 4.0 };
        double[] expected = { 2.0, 3.0, 4.0, 5.0 };
        assertEquals(4, expected.length);
        double[] actual = SortedDoubleArray.addElement(arr, 5.0);
        assertArrayEquals(expected, actual);
        // Test size after method
        assertEquals(3, arr.length);
        // Test that method does not modify
        double[] copy = { 2.0, 3.0, 4.0 };
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * Teaching staff (TS) test for indexOfMinValue with non-empty array
     */
    @Test
    public void testIndexOfMinValueTS() {
        double[] arr = { 3.0, 10.0, 4.0 };
        assertEquals(0, SortedDoubleArray.indexOfMinValue(arr, 0, 2));
        // Test size after method
        assertEquals(3, arr.length);
        // Test that method does not modify
        double[] copy = { 3.0, 10.0, 4.0 };
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * Teaching staff (TS) test for indexOfMinValue with non-empty array
     */
    @Test
    public void testIndexOfMinValue2TS() {
        double[] arr = { 3.0, 10.0, 4.0 };
        assertEquals(2, SortedDoubleArray.indexOfMinValue(arr, 1, 2));
        // Test size after method
        assertEquals(3, arr.length);
        // Test that method does not modify
        double[] copy = { 3.0, 10.0, 4.0 };
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     *test for indexOfMinValue with invalid parameter
     */
    @Test
    public void testIndexOfMinValueInvalidParameter() {
        double[] arr = null;
        Exception exception = assertThrows(IllegalArgumentException.class,
                                            () -> SortedDoubleArray.indexOfMinValue(arr, 0, 1));
        assertEquals("Invalid parameter", exception.getMessage());
    }

    /**
     * test for indexOfMinValue with minimum value at various index of array
     */
    @Test
    public void testIndexOfMinValueMinValueAtVariousIndex1() {
        double[] arr = { 3.0, 10.0, 4.0 };
        assertEquals(0, SortedDoubleArray.indexOfMinValue(arr, 0, 2));
        // Test size after method
        assertEquals(3, arr.length);
        // Test that method does not modify
        double[] copy = { 3.0, 10.0, 4.0 };
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * test for indexOfMinValue with minimum value at various index of array
     */
    @Test
    public void testIndexOfMinValueMinValueAtVariousIndex2() {
        double[] arr = { 3.0, 10.0, 4.0, 5.0 };
        assertEquals(2, SortedDoubleArray.indexOfMinValue(arr, 1, 3));
        // Test size after method
        assertEquals(4, arr.length);
        // Test that method does not modify
        double[] copy = { 3.0, 10.0, 4.0, 5.0 };
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * test for indexOfMinValue with minimum value at various index of array
     */
    @Test
    public void testIndexOfMinValueMinValueAtVariousIndex3() {
        double[] arr = { 3.0, 10.0, 4.0, 5.0 };
        assertEquals(0, SortedDoubleArray.indexOfMinValue(arr, 0, 1));
        // Test size after method
        assertEquals(4, arr.length);
        // Test that method does not modify
        double[] copy = { 3.0, 10.0, 4.0, 5.0 };
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * test for indexOfMinValue with duplicate elements
     */
    @Test
    public void testIndexOfMinValueDuplicateElement() {
        double[] arr = { 3.0, 10.0, 3.0, 4.0 };
        assertEquals(0, SortedDoubleArray.indexOfMinValue(arr, 0, 3));
        // Test size after method
        assertEquals(4, arr.length);
        // Test that method does not modify
        double[] copy = { 3.0, 10.0, 3.0, 4.0 };
        assertArrayEquals(copy, arr, DELTA);
    }

    /**
     * Teaching staff (TS) test for swap with first two elements
     */
    @Test
    public void testSwapTS() {
        double[] actual = { 3.0, 10.0, 4.0 };
        double[] expected = { 10.0, 3.0, 4.0 };
        assertEquals(3, expected.length);
        SortedDoubleArray.swap(actual, 0, 1);
        // Test size after method
        assertEquals(3, actual.length);
        assertArrayEquals(expected, actual, DELTA);
    }

    /**
     * Teaching staff (TS) test for swap with first and last elements
     */
    @Test
    public void testSwap2TS() {
        double[] actual = { 3.0, 10.0, 4.0 };
        double[] expected = { 4.0, 10.0, 3.0 };
        assertEquals(3, expected.length);
        SortedDoubleArray.swap(actual, 0, 2);
        // Test size after method
        assertEquals(3, actual.length);
        assertArrayEquals(expected, actual, DELTA);
    }

    /**
     * test for invalid parameters (many restictions on parameters)
     */
    @Test
    public void testSwapInvalidParameters() {
        double[] arr = null;
        // test invalid parameters
        Exception exception = assertThrows(IllegalArgumentException.class,
                                            () -> SortedDoubleArray.swap(arr, 0, 1));
        assertEquals("Invalid parameter", exception.getMessage());
    }



    /**
     * test for swapping various index of array
     */
     @Test
     public void testSwap2() {
         double[] actual = { 3.0, 10.0, 4.0, 5.0, 6.0};
         double[] expected = { 3.0, 10.0, 4.0, 6.0, 5.0};
         assertEquals(5, expected.length);
         SortedDoubleArray.swap(actual, 3, 4);
         // Test size after method
         assertEquals(5, actual.length);
         assertArrayEquals(expected, actual, DELTA);
     }

     /**
      * test for swapping various index of array
      */
      @Test
      public void testSwap3() {
          double[] actual = { 3.0, 10.0, 4.0, 5.0, 6.0};
          double[] expected = { 3.0, 6.0, 4.0, 5.0, 10.0};
          assertEquals(5, expected.length);
          SortedDoubleArray.swap(actual, 1, 4);
          // Test size after method
          assertEquals(5, actual.length);
          assertArrayEquals(expected, actual, DELTA);
      }

    /**
     * Teaching staff (TS) test for selectionSort for unsorted array of three
     * elements
     */
    @Test
    public void testSelectionSortTS() {
        double[] actual = { 10.0, 3.0, 4.0 };
        double[] expected = { 3.0, 4.0, 10.0 };
        assertEquals(3, expected.length);
        SortedDoubleArray.selectionSort(actual);
        // Test size after method
        assertEquals(3, actual.length);
        assertArrayEquals(expected, actual, DELTA);
    }

    /**
     * Teaching staff (TS) test for selectionSort for null array
     */
    @Test
    public void testSelectionSortNullTS() {
        double[] actual = null;
        double[] expected = null;
        // Test invalid parameters
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SortedDoubleArray.selectionSort(actual), "Testing null array");
        assertEquals("Null array", exception.getMessage(), "Testing null array message");
        // Test size after method
        assertArrayEquals(expected, actual, DELTA);
    }

    /**
     * test for selectionSort for unsorted array of four
     * elements
     */
    @Test
    public void testSelectionSortUnsortedFour() {
        double[] actual = { 10.0, 3.0, 4.0, 1.0 };
        double[] expected = { 1.0, 3.0, 4.0, 10.0 };
        assertEquals(4, expected.length);
        SortedDoubleArray.selectionSort(actual);
        // Test size after method
        assertEquals(4, actual.length);
        assertArrayEquals(expected, actual, DELTA);
    }

    /**
     * test for selectionSort for reverse sorted array of three
     * elements
     */
    @Test
    public void testSelectionSortReverseSorted() {
        double[] actual = { 10.0, 4.0, 3.0 };
        double[] expected = { 3.0, 4.0, 10.0 };
        assertEquals(3, expected.length);
        SortedDoubleArray.selectionSort(actual);
        // Test size after method
        assertEquals(3, actual.length);
        assertArrayEquals(expected, actual, DELTA);
    }

    /**
     *test for selectionSort for array with duplicate elements
     * elements
     */
    @Test
    public void testSelectionSortDuplicateElements() {
        double[] actual = { 10.0, 3.0, 4.0, 3.0};
        double[] expected = { 3.0, 3.0, 4.0, 10.0 };
        assertEquals(4, expected.length);
        SortedDoubleArray.selectionSort(actual);
        // Test size after method
        assertEquals(4, actual.length);
        assertArrayEquals(expected, actual, DELTA);
    }





}
