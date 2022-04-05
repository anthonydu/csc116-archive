import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Process an input file to report simple statistics to identify the minimum
 * integer token value in the file, the maximum integer token value in the file,
 * the sum of all integer token values in the file, the count (how many) of integer
 * tokens are in the file, and the average of all integer token values in the file.
 *
 * @author Anthony Du
 * @author Bowen Deng
 */
public class ProcessFile {

    /** Index for count within stats array */
    public static final int INDEX_FOR_COUNT = 0;

    /** Index for minimum value within stats array */
    public static final int INDEX_FOR_MIN = 1;

    /** Index for maximum value within stats array */
    public static final int INDEX_FOR_MAX = 2;

    /** Index for sum within stats array */
    public static final int INDEX_FOR_SUM = 3;

    /**
     * Starts the program.
     *
     * @param args command line arguments
     * @throws FileNotFoundException if the file doesn't exist
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1){
            System.out.println("Usage: java -cp bin ProcessFile input_filename");
            System.exit(1);
        } else {
            System.out.println(processFile(args[0]));
        }

    }

    /**
     * Returns string version of stats for the given file.
     *
     * @param filename path to a file
     * @return String stats extracted from file converted to String
     * @throws FileNotFoundException if the file doesn't exist
     */
    public static String processFile(String filename) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new FileInputStream(filename));
        int[] stats = process(fileScanner);
        fileScanner.close();

        return statsToString(stats);
    }

    // Returns string version of stats. Given array of four
    // elements: number of integers in scanner, minimum integer value in scanner,
    // maximum integer value in scanner, and sum of all integer values in scanner.

    /**
     * Returns string version of stats. Given array of four
     * elements: number of integers in scanner, minimum integer value in scanner,
     * maximum integer value in scanner, and sum of all integer values in scanner.
     *
     * @param stats number of integers in scanner, minimum integer value in scanner,
     * maximum integer value in scanner, and sum of all integer values in scanner.
     * @return String version of stats
     */
    public static String statsToString(int[] stats) {

        if (stats[INDEX_FOR_COUNT] > 0) {
            double average = stats[INDEX_FOR_SUM] / stats[INDEX_FOR_COUNT];

            return "Maximum = " + stats[INDEX_FOR_MAX] + "\nMinimum = " + stats[INDEX_FOR_MIN]
                    + "\nSum = " + stats[INDEX_FOR_SUM] + "\nCount = " + stats[INDEX_FOR_COUNT]
                    + "\nAverage = " + average;
        } else {
            return "No integers.";
        }
    }

    /**
     * Process scanner only examining integers in it. Returns array of four
     * elements: number of integers in scanner, minimum integer value in scanner,
     * maximum integer value in scanner, and sum of all integer values in scanner.
     * if the scanner contains no integers, returns array {0, 0, 0, 0}.
     *
     * @param scan Scanner to get user console input
     * @return an interger array with the values of count, min, max, and sum
     */
    public static int[] process(Scanner scan) {

        int count = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                int nextInt = scan.nextInt();
                count += 1;
                min = Math.min(min, nextInt);
                max = Math.max(max, nextInt);
                sum += nextInt;
            } else {
                scan.next();
            }
        }

        if (count == 0) {
            return new int[]{0, 0, 0, 0};
        } else {
            return new int[]{count, min, max, sum};
        }
    }
}
