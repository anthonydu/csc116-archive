import java.util.Arrays;
import java.util.Scanner;

/**
 * A utility that can perform useful operations on an array of data.
 * The utility should provide functions that will:
 * 1) accept an array of characters and swap the elements at adjacent indexes
 * 2) accept an array of characters and a string then return a new array
 * with the counts for each character array element in the string.
 *
 * @author Anthony Du
 * @author Shuhao Liu
 */
public class CharacterArray {

    /**
     * The method that is executed when the program is run
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] vowels = { 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u' };
        System.out.print("Enter string: ");
        String inputString = in.nextLine();
        int[] counts = countCharacters(vowels, inputString);
        for (int i = 0; i < vowels.length; i++) {
            System.out.println(vowels[i] + ": " + counts[i]);
        }

        System.out.println("Before swap: " + Arrays.toString(vowels));
        swapPairs(vowels);
        System.out.println("After swap:  " + Arrays.toString(vowels));
    }

    /**
     * Accepts an array of characters and swaps the elements at adjacent
     * indexes.That is, elements 0 and 1 are swapped, elements 2 and 3 are swapped,
     * and so on. If the array has an odd length, the final element should be left
     * unmodified.
     *
     * @param arr array of characters
     */
    public static void swapPairs(char[] arr) {
        char tempChar;
        for (int i = 0; i < arr.length - 1; i += 2) {
            tempChar = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = tempChar;
        }
    }

    /**
     * Return a new array with the counts for each character array element in the
     * string. The task should be case-sensitive.
     *
     * @param characters array of characters to find in str
     * @param str string to examine
     * @return counts of each character in string
     */
    public static int[] countCharacters(char[] characters, String str) {

        int length = characters.length;
        int[] counts = new int[length];

        if (str.length() < 1) {
            return counts;
        }

        for (int i = 0; i < length; i++) {
            char iChar = str.charAt(i);
            for (int j = 0; j < length; j++) {
                if (iChar == characters[j]) {
                    counts[j] += 1;
                }
            }
        }

        return counts;
    }

}
