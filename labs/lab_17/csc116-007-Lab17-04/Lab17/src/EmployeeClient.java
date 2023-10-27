import java.util.Scanner;

/**
 * Client code for Employee class
 *
 * @author Jessica Young Schmidt
 * @author Om Pandey
 * @author Anthony Du
 */
public class EmployeeClient {

    /** Number of employee names to read in from the console */
    private static final int NUM_EMPLOYEES = 3;

    /**
     * Starts program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Employee[] employees = getEmployees(console);
        System.out.println("\nEmployees:");
        for (Employee e : employees) {
            System.out.println(e.getNormalOrder() + " (" + e.getUnityID() + ")");
        }
    }

    /**
     * Sets up Array of Employees
     *
     * @param console Scanner for console
     * @return Array of Employees input from console
     */
    public static Employee[] getEmployees(Scanner console) {
        Employee[] employees = new Employee[NUM_EMPLOYEES];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee();
            System.out.print("Enter employee name (first middle last): ");
            employees[i].setFirstName(console.next());
            employees[i].setMiddleInitial(console.next().charAt(0));
            employees[i].setLastName(console.next());
        }
        return employees;
    }
}
