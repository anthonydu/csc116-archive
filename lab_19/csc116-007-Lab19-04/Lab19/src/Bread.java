/**
 * Bread class regarding the Bread's type and number of calories per piece
 *
 * @author Om Pandey, Anthony Du
 */
public class Bread {

    /** The type of the bread */
    private String type;

    /** The number of calories per piece */
    private int calories;

    /**
     * Constructs a new Bread to represent its type and number of calories per piece
     *
     * @param type the type of the bread
     * @param calories the number of calories per piece
     */
    public Bread(String type, int calories) {
        this.type = type;
        this.calories = calories;
    }

    /**
     * Returns the type of the bread
     * @return the type of the bread
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the number of calories per piece of bread
     * @return the number of calories per piece of bread
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Returns a string representation of the type and number of calories
     * Ex: type (X calories per slice)
     * @return a string representation of the type and number of calories
     */
    public String toString() {
        return "" + type + " (" + calories + " calories per slice)";
    }

    /**
     * Returns true if this and another Bread are same in type and number of carlories
     * @param another another bread added in
     * @return true if this and another Bread are same in type and number of carlories
     */
    public boolean equals(Object another) {
        if (another instanceof Bread) {
            Bread secondary = (Bread) another;
            return type.equals(secondary.getType()) && calories == secondary.getCalories();
        }
        else {
            return false;
        }
    }
}
