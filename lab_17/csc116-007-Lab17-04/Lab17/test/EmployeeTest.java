import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Employee class
 *
 * @author Om Pandey
 * @author Anthony Du
 */
public class EmployeeTest {

    /** The Employee class's object */
    private Employee emp;

    /**
     * Sets up the Employee class's object
     */
    @BeforeEach
    public void setUp() {
        emp = new Employee();
    }

    /**
     * Tests each of the employee class's methods with the name Jessica Y. Schmidt
     */
    @Test
    public void testExample() {
        emp.setFirstName("Jessica");
        emp.setLastName("Schmidt");
        emp.setMiddleInitial('Y');
        assertEquals("Jessica Y. Schmidt", emp.getNormalOrder(), "getNormalOrder");
        assertEquals("Schmidt, Jessica Y.", emp.getReverseOrder(), "getReverseOrder");
        assertEquals("jyschmid", emp.getUnityID(), "getUnityID");
        assertEquals("JYS", emp.getInitials(), "getInitials");
        assertEquals(15, emp.length(), "length");
    }

    /**
     * Tests employee class's first name methods
     */
    @Test
    public void testSetFirstName() {
        emp.setFirstName("Jessica");
        assertEquals("Jessica", emp.getFirstName(), "getFirstName");
    }

    /**
     * Tests employee class's last name methods
     */
    @Test
    public void testSetLastName() {
        emp.setLastName("Schmidt");
        assertEquals("Schmidt", emp.getLastName(), "getLastName");
    }

    /**
     * Tests employee class's middle initial methods
     */
    @Test
    public void testGetMiddleInitial() {
        emp.setMiddleInitial('Y');
        assertEquals('Y', emp.getMiddleInitial(), "getMiddleInitial");
    }

    /**
     * Tests each of the employee class's methods with the name Om V. Pandey
     */
    @Test
    public void testExampleOm() {
        emp.setFirstName("Om");
        emp.setLastName("Pandey");
        emp.setMiddleInitial('V');
        assertEquals("Om V. Pandey", emp.getNormalOrder(), "getNormalOrder");
        assertEquals("Pandey, Om V.", emp.getReverseOrder(), "getReverseOrder");
        assertEquals("ovpandey", emp.getUnityID(), "getUnityID");
        assertEquals("OVP", emp.getInitials(), "getInitials");
        assertEquals(9, emp.length(), "length");
    }

    /**
     * Tests each of the employee class's methods with the name Pu A. Du
     */
    @Test
    public void testExamplePu() {
        emp.setFirstName("Pu");
        emp.setLastName("Du");
        emp.setMiddleInitial('A');
        assertEquals("Pu A. Du", emp.getNormalOrder(), "getNormalOrder");
        assertEquals("Du, Pu A.", emp.getReverseOrder(), "getReverseOrder");
        assertEquals("padu", emp.getUnityID(), "getUnityID");
        assertEquals("PAD", emp.getInitials(), "getInitials");
        assertEquals(5, emp.length(), "length");
    }
}
