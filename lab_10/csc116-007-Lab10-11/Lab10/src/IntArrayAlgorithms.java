/**
 * A class that contains methods for finding
 * 1) the first, last or all student id with a given score
 * 2) the difference between the maximum and minimum score + 1
 * 3) the number of students within a score range (inclusive)
 *
 * @author Anthony Du
 * @author Shuhao Liu
 */
public class IntArrayAlgorithms {

    /**
     * accepts an array of integers and an integer value as its parameters and
     * returns the first index at which the value occurs in the array
     *
     * @param arr array of integers to examine
     * @param val integer value to find in arr
     * @return the first (smallest) index of arr that contains val, or -1 if val is
     *         not in arr
     */
    public static int indexOf(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    /**
     * accepts an array of integers and an integer value as its parameters and
     * returns the last index at which the value occurs in the array
     *
     * @param arr array of integers to examine
     * @param val integer value to find in arr
     * @return the last (highest) index of arr that contains val, or -1 if val is
     *         not in arr
     */
    public static int lastIndexOf(int[] arr, int val) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    /**
     * accepts an array of integers and an integer value as its parameters and
     * returns comma-separated list of indexes at which the value occurs in the
     * array
     *
     * @param arr array of integers to examine
     * @param val integer value to find in arr
     * @return comma-separated list of indexes that contains val, or empty string
     *         ("") if val is not in arr
     */
    public static String listOfIndexWithValue(int[] arr, int val) {
        String listOfIndex = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                listOfIndex += i + ", ";
            }
        }
        if (listOfIndex.length() > 0) {
            return listOfIndex.substring(0, listOfIndex.length() - 2);
        } else {
            return "";
        }
    }

    /**
     * Returns the range of values in an array of integers. The range is defined as
     * 1 more than the difference between the maximum and minimum values in the
     * array.
     *
     * Precondition: array has at least one element
     *
     * @param arr array to examine
     * @return range of values in arr
     * @throws IllegalArgumentException with message "Empty array." if size of arr
     *             is 0
     */
    public static int range(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Empty array.");
        }
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return max - min + 1;
    }

    /**
     * accepts an array of integers, a minimum value, and a maximum value as
     * parameters and returns the count of how many elements from the array fall
     * between the minimum and maximum (inclusive)
     *
     * @param arr array to examine
     * @param min minimum value to find in arr
     * @param max maximum value to find in arr
     * @return count of elements from arr that are between min and max (inclusive)
     * @throws IllegalArgumentException with message "Invalid range." if max is less
     *             than min
     */
    public static int countInRange(int[] arr, int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("Invalid range.");
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= max && arr[i] >= min) {
                count += 1;
            }
        }
        return count;
    }

}
