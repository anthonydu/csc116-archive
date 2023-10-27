import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileAnalyzer {

    public static void analyzeFile(Scanner in, PrintWriter out) {
        int lineNumber = 1;
        int numOfTokens = 0;
        while (in.hasNextLine()) {
            String inNextLine = in.nextLine();
            out.println(lineNumber + " " + inNextLine);
            lineNumber += 1;
            Scanner lineScanner = new Scanner(inNextLine);
            while (lineScanner.hasNext()) {
                numOfTokens += 1;
                lineScanner.next();
            }
        }
        out.println("Number of Tokens: " + numOfTokens);
        in.close();
        out.close();
    }

    static Scanner getInput(Scanner console) {
        Scanner in = null;
        while (in == null) {
            System.out.print("Enter the input filename: ");
            String filename = console.nextLine();
            try {
                in = new Scanner(new FileInputStream(filename));
            } catch (FileNotFoundException e) {
                System.out.println("File not found, please try again");
            }
        }
        return in;
    }

    static PrintWriter getOutput(Scanner console) {
        PrintWriter out = null;
        while (out == null) {
            System.out.print("Enter the output filename: ");
            String filename = console.nextLine();
            Path path = Path.of(filename);
            if (!Files.exists(path)) {
                try {
                    out = new PrintWriter(new FileOutputStream(filename));
                } catch (FileNotFoundException e) {
                    System.out.println("Couldn't read file for some reason");
                }
            }
        }

        return out;
    }

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        Scanner in = getInput(c);
        PrintWriter out = getOutput(c);
        analyzeFile(in, out);
    }
}
