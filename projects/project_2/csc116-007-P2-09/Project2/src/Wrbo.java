import java.util.Scanner;
import java.util.Arrays;

/**
 * Several NC State alumni have beach homes that they would like to rent this summer
 * and they would like you to create a Wolfpack Rentals by Owner (Wrbo) application.
 *
 * The homes will be rented by the week from Saturday to Saturday.
 * The rental costs will vary by the month with higher pricing for holiday weeks.
 * The system will allow a user to select a house and find out the cost for a particular week
 * as well as the start/end date of the rental term.
 * The first rental week for this summer will begin on the first Saturday of May
 * and the last week will begin on the last Saturday of August.
 * Pricing for a house is based on the month the rental begins
 * except for holiday weeks, which have their own pricing category.
 *
 * @author Anthony Du
 */
public class Wrbo {

    /**
     * Initiate constant: an array of all valid start dates
     */
    public static final int[][] VALID_START_DATES = new int[][]{
        {5, 7}, {5, 14}, {5, 21}, {5, 28},
        {6, 4}, {6, 11}, {6, 18}, {6, 25},
        {7, 2}, {7, 9}, {7, 16}, {7, 23}, {7, 30},
        {8, 6}, {8, 13}, {8, 20}, {8, 27}
    };

    /**
     * Initiate constant: an array of the cost of all rent types and dates
     */
    public static final Object[][] PRESET_RENT_COST = new Object[][]{
        {"B56", 1000}, {"B78", 1200}, {"BMD", 1500}, {"BID", 1600},
        {"C56", 1150}, {"C78", 1310}, {"CMD", 1550}, {"CID", 1700},
        {"S56", 1245}, {"S78", 1425}, {"SMD", 1575}, {"SID", 1725},
    };

    /**
     * Initiate constant: the day of May that Memorial Day is on
     */
    public static final int MEMORIAL_DAY = 28;

    /**
     * Get integer from a 3D array by searching for a String key at index 0 of every nested array
     *
     * @param arrayDict a 3D object array with nested arrays
     *        that stores a string at index 0 and an integer at index 1
     * @param key a string used for finding the integer value stored in the same nested array
     * @return the integer value stored in the same nested array that matches the key
     */
    public static int getIntFromKey(Object[][] arrayDict, String key) {
        for (int i = 0; i < arrayDict.length; i++) {
            if (arrayDict[i][0].equals(key)) {
                return (int)arrayDict[i][1];
            } else {
                continue;
            }
        }
        return -1;
    }

    /**
     * Runs when an instance of Vrbo is created.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        System.out.println("");
        System.out.println("            Welcome to Wolfpack Rentals by Owner!");
        System.out.println("Please enter the house about which you would like to enquire");
        System.out.println("-- B (Beach Bliss), C (Coastal Haven), or S (Sunny Days) --");
        System.out.println("and the date in 2022 that you would like to begin your rental.");
        System.out.println("Houses rent from Saturday to Saturday so this date must be a");
        System.out.println("Saturday. The rental cost and term will then be displayed.");
        System.out.println("");

        System.out.print("House (B-each Bliss, C-oastal Haven, S-unny Days): ");
        String houseInput = scnr.next();
        char house = (houseInput.length() == 1) ? houseInput.toUpperCase().charAt(0) : ' ';
        switch (house) {
            case 'B': case 'C': case 'S': break;
            default:
                System.out.println("Invalid house");
                System.exit(1);
        }

        System.out.print("Start date (month day, eg. 5 21): ");
        int month = scnr.nextInt();
        int date = scnr.nextInt();
        if (!isValidStartDate(month, date)) {
            System.out.println("Invalid date");
            System.exit(1);
        }

        System.out.println("Cost: $" + getRentalCost(house, month, date) + ".00");
        System.out.println("Term: " + getRentalTerm(month, date));
    }

    /**
     * Checks if start date is valid.
     *
     * @param month month of start of lease term
     * @param day date of start of lease term
     * @return true if start date is valid, false if start date is invalid
     */
    public static boolean isValidStartDate(int month, int day) {
        for (int i = 0; i < VALID_START_DATES.length; i++) {
            if (Arrays.equals(new int[]{month, day}, VALID_START_DATES[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * Throws IllegalArgumentException if start date is invalid.
     *
     * @param month month of start of lease term
     * @param day date of start of lease term
     * @throws IllegalArgumentException "Invalid date"
     */
    public static void checkValidDate(int month, int day) {
        if (!isValidStartDate(month, day)) {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    /**
     * Throws IllegalArgumentException if house is invalid.
     *
     * @param house the type of house the user would like to rent
     * @throws IllegalArgumentException "Invalid house"
     */
    public static void checkValidHouse(char house) {
        switch (house) {
            case 'B': case 'C': case 'S': break;
            default:
                throw new IllegalArgumentException("Invalid house");
        }
    }

    /**
     * Gets preset rental cost depending on which house and start date is chosen.
     *
     * @param house the type of house the user would like to rent
     * @param month month of start of lease term
     * @param day date of start of lease term
     * @return the rent cost of that week, -1 if no cost is listed
     */
    public static int getRentalCost(char house, int month, int day) {
        house = Character.toUpperCase(house);
        checkValidHouse(house);
        checkValidDate(month, day);

        switch (Arrays.toString(new Object[]{house, month})) {
            case "[B, 5]": case "[B, 6]":
                return (day != MEMORIAL_DAY) ? getIntFromKey(PRESET_RENT_COST, "B56")
                                             : getIntFromKey(PRESET_RENT_COST, "BMD");
            case "[B, 7]": case "[B, 8]":
                return (day != 2) ? getIntFromKey(PRESET_RENT_COST, "B78")
                                  : getIntFromKey(PRESET_RENT_COST, "BID");
            case "[C, 5]": case "[C, 6]":
                return (day != MEMORIAL_DAY) ? getIntFromKey(PRESET_RENT_COST, "C56")
                                             : getIntFromKey(PRESET_RENT_COST, "CMD");
            case "[C, 7]": case "[C, 8]":
                return (day != 2) ? getIntFromKey(PRESET_RENT_COST, "C78")
                                  : getIntFromKey(PRESET_RENT_COST, "CID");
            case "[S, 5]": case "[S, 6]":
                return (day != MEMORIAL_DAY) ? getIntFromKey(PRESET_RENT_COST, "S56")
                                             : getIntFromKey(PRESET_RENT_COST, "SMD");
            case "[S, 7]": case "[S, 8]":
                return (day != 2) ? getIntFromKey(PRESET_RENT_COST, "S78")
                                  : getIntFromKey(PRESET_RENT_COST, "SID");
            default: return -1;
        }
    }

    /**
     * Gets the start year, month, and date and the end year, month, and date of the rent term.
     *
     * @param startMonth month of start of lease term
     * @param startDay date of start of lease term
     * @return a string containing the start and end date of the rent term, connected by a dash,
     *         an empty string if matching end date is not found
     */
    public static String getRentalTerm(int startMonth, int startDay) {
        checkValidDate(startMonth, startDay);
        int[] lastValidStartDate = VALID_START_DATES[VALID_START_DATES.length - 1];
        if (startMonth == lastValidStartDate[0] && startDay == lastValidStartDate[1]) {
            return "8/27/2022-9/3/2022";
        }
        for (int i = 0; i < VALID_START_DATES.length; i++) {
            if (Arrays.equals(new int[]{startMonth, startDay}, VALID_START_DATES[i])) {
                return VALID_START_DATES[i][0] + "/"
                     + VALID_START_DATES[i][1] + "/2022-"
                     + VALID_START_DATES[i + 1][0] + "/"
                     + VALID_START_DATES[i + 1][1] + "/2022";
            } else {
                continue;
            }
        }
        return "";
    }
}
