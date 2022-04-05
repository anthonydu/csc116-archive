import java.util.Scanner;

/**
 * Prints out if all digits of an integer are odd
 *
 * @author Anthony Du
 * @author Shuhao Liu
 */
public class AllDigitsOdd {

    /**
     * Starts the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter integer: ");

        while (!scnr.hasNextInt()) {
            scnr.next();
            System.out.print("Please enter an integer: ");
        }
        int num = scnr.nextInt();
        System.out.println(num + ": " + areAllDigitsOdd(num));
    }

    /**
     * Returns true or false depending on if all digits of an integer are odd.
     *
     * @param num the integer that we want to know if all of its digits are odd.
     * @return if all digits are odd return true, if any digit is even return false.
     */
    public static boolean areAllDigitsOdd(int num) {

        if (num == 0) {
            return false;
        }

        while (num != 0) {
            if (lastDigit(num) % 2 == 0) {
                return false;
            }
            num = withoutLastDigit(num);
        }
        return true;
    }

    /**
     * Returns the last digit of an integer as an integer.
     *
     * @param val the integer that we want to get the last digit from.
     * @return the last digit of the number as an integer.
     */
    public static int lastDigit(int val) {
        return (Math.abs(val) % 10);
    }

    /**
     * Returns the every digit except the last digit of an integer as an integer.
     *
     * @param val the integer that we want to get every digit except the last digit from.
     * @return every digit except the last digit of the number as an integer. 
     */
    public static int withoutLastDigit(int val) {
        return (Math.abs(val) / 10);
    }

}
