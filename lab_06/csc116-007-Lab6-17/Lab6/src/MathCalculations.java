import java.util.Scanner;

/**
 * Program calculates the lowest number, highest number, sum of the numbers,
 * the average, and the median given 2, 3, or 4 numbers.
 *
 * @author Anthony Du and Shuhao Liu
 */
public class MathCalculations {
    /**
     * avoids magic numbers
     */
    static int FOUR = 1 + 1 + 1 + 1;

    /**
     * Starts the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many values (2, 3, or 4) will you enter? ");
        int numValues = in.nextInt();
        if (numValues == 2 || numValues == 3 || numValues == FOUR) {
            calculations(in, numValues);
        } else {
            System.out.println("Invalid input.");
        }
    }

    /**
     * calculates the min, max, sum, mean, and median
     * given user input and based of the number of values in data set
     *
     * @param in scanner for input
     * @param numValues number of values in data set
     */
    public static void calculations(Scanner in, int numValues) {
        if (numValues == 2) {
            System.out.print("Enter two integers: ");
            int val1 = in.nextInt();
            int val2 = in.nextInt();
            System.out.println("Minimum: " + min(val1, val2));
            System.out.println("Maximum: " + max(val1, val2));
            System.out.println("Sum: " + sum(val1, val2));
            System.out.println("Mean: " + mean(val1, val2));
            System.out.println("Median: " + median(val1, val2));
        }

        if (numValues == 3) {
            System.out.print("Enter three integers: ");
            int val1 = in.nextInt();
            int val2 = in.nextInt();
            int val3 = in.nextInt();
            System.out.println("Minimum: " + min(val1, val2, val3));
            System.out.println("Maximum: " + max(val1, val2, val3));
            System.out.println("Sum: " + sum(val1, val2, val3));
            System.out.println("Mean: " + mean(val1, val2, val3));
            System.out.println("Median: " + median(val1, val2, val3));
        }

        if (numValues == FOUR) {
            System.out.print("Enter four integers: ");
            int val1 = in.nextInt();
            int val2 = in.nextInt();
            int val3 = in.nextInt();
            int val4 = in.nextInt();
            System.out.println("Minimum: " + min(val1, val2, val3, val4));
            System.out.println("Maximum: " + max(val1, val2, val3, val4));
            System.out.println("Sum: " + sum(val1, val2, val3, val4));
            System.out.println("Mean: " + mean(val1, val2, val3, val4));
            System.out.println("Median: " + median(val1, val2, val3, val4));
        }
    }

    /**
     * calculates minimum value given two integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @return min of given values
     */
    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    /**
     * calculates minimum value given three integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @param c 3rd int
     * @return min of given values
     */
    public static int min(int a, int b, int c) {
        return min(min(a, b), c);
    }

    /**
     * calculates minimum value given four integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @param c 3rd int
     * @param d 4th int
     * @return min of given values
     */
    public static int min(int a, int b, int c, int d) {
        return min(min(a, b, c), d);
    }

    /**
     * calculates maximum value given two integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @return max of given values
     */
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * calculates maximum value given three integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @param c 3rd int
     * @return max of given values
     */
    public static int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    /**
     * calculates maximum value given four integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @param c 3rd int
     * @param d 4th int
     * @return max of given values
     */
    public static int max(int a, int b, int c, int d) {
        return max(max(a, b, c), d);
    }

    /**
     * calculates sum given two integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @return sum of given values
     */
    public static int sum(int a, int b) {
        return a + b;
    }

    /**
     * calculates sum given three integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @param c 3rd int
     * @return sum of given values
     */
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    /**
     * calculates sum given four integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @param c 3rd int
     * @param d 4th int
     * @return sum of given values
     */
    public static int sum(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    /**
     * calculates mean given two integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @return mean of given values
     */
    public static double mean(int a, int b) {
        return (a + b) / 2.0;
    }

    /**
     * calculates mean given three integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @param c 3rd int
     * @return mean of given values
     */
    public static double mean(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    /**
     * calculates mean given four integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @param c 3rd int
     * @param d 4th int
     * @return mean of given values
     */
    public static double mean(int a, int b, int c, int d) {
        return (a + b + c + d) / (double)FOUR;
    }

    /**
     * calculates median given two integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @return median of given values
     */
    public static double median(int a, int b) {
        return (a + b) / 2.0;
    }

    /**
     * calculates median given three integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @param c 3rd int
     * @return median of given values
     */
    public static double median(int a, int b, int c) {
        return max(min(a, b), min(a, c), min(b, c));
    }

    /**
     * calculates median given four integers
     *
     * @param a 1st int
     * @param b 2nd int
     * @param c 3rd int
     * @param d 4th int
     * @return median of given values
     */
    public static double median(int a, int b, int c, int d) {
        if (d < max(a, b, c) && d > min(a, b, c)) {
            // in this case d is either the second or third smallest or largest number
            // and median of abc will be the other second or third smallest or largest number
            return (d + median(a, b, c)) / 2;
        } else if (d <= min(a, b, c)) {
            // in this case min of abc will be the second smallest number
            // and median of abc will be the second largest number
            return (min(a, b, c) + median(a, b, c)) / 2;
        } else if (d >= max(a, b, c)) {
            // in this case max of abc will be the second largest number
            // and median of abc will be the second smallest number
            return (max(a, b, c) + median(a, b, c)) / 2;
        } else {
            // this last else is useless but required by Java
            return 0;
        }
    }

}
