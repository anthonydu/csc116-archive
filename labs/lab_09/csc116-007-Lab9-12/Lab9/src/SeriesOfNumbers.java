import java.util.Scanner;

/**
 * A program with a for loop that produces series of squares based on user input
 *
 * @author Anthony Du
 * @author Shuhao Liu
 */
public class SeriesOfNumbers {

    /**
     * The method that is executed when the program is run
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("This program will display a series of numbers that "
                + "are the squares of consecutive values to the max (user-provided integer)."
                + "\nNote: program will reprompt for max until a positive integer is given.");
        int maxVal;
        do {
            maxVal = getInteger(in);
        } while (maxVal <= 0);
        System.out.println(getSeries(maxVal));

    }

    /**
     * Returns integer value from the Scanner. Continues to reprompt for integer
     * until an integer value is given.
     *
     * @param in input scanner
     * @return integer value from Scanner
     */
    public static int getInteger(Scanner in) {
        System.out.print("Enter integer: ");
        while (!in.hasNextInt()) {
            in.next();
            System.out.print("Enter integer: ");
        }
        return in.nextInt();
    }

    /**
     * Gets the series of squares from 1 to max. Method cannot use multiplication or
     * division.
     *
     * @param max max number to square
     * @return series of squares from 1 to max
     * @throws IllegalArgumentException if max is non-positive. Message:
     *             Non-positive integer (max)
     */
    public static String getSeries(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("Non-positive integer (" + max + ")");
        }
        String outString = "";
        int iSquared;
        for (int i = 1; i <= max; i++) {
            iSquared = 0;
            // we just realized that we could have just added
            // consecutive odd numbers to get the new number
            // we failed to read the instructions carefully yet again
            for (int j = 0; j < i; j++) {
                iSquared += i;
            }
            if (i != max) {
                outString += iSquared + " ";
            } else {
                outString += iSquared;
            }
        }
        return outString;
    }
}
