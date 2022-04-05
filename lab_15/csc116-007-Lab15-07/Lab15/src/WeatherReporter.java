import java.util.*;
import java.io.*;

/**
 * Program to get input from weather text file and process
 *
 * @author Anthony Du
 * @author Bowen Deng
 */
public class WeatherReporter {


    /**
     * Magic number
     */
    public static final int FOUR = 4;

    /**
     * Magic number
     */
    public static final int SIX = 6;

    /**
     * Magic number
     */
    public static final int EIGHT = 8;

    /**
     * Starts program
     *
     * @param args command arguments
     */
    public static void main(String[] args) {
        // Set up scanner for console to read filename
        Scanner console = new Scanner(System.in);

        // Get file scanner (getInput method)
        Scanner in = getInput(console);

        // process file and print output to console
        System.out.println(processFile(in));
    }

    /**
     * Processes file (from Scanner) and returns string of processed file with correct output
     * format
     *
     * @param in input Scanner for file
     * @return string of processed file with correct output format
     */
    public static String processFile(Scanner in) {
        String str = "";
        in.nextLine();

        while (in.hasNextLine()) {
            str += processLine(in.nextLine()) + "\n";
        }

        return str;
    }

    /**
     * Processes a line of the text file (String) in order to return string with the
     * correct output format
     *
     * Reminder: tokens will be separated by commas
     *
     * @param line the line to be processed
     * @return processed line
     */
    public static String processLine(String line) {

        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter(",");
        String month, day, year, rain, snow;
        double low, high;

        String first = lineScanner.next();
        year = first.substring(0, FOUR);
        month = first.substring(FOUR, SIX);
        day = first.substring(SIX, EIGHT);

        // Skip the average temperature
        lineScanner.next();

        high = Double.parseDouble(lineScanner.next());
        low = Double.parseDouble(lineScanner.next());

        String last = lineScanner.next();
        rain = last.substring(1, 2).equals("1") ? "yes" : "no";
        snow = last.substring(2, 3).equals("1") ? "yes" : "no";

        return String.format("%2s/%2s/%4s Low:%6.1f High:%6.1f Rain:%4s Snow:%4s",
                                                    month, day, year, low, high, rain, snow);
    }

    /**
     * Prompt the user for a legal file name, create and return a Scanner tied to the file
     * Reprompt until Scanner is created.
     *
     * @param console console for user input
     * @return Scanner tied to the input file
     */
    public static Scanner getInput(Scanner console) {

        Scanner result = null;

        while (result == null){
            System.out.print("input file name? ");
            try {
                FileInputStream file = new FileInputStream(console.nextLine());
                result = new Scanner(file);
            }
            catch (FileNotFoundException e){
                System.out.print("File not found. Please try again.");
            }
        }
        return result;
    }

}
