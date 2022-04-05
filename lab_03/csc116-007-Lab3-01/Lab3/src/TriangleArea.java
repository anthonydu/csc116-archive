import java.util.Scanner;

/**
 * The corrected version of TriangleArea.java
 *
 * @author Anthony Du
 * @author Dominic Pupo
 */
public class TriangleArea {

    /**
     * Calculates the area of a triangle given the length of the three sides\
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter side A of triangle (as int): ");
        int sideA = in.nextInt();
        System.out.print("Enter side B of triangle (as int): ");
        int sideB = in.nextInt();
        System.out.print("Enter side C of triangle (as int): ");
        int sideC = in.nextInt();
        double s = (sideA + sideB + sideC) / 2.0;
        double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        System.out.println("The area of the triangle is: " + area);
    }

}
