import java.util.Scanner;

public class Calculator {
    public static int calculate(char op, int x, int y) {
        switch (op) {
            case '+':
                return (x + y);
            case '-':
                return (x - y);
            case '*':
                return (x * y);
            case '/':
                return (x / y);
            default:
                throw new IllegalArgumentException("Bad operation: " + op);
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("x: ");
        int x = scnr.nextInt();
        System.out.print("y: ");
        int y = scnr.nextInt();
        System.out.print("operation: ");
        char op = scnr.next().charAt(0);

        System.out.println("Calculated: " + calculate(op, x, y));
    }
}
