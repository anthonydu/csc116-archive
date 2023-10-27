import java.util.*;
import java.io.*;
import java.nio.file.*;

/**
 * This program will output a text to an output file after collapsing spaces
 *
 * @author Om Pandey
 * @author Anthony Du
 */
public class Collapse {

   /**
    * Prompts user for input filename (and reprompts as needed until file is
    * found). Prompts user for output filename. If output file does not already
    * exist, collapse spaces for input file and write into output file. If output
    * file already exists, print error message to console.
    *
    * @param args command line arguments
    *
    * @throws FileNotFoundException if file does not exist
    */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        Scanner in = getInput(console);
        PrintWriter out = null;
        try {
            out = getOutput(console);
            collapseSpaces(in, out);
        } catch (NullPointerException e) {
            System.out.println("Output file already exists!");
        }
    }

   /**
    * Outputs collapsed input file into output file
    *
    * @param in Scanner for input file
    * @param out PrintWriter for output file
    */
    public static void collapseSpaces(Scanner in, PrintWriter out) {
        while (in.hasNextLine()) {
            out.println(collapseLine(in.nextLine()));
        }
        out.close();
    }

   /**
    * Returns string with spaces collapsed
    *
    * @param line input string to collapse spaces
    * @return string with spaces collapsed
    */
    public static String collapseLine(String line) {
        Scanner lineScanner = new Scanner(line);
        String collapsedString = "";
        if (lineScanner.hasNext()) {
            while (lineScanner.hasNext()) {
                collapsedString += lineScanner.next() + " ";
            }
            collapsedString = collapsedString.substring(0, collapsedString.length() - 1);
        } else {
            return "";
        }
        lineScanner.close();
        return collapsedString;
    }

   /**
    * Prompts the user for an output filename, then creates and returns a
    * PrintStream tied to the file. If file with filename already exists, returns
    * null.
    *
    * @param console console input scanner
    *
    * @return PrintWriter for output file, or null if file exists
    *
    * @throws FileNotFoundException if file does not exist
    */
    public static PrintWriter getOutput(Scanner console) throws FileNotFoundException {
        PrintWriter result = null;
        while (result == null) {
            System.out.print("output filename? ");
            String fileName = console.nextLine();
            Path path = Path.of(fileName);
            if (!Files.exists(path)) {
                FileOutputStream file = new FileOutputStream(fileName);
                result = new PrintWriter(file);
            }
            else {
                break;
            }
        }
        return result;
    }

   /**
    * Prompts the user for an input filename, then creates and returns a Scanner
    * tied to the file. Reprompts as needed if file does not exist.
    *
    * @param console console input scanner
    *
    * @return scanner for input file
    */
    public static Scanner getInput(Scanner console) {
        Scanner result = null;
        while (result == null) {
            System.out.print("input filename? ");
            try {
                FileInputStream file = new FileInputStream(console.nextLine());
                result = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("Input file not found.");
            }
        }
        return result;
    }
}
