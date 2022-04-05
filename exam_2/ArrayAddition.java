import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class ArrayAddition {

    /* Your solution should go here */
    public static int[][] addArrays(int[][] arr1, int[][] arr2) throws IllegalArgumentException {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].length != arr2[i].length) {
                throw new IllegalArgumentException();
            }
        }
        int[][] sumArr = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                sumArr[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return sumArr;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the alpha addition of my two-dimensional array math program!");
        // TODO: Update this after I add support for other matrix math operations
        System.out.println("Currently I only support addition.");

        Scanner console = new Scanner(System.in);
        String input;
        do {
            System.out.print("How many rows will your two-dimensional array have? ");
            int rows = console.nextInt();
            System.out.print("How many columns will your two-dimensional array have? ");
            int cols = console.nextInt();

            int[][] f = new int[rows][cols];
            System.out.println("Lets populate your first two-dimensional array!");
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print("What value would you like at row " + row
                        + " column " + col + "? ");
                    f[row][col] = console.nextInt();
                }
            }

            int[][] s = new int[rows][cols];
            System.out.println("Lets populate your second two-dimensional array!");
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print("What value would you like at row " + row
                        + " column " + col + "? ");
                    s[row][col] = console.nextInt();
                }
            }

            int[][] r = addArrays(f, s);
            System.out.println("Your matrices added together are");
            System.out.println(Arrays.deepToString(r));

            System.out.print("Type quit or q to quit, anything else to continue: ");
            input = console.nextLine();
        } while (!input.equals("quit") && !input.equals("q"));
    }
}
