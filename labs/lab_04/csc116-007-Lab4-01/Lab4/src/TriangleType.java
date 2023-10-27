import java.util.Scanner;

/**
 * Figures out the type of the triangle
 *
 * @author Anthony Du
 * @author Dominic Pupo
 */
public class TriangleType {

    /**
     * Figures out the type of the triangle
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Triangle program provides the type of any triangle.");
        System.out.println("Please enter the lengths of sides a, b, and c.");
        System.out.print("Enter a: ");
        int a = in.nextInt();
        System.out.print("Enter b: ");
        int b = in.nextInt();
        System.out.print("Enter c: ");
        int c = in.nextInt();

        if ((a + b <= c) || (b + c <= a) || (a + c <= b) || (a <= 0) || (b <= 0) || (c <= 0)) {
            System.out.println("Not a valid triangle");
        } else {
            if ((a == b) && (b == c)) {
                System.out.println("Equilateral triangle");
            } else if (((a == b) && (c != a)) || ((a == c) && (b != a)) || ((b == c) && (a != b))) {
                System.out.println("Isosceles triangle");
            } else {
                System.out.println("Scalene triangle");
            }
        }
    }

}
