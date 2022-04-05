import java.util.Scanner;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class is used as a command line command to calculate the
 * weighted, average, maximum, and minimum grades from the content of a CSV grade file
 * "-o" and "-s" are flags that represent overall mode and summary mode
 * overall mode outputs a CSV file containing the weighted grades of each student
 * summary mode outputs a CSV file containing the average, maximum, and minimum grades
 * of each grade item
 *
 * @author Anthony Du
 */
public class Grader {

    /**
     * Runs the program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        if (args.length != 3) {
            System.out.println("Usage: java -cp bin Grader {-o|-s} infile outfile");
            System.exit(1);
        }
        if (!args[0].equals("-o") && !args[0].equals("-s")) {
            System.out.println("Usage: java -cp bin Grader {-o|-s} infile outfile");
            System.exit(1);
        } else if (args[0].equals("-o")) {
            try {
                // check if input file exists before creating new file
                newFileScanner(args[1]).close();
                outputOverallGrades(args[1], newFileWriter(args[2], console));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        } else if (args[0].equals("-s")) {
            try {
                newFileScanner(args[1]).close();
                outputGradeSummary(args[1], newFileWriter(args[2], console));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

    }

    /**
     * Given input file name, outputs overall student grades to PrintWriter
     *
     * @param inputFile path of a file
     * @param out a PrintWriter that is used to write to a file
     */
    public static void outputOverallGrades(String inputFile, PrintWriter out) {
        newFileScanner(inputFile).close();
        checkPrintWriter(out);
        int[][] grades = getAllGrades(newFileScanner(inputFile), 1, 1);
        Scanner fileScanner = newFileScanner(inputFile);
        fileScanner.useDelimiter(",");
        fileScanner.nextLine();
        fileScanner.nextLine();
        for (int i = 0; i < grades.length; i++) {
            out.print(fileScanner.next() + ",");
            out.print(fileScanner.next() + ",");
            out.printf("%.2f", computeWeightedAverage(grades[i],
                        getWeights(newFileScanner(inputFile))));
            out.println("");
            fileScanner.nextLine();
        }
        fileScanner.close();
        out.close();
    }

    /**
     * Given input file name, outputs the summary of the students' grades to PrintWriter
     *
     * @param inputFile path of a file
     * @param out a PrintWriter that is used to write to a file
     */
    public static void outputGradeSummary(String inputFile, PrintWriter out) {
        newFileScanner(inputFile).close();
        checkPrintWriter(out);
        int[][] grades = getAllGrades(newFileScanner(inputFile), 1, 1);
        for (int i = 0; i < grades[0].length; i++) {
            out.print(getGradeItemNames(newFileScanner(inputFile))[i] + ",");
            out.printf("%.2f,", computeAverage(grades, i));
            out.print(getMinimum(grades, i) + ",");
            out.print(getMaximum(grades, i));
            out.println("");
        }
        out.close();
    }

    /**
     * Given a Scanner for a CSV grade file,
     * returns an array that contains the weights
     *
     * @param in a Scanner for a CSV grade file
     * @return an array that contains the weights
     */
    public static int[] getWeights(Scanner in) {
        checkFileScanner(in);
        in.nextLine();
        int[] weights = getIntsInRow(in.nextLine());
        in.close();
        return weights;
    }

    /**
     * Calculate and returns the weighted average / overall grade of a student
     *
     * @param grades an array of grades
     * @param weights an array of the grades' respective weights
     * @return the weighted average / overall grade
     * @throws IllegalArgumentException with the message
     * "Different array lengths", if the grades and weights arrays do not have the same lengths
     */
    public static double computeWeightedAverage(int[] grades, int[] weights) {
        if (grades.length != weights.length) {
            throw new IllegalArgumentException("Different array lengths");
        }
        checkWeights(weights);
        double weightedAverage = 0;
        for (int i = 0; i < grades.length ; i++) {
            weightedAverage += grades[i] * weights[i] / 100.0;
        }
        return weightedAverage;
    }

    /**
     * Gets the name of each grade items in the header row of the CSV file
     *
     * @param in a Scanner for a CSV grade file
     * @return an array that contains the grade item names
     */
    public static String[] getGradeItemNames(Scanner in) {
        checkFileScanner(in);
        String[] gradeItemNames = getStringsInRow(in.nextLine());
        in.close();
        return gradeItemNames;
    }

    /**
     * Gets all the student grades from the CSV dataset and output as a 2D array of integers
     *
     * @param in a Scanner for a CSV grade file
     * @param rows this parameter is not used, but it has to be a positive integer
     * @param columns this parameter is not used, but it has to be a positive integer
     * @return a 2D array of all the student grades
     */
    public static int[][] getAllGrades(Scanner in, int rows, int columns) {
        checkFileScanner(in);
        checkPositiveInt(rows, "rows");
        checkPositiveInt(columns, "columns");
        int[][] grades = new int[0][0];
        in.nextLine();
        in.nextLine();
        while (in.hasNextLine()) {
            grades = Arrays.copyOf(grades, grades.length + 1);
            grades[grades.length - 1] = getIntsInRow(in.nextLine());
        }
        in.close();
        return grades;
    }

    /**
     * Calculate and returns the average
     * of all the values in a specific column of the 2D grades array
     *
     * @param grades a 2D array of all the student grades
     * @param column indicates the column to average
     * @return the average of the values in the given column of the grades array
     */
    public static double computeAverage(int[][] grades, int column) {
        checkColumn(grades, column);
        checkJagged(grades);
        int sum = 0;
        for (int i = 0; i < grades.length ; i++) {
            sum += grades[i][column];
        }
        return (double) sum / grades.length;
    }

    /**
     * Finds and returns the minimum grade
     * in a specific column of the 2D grades array
     *
     * @param grades a 2D array of all the student grades
     * @param column indicates the column to get the minimum grade from
     * @return the minimum value in the given column of the grades array
     */
    public static int getMinimum(int[][] grades, int column) {
        checkColumn(grades, column);
        checkJagged(grades);
        int min = grades[0][column];
        for (int i = 0; i < grades.length; i++) {
            min = Math.min(min, grades[i][column]);
        }
        return min;
    }

    /**
     * Finds and returns the maximum grade
     * in a specific column of the 2D grades array
     *
     * @param grades a 2D array of all the student grades
     * @param column indicates the column to get the maximum grade from
     * @return the maximum value in the given column of the grades array
     */
    public static int getMaximum(int[][] grades, int column) {
        checkColumn(grades, column);
        checkJagged(grades);
        int max = grades[0][column];
        for (int i = 0; i < grades.length ; i++) {
            max = Math.max(max, grades[i][column]);
        }
        return max;
    }


    // This helper function is not used in the main program

    /**
     * Creates a new file Scanner from filename
     *
     * @param in a Scanner containing a String with am unknown number of lines
     * @return the number of lines that have been scanned by the Scanner
     */
    public static int getNumberOfLines(Scanner in) {
        checkFileScanner(in);
        int numberOfLines = 0;
        while (in.hasNextLine()) {
            in.nextLine();
            numberOfLines += 1;
        }
        in.close();
        return numberOfLines;
    }


    // Additional helper functions added by student

    /**
     * Creates a new file Scanner from filename
     *
     * @param filename path of a file
     * @return a file Scanner that reads the input stream of the file
     * @throws IllegalArgumentException with the message
     * "Unable to access input file: inputFile" if unable to access input file
     */
    public static Scanner newFileScanner(String filename) {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to access input file: " + filename);
        }
        return fileScanner;
    }

    /**
     * Creates a new file PrintWriter from filename
     *
     * @param filename path of a file
     * @param console a scanner that get input from console
     * @return a PrintWriter that writes to the output strean of the file
     * @throws IllegalArgumentException with the message
     * "Null PrintWriter" if out is null
     */
    public static PrintWriter newFileWriter(String filename, Scanner console) {
        PrintWriter fileWriter = null;
        if (Files.exists(Path.of(filename))) {
            System.out.println(filename + " exists - OK to overwrite");
            System.out.print("(y,n)?: ");
            if (console.next().toUpperCase().charAt(0) != 'Y') {
                System.exit(1);
            }
        }
        try {
            fileWriter = new PrintWriter(new FileOutputStream(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot create output file");
            System.exit(1);
        }
        return fileWriter;
    }

    /**
     * Gets and returns all grade items in a row of a grades CSV file as a String Array
     *
     * @param line the line to get grade items from
     * @return all grade items in a row of a grades CSV file as a String Array
     */
    public static String[] getStringsInRow(String line) {
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter(",");
        lineScanner.next();
        lineScanner.next();
        String[] items = new String[0];
        while (lineScanner.hasNext()) {
            items = Arrays.copyOf(items, items.length + 1);
            items[items.length - 1] = lineScanner.next();
        }
        lineScanner.close();
        return items;
    }

    /**
     * Gets and returns all grade items in a row of a grades CSV file as an int Array
     *
     * @param line the line to get grade items from
     * @return all grade items in a row of a grades CSV file as an int Array
     */
    public static int[] getIntsInRow(String line) {
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter(",");
        lineScanner.next();
        lineScanner.next();
        int[] items = new int[0];
        while (lineScanner.hasNextInt()) {
            items = Arrays.copyOf(items, items.length + 1);
            items[items.length - 1] = lineScanner.nextInt();
        }
        lineScanner.close();
        return items;
    }

    /**
     * Checks if a PrintWriter is null, throw an IllegalArgumentException with the message
     * "Null PrintWriter" if out is null
     *
     * @param out the PrintWriter to be checked
     * @throws IllegalArgumentException with the message
     * "Null PrintWriter" if out is null
     */
    public static void checkPrintWriter(PrintWriter out) {
        if (out == null) {
            throw new IllegalArgumentException("Null PrintWriter");
        }
    }

    /**
     * Checks if a weights array is valid, throw an IllegalArgumentException with the message
     * "Invalid weights", if the sum of the weights is not 100
     *
     * @param weights the weights array to be checked
     * @throws IllegalArgumentException with the message
     * "Invalid weights", if the sum of the weights is not 100
     */
    public static void checkWeights(int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
        }
        if (sum != 100) {
            throw new IllegalArgumentException("Invalid weights");
        }
    }

    /**
     * Checks if an integer with name is positive
     * throw an IllegalArgumentException with the message
     * "Invalid " + name, if that integer is < 1
     *
     * @param num the integer to be checked
     * @param name that name that's going to show up in the error message if exception is thrown
     * @throws IllegalArgumentException with the message
     * "Invalid " + name, if the integer is < 1
     */
    public static void checkPositiveInt(int num, String name) {
        if (num < 1) {
            throw new IllegalArgumentException("Invalid " + name);
        }
    }

    /**
     * Checks if a Scanner is null, throw an IllegalArgumentException with the message
     * "Null file" if fileScanner is null
     *
     * @param fileScanner the Scanner to be checked
     * @throws IllegalArgumentException with the message
     * "Null file" if fileScanner is null
     */
    public static void checkFileScanner(Scanner fileScanner) {
        if (fileScanner == null) {
            throw new IllegalArgumentException("Null file");
        }
    }

    /**
     * Checks if an column is inside the bounds of a 2D array
     * throw an IllegalArgumentException with the message
     * "Invalid column", if column is out of bounds
     *
     * @param arr the 2D array
     * @param column the column to check
     * @throws IllegalArgumentException with the message
     * "Invalid column", if column is out of bounds
     */
    public static void checkColumn(int[][] arr, int column) {
        if (column < 0 || column >= arr[0].length) {
            throw new IllegalArgumentException("Invalid column");
        }
    }

    /**
     * Checks if a 2D array is jagged
     * throw an IllegalArgumentException with the message
     * "Jagged array", if array is jagged
     *
     * @param arr the 2D array
     * @throws IllegalArgumentException with the message
     * "Jagged array", if array is jagged
     */
    public static void checkJagged(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arr[0].length) {
                throw new IllegalArgumentException("Jagged array");
            }
        }
    }
}
