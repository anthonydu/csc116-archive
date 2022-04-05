/**
 * SandwichFilling class regarding the Sandwich Filling's type and number of calories per serving
 *
 * @author Om Pandey, Anthony Du
 */
public class SandwichFilling {

    /** The type of the sandwich filling */
    private String type;

    /** The number of calories per serving */
    private int calories;

    /**
     * Constructs a new SandwichFilling to represent its type and number of calories per serving
     *
     * @param type the type of the sandwich filling
     * @param calories the number of calories per serving
     */
    public SandwichFilling(String type, int calories) {
        this.type = type;
        this.calories = calories;
    }

    /**
     * Returns the type of the sandwich filling
     * @return the type of the sandwich filling
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the number of calories per serving of sandwich filling
     * @return the number of calories per serving of sandwich filling
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Returns a string representation of the type and number of calories
     * Ex: type (X calories per serving)
     * @return a string representation of the type and number of calories
     */
    public String toString() {
        return "" + type + " (" + calories + " calories per serving)";
    }

    /**
     * Returns true if this and another Sandwich Filling are same in type and number of carlories
     * @param another another sandwich filling added in
     * @return true if this and another sandwich filling are same in type and number of carlories
     */
    public boolean equals(Object another) {
        if (another instanceof SandwichFilling) {
            SandwichFilling secondary = (SandwichFilling) another;
            return type.equals(secondary.getType()) && calories == secondary.getCalories();
        }
        else {
            return false;
        }
    }
}
