import java.util.Scanner;

/**
 * Calculates the horizontal distance traveled by a football or other projectile.
 *
 * @author Anthony Du
 */
public class DistanceCalculator {

    /**
     * Gravitational Acceleration constant
     */
    public static final double GRAVITY = 32.174;  // ft/s^2

    /**
     * Number of feet in a mile constant
     */
    public static final double FT_IN_MI = 5280;

    /**
     * Number of seconds in an hour constant
     */
    public static final double S_IN_HR = 3600;

    /**
     * Maximum angle allowed constant
     */
    public static final double MAX_ANGLE = 90; // degrees

    /**
     * Starts the program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Distance calculation type (H-Horizontal, V-Vertical): ");
        String distanceType = scnr.next().toUpperCase();

        double height;
        switch (distanceType) {
            case "H":
                double velocity = getDouble(scnr, "Initial velocity (mi/hr): ", "velocity");
                height = getDouble(scnr, "Initial height (ft): ", "height");
                double angle = getDouble(scnr, "Angle (degrees): ", "angle");
                System.out.printf("Distance: %.2f ft%n",
                                  calculateHorizontalDistance(angle, velocity, height));
                break;
            case "V":
                height = getDouble(scnr, "Initial height (ft): ", "height");
                double rebound = getDouble(scnr, "Rebound fraction: ", "fraction");
                System.out.printf("Distance: %.2f ft%n",
                                  calculateVerticalDistance(height, rebound));
                break;
            default:
                System.out.println("Invalid type");
                System.exit(1);
        }
    }

    /**
     * Gets a double from Scanner and see if it is valid based on the type of data requested
     *
     * @param scnr Scanner object for reading user input in terminal
     * @param message the message to show before asking for an input
     * @param dataType the type of data to expect
     * ("velocity", "height", "angle", "fraction" are the only types acceptable by this method)
     * @return a valid double retreved from scnr
     */
    public static double getDouble(Scanner scnr, String message, String dataType) {
        System.out.print(message);

        if (!scnr.hasNextDouble()) {
            // oops, looks like we don't need to impliment this
            // but I did it anyway cause I didn't read the instruction carefully lmao.
            System.out.println("Invalid " + dataType);
            System.exit(1);
        } else {
            double data = scnr.nextDouble();
            switch (dataType) {
                case "velocity":
                case "height":
                    if (data < 0) {
                        System.out.println("Invalid " + dataType);
                        System.exit(1);
                    } else {
                        return data;
                    }
                case "angle":
                    if (data < 0 || data > MAX_ANGLE) {
                        System.out.println("Invalid " + dataType);
                        System.exit(1);
                    } else {
                        return data;
                    }
                case "fraction":
                    if (data <= 0 || data >= 1) {
                        System.out.println("Invalid " + dataType);
                        System.exit(1);
                    } else {
                        return data;
                    }
                default:
                    System.out.println("Internal error: unknown dataType");
                    System.exit(1);
            }
        }
        throw new RuntimeException("getDouble failed to return or exit");
    }

    /**
     * Calculates horizontal distance using the horizontal distance formula
     *
     * @param angle initial angle of the projectile's velocity from horizontal in degrees
     * @param velocity the magnitude of the initial velocity of the projectile
     * @param height initial height of the projectile from ground
     * @return horizontal distance in ft
     */
    public static double calculateHorizontalDistance(double angle, double velocity, double height) {
        angle = Math.toRadians(angle); // convert degrees to radians
        velocity *= FT_IN_MI / S_IN_HR; // convert from mi/hr to ft/s
        double vSin = velocity * Math.sin(angle);
        double vCos = velocity * Math.cos(angle);
        double vSinSquared = Math.pow(vSin, 2);
        double twoGravityHeight = 2 * GRAVITY * height;
        return (vCos / GRAVITY) * (vSin + Math.sqrt(vSinSquared + twoGravityHeight));
    }

    /**
     * Calculates horizontal distance of a projectile using the vertical distance formula
     *
     * @param height initial height of the projectile from ground
     * @param rebound fraction of current height the ball rebounds
     * @return vertical distance in ft
     */
    public static double calculateVerticalDistance(double height, double rebound) {
        return height * ((1 + rebound) / (1 - rebound));
    }
}
