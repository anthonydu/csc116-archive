/**
 * A class containing two helper methods that checks if a string array is palindrome
 * or if two 2D arrays are equal
 *
 * @author Anthony Du
 * @author Bowen Deng
 */
public class StringArrays {

    // Returns whether arr is a palindrome
    // Throws IllegalArgumentException if arr is null (Message: Invalid array)
    // Throws IllegalArgumentException if any element is null (Message: Invalid element)

    /**
     * Returns whether arr is a palindrome
     *
     * @param arr a String array
     * @return true if arr is palindrome, false if arr is not palindrome
     * @throws llegalArgumentException if arr is null (Message: Invalid array)
     * @throws IllegalArgumentException if any element is null (Message: Invalid element)
     */
    public static boolean isPalindrome(String[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Invalid array");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null || arr[arr.length - i - 1] == null) {
                throw new IllegalArgumentException("Invalid element");
            }
            if (!arr[i].equals(arr[arr.length - i - 1])) {
                return false;
            }
        }
        return true;
    }

    // Returns whether parameters are equal arrays (contain all of
    // the same elements in the same order/location)
    // Throws IllegalArgumentException if a or b are null (Message: Invalid array)

    /**
     * Returns whether two 2D arrays are equivalent
     *
     * @param a 2D String array 1
     * @param b 2D String array 2
     * @return true if the arrays are the same, false if they are not
     * @throws IllegalArgumentException if a or b are null (Message: Invalid array)
     */
    public static boolean equals2D(String[][] a, String[][] b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Invalid array");
        }
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null || b[i] == null) {
                throw new IllegalArgumentException("Invalid array");
            }
            if (a[i].length != b[i].length) {
                return false;
            }
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == null || b[i][j] == null) {
                    throw new IllegalArgumentException("Invalid array");
                }
                if (!a[i][j].equals(b[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
