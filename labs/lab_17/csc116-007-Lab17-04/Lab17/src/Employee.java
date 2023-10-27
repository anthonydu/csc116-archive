/**
 * This program will use employee's first name, middle initial, and last name
 * to do such name operations.
 *
 * @author Om Pandey
 * @author Anthony Du
 */
public class Employee {

    /** The first name */
    private String firstName;

    /** The middle initial */
    private char middleInitial;

    /** The last name */
    private String lastName;

    /** The UnityID limit */
    public static final int UNITY_ID_LIMIT = 6;

    /**
     * Sets the firstName of the employee
     *
     * @param firstName the first name of the employee
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the firstName of the employee
     *
     * @return the first name of the employee
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the middleInitial of the employee
     *
     * @param middleInitial the middle initial of the employee
     */
    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    /**
     * Gets the middleInitial of the employee
     *
     * @return the middle initial of the employee
     */
    public char getMiddleInitial() {
        return middleInitial;
    }

    /**
     * Sets the lastName of the employee
     *
     * @param lastName the last name of the employee
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the lastName of the employee
     *
     * @return the last name of the employee
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the person's name in normal order,
     * with the first name followed by the middle initial and last name.
     * For example, if the first name is "Jessica",
     * the middle initial is 'Y',
     * and the last name is "Schmidt",
     * returns "Jessica Y. Schmidt".
     *
     * @return the employee's name in normal order
     */
    public String getNormalOrder() {
        return "" + getFirstName() + " " + getMiddleInitial() + ". " + getLastName();
    }

    /**
     * Returns the person's name in reverse order,
     * with the last name preceding the first name and middle initial.
     * For example, if the first name is "Jessica",
     * the middle initial is 'Y',
     * and the last name is "Schmidt",
     * returns "Schmidt, Jessica Y."
     *
     * @return the employee's name in reverse order
     */
    public String getReverseOrder() {
        return "" + getLastName() + ", " + getFirstName() + " " + getMiddleInitial() + ".";
    }

    /**
     * Returns the unity ID for the Employee
     * where the unity ID is the combination of the first letter of the first name,
     * the middle initial, and the first six letter of the last name.
     * If the last name has fewer than six letters then full last name is used.
     * Unity IDs will be all lowercase letters.
     * For now we are assuming we do not have to deal with duplicates or numbers.
     * For example, if the first name is "Jessica",
     * the middle initial is 'Y',
     * and the last name is "Schmidt",
     * returns "jyschmid".
     *
     * @return the employee's Unity ID
     */
    public String getUnityID() {
        if (getLastName().length() > UNITY_ID_LIMIT) {
            return "" + getFirstName().toLowerCase().charAt(0)
                      + Character.toLowerCase(getMiddleInitial())
                      + getLastName().toLowerCase().substring(0, UNITY_ID_LIMIT);
        } else {
            return "" + getFirstName().toLowerCase().charAt(0)
                      + Character.toLowerCase(getMiddleInitial())
                      + getLastName().toLowerCase();
        }

    }

    /**
     * Returns the initials (combination of first letter of first name,
     * middle initial,
     * and first letter of last name) for the Employee.
     * Initials should all be in uppercase letters.
     * For example, if the first name is "Jessica",
     * the middle initial is 'Y',
     * and the last name is "Schmidt",
     * returns "JYS".
     *
     * @return the employee's initials
     */
    public String getInitials() {
        return "" + getFirstName().toUpperCase().charAt(0)
                  + Character.toUpperCase(getMiddleInitial())
                  + getLastName().toUpperCase().charAt(0);
    }

    /**
     * Returns the total number of letters in the first name,
     * middle initial,
     * and last name.
     * For example, if the first name is "Jessica",
     * the middle initial is 'Y',
     * and the last name is "Schmidt",
     * returns 15.
     *
     * @return the total number of letters in the name
     */
    public int length() {
        return getFirstName().length() + 1 + getLastName().length();
    }
}
