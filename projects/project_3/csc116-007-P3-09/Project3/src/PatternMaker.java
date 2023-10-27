import java.util.Scanner;

/**
 * This is a program that makes square, triangle, or diamond patterns based on user input.
 *
 * @author Anthony Du
 */
public class PatternMaker {

    /**
     * Terminal user interface
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("Pattern Maker - Please choose an option.");
            System.out.println("");
            System.out.println("S - Square");
            System.out.println("T - Triangle");
            System.out.println("D - Diamond");
            System.out.println("Q - Quit");
            System.out.println("");

            System.out.print("Option: ");
            String optionInput = scnr.next();
            char option = (optionInput.length() == 1) ? optionInput.toUpperCase().charAt(0) : ' ';

            int rows, columns;
            switch (option) {
                case 'S':
                    rows = getSize(scnr, "rows");
                    if (rows == -1) continue;
                    // restart the loop if invalid size, print statement included in getSize
                    // else pass and get result
                    columns = getSize(scnr, "columns");
                    if (columns == -1) continue;
                    System.out.println("");
                    System.out.println(getSquares(rows, columns));
                    break;
                case 'T':
                    rows = getSize(scnr, "rows");
                    if (rows == -1) continue;
                    System.out.println("");
                    System.out.println(getTriangles(rows));
                    break;
                case 'D':
                    rows = getSize(scnr, "rows");
                    if (rows == -1) continue;
                    System.out.println("");
                    System.out.println(getDiamonds(rows));
                    break;
                case 'Q':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    /**
     * Checks if size type is either rows or columns
     *
     * @param type String object used for prompt and error message
     * @throws IllegalArgumentException "Invalid type" if type is neither rows nor columns
     */
    public static void checkSizeType(String type) {
        if (!(type.equals("rows") || type.equals("columns"))) {
            throw new IllegalArgumentException("Invalid type");
        }
    }

    /**
     * Checks if rows or columns is valid
     *
     * @param size a rows or columns value
     * @param type String object used for prompt and error message
     * @throws IllegalArgumentException "Invalid type" if type is neither rows nor columns
     */
    public static void checkSize(int size, String type) {
        checkSizeType(type);
        if (size < 1 || size > 10) {
            throw new IllegalArgumentException("Invalid " + type);
        }
    }

    /**
     * Asks user for input until a valid rows or columns is entered
     *
     * @param scnr Scanner object used for parsing user input
     * @param type String object used for prompt and error message
     * @return a valid rows or columns integer, or -1 if invalid
     */
    public static int getSize(Scanner scnr, String type) {
        checkSizeType(type);
        System.out.print(type.substring(0, 1).toUpperCase() + type.substring(1) + ": ");
        if (scnr.hasNextInt()) {
            int size = scnr.nextInt();
            if (size >= 1 && size <= 10) {
                return size;
            } else {
                System.out.println("Invalid " + type);
                return -1;
            }
        } else {
            System.out.println("Invalid " + type);
            return -1;
        }
    }

    /**
     * Repeats a string a number of times
     *
     * @param str the string to be repeated
     * @param count the number of time str is repeated
     * @return a new string containing str repeated count number of times
     */
    public static String repeat(String str, int count) {
        String newStr = "";
        for (int i = 0; i < count; i++) {
            newStr += str;
        }
        return newStr;
    }

    /**
     * Returns a string containing a Square pattern with the given number of rows and columns
     * formatted as described above. Each line of the pattern ends with a newline character.
     *
     * @param rows the number of squares in a row
     * @param columns the number of squares in a column
     * @return a string containing a Square pattern with the given number of rows and columns
     * @throws IllegalArgumentException "Invalid rows", if rows < 1 or rows > 10
     * @throws IllegalArgumentException "Invalid columns", if cols < 1 or cols > 10
     */
    public static String getSquares(int rows, int columns) {
        checkSize(rows, "rows");
        checkSize(columns, "columns");
        String squares = "";
        squares += repeat(" _", columns) + "\n";
        for (int i = 0; i < rows; i++) {
            squares += repeat("|_", columns) + "|\n";
        }
        return squares;
    }

    /**
     * Returns a string containing a Triangle pattern with the given number of rows
     * formatted as described above. Each line of the pattern ends with a newline character.
     *
     * @param rows the number of rows of triangles
     * @return a string containing a Triangle pattern with the given number of rows and columns
     * @throws IllegalArgumentException "Invalid rows", if rows < 1 or rows > 10
     */
    public static String getTriangles(int rows) {
        checkSize(rows, "rows");
        String triangles = "";
        int firstRowSpaces = rows * 2 - 1;
        for (int i = 0; i < rows; i++) {
            triangles += repeat(" ", firstRowSpaces - i * 2);
            triangles += repeat("/\\  ", i) + "/\\\n";
            triangles += repeat(" ", firstRowSpaces - i * 2 - 1);
            triangles += repeat("/__\\", i + 1) + "\n";
        }
        return triangles;
    }

    /**
     * Returns a string containing a Diamond pattern with the given number of rows
     * formatted as described above. Each line of the pattern ends with a newline character.
     *
     * @param rows the number of rows of diamonds
     * @return a string containing a Diamond pattern with the given number of rows and columns
     * @throws IllegalArgumentException "Invalid rows", if rows < 1 or rows > 10
     */
    public static String getDiamonds(int rows) {
        checkSize(rows, "rows");
        String diamonds = "";
        int firstRowSpaces = rows - 1;
        for (int i = 0; i < rows; i++) {
            diamonds += repeat(" ", firstRowSpaces - i);
            diamonds += repeat("/\\", i + 1) + "\n";
        }
        diamonds += repeat("\\/", rows) + "\n";
        return diamonds;
    }
}
