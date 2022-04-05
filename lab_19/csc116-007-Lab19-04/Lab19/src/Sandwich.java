/**
 * Sandwich class regarding the Sandwich's name
 *
 * @author Om Pandey, Anthony Du
 */
public class Sandwich {

    /** The name of the sandwich */
    private String name;

    /** The bread used in the sandwich */
    private Bread bread;

    /** The filling used in the sandwich */
    private SandwichFilling filling;

    /**
     * Constructs a new Sandwich with a name and its content (a bread and a filling)
     *
     * @param name the name of the sandwich
     * @param bread the bread used in the sandwich
     * @param filling the filling used in the sandwich
     */
    public Sandwich(String name, Bread bread, SandwichFilling filling) {
        this.name = name;
        this.bread = bread;
        this.filling = filling;
    }

    /**
     * Returns the name of the sandwich
     * @return the name of the sandwich
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the filling used in the sandwich
     * @return the filling used in the sandwich
     */
    private SandwichFilling getFilling() {
        return filling;
    }

    /**
     * Returns the bread used in the sandwich
     * @return the bread used in the sandwich
     */
    private Bread getBread() {
        return bread;
    }

    /**
     * Returns the number of calories of the sandwich
     * @return the number of calories of the sandwich
     */
    public int getCalories() {
        return bread.getCalories() * 2 + filling.getCalories();
    }

    /**
     * Returns a String in the following format:
     * Total Calories (X): fillingType on breadType
     * @return a string representation of the sandwich
     */
    public String toString() {
        return "Total Calories (" + getCalories() + "): "
                + filling.getType() + " (" + filling.getCalories()
                + " calories per serving) on " + bread.getType() + " (" + bread.getCalories()
                + " calories per slice)";
    }

    /**
     * Returns true if both Sandwich objects have the same SandwichFilling and Bread
     * @param another another sandwich
     * @return true if both Sandwich objects have the same SandwichFilling and Bread
     */
    public boolean equals(Object another) {
        if (another instanceof Sandwich) {
            Sandwich copy = (Sandwich) another;
            return bread.equals(copy.getBread()) && filling.equals(copy.getFilling());
        }
        else {
            return false;
        }
    }
}
