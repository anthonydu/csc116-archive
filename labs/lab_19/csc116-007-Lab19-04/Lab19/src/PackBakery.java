/**
 * PackBakery regarding the whole menu
 *
 * @author Om Pandey, Anthony Du
 */
public class PackBakery {

    /** The default menu size */
    public static final int DEFAULT_MENU_SIZE = 3;

    /** Declare menu Sandwich Array */
    private Sandwich[] menu;

    /**
     * Constructs a new PackBakery instance with menu of menuSize
     *
     * @param menuSize the size of the menu
     */
    public PackBakery(int menuSize) {
        menu = new Sandwich[menuSize];
    }

    /** Constructs a new PackBakery instance with menu of DEFAULT_MENU_SIZE */
    public PackBakery() {
        menu = new Sandwich[DEFAULT_MENU_SIZE];
    }

    /**
     * Adds a sandwich to the menu Array
     *
     * @param sandwich the Sandwich to add
     * @return true if sandwich sucessfully added, otherwise false
     */
    public boolean addSandwich(Sandwich sandwich) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == null) {
                menu[i] = sandwich;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a sandwich from the menu Array
     *
     * @param sandwich the Sandwich to remove
     * @return true if sandwich sucessfully removed, otherwise false
     */
    public boolean removeSandwich(Sandwich sandwich) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                if (sandwich.equals(menu[i])) {
                    menu[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Gets a sandwich of specific name from the menu Array
     *
     * @param name name of the sandwich to get
     * @return the sandwich or null if sandwich name could not be found the the menu Array
     */
    public Sandwich getSandwich(String name) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                if (name.equals(menu[i].getName())) {
                    return menu[i];
                }
            }
        }
        return null;
    }

    /**
     * Gets the menu
     *
     * @return the menu
     */
    public Sandwich[] getMenu() {
        return menu;
    }
}
