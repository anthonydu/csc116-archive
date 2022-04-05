import java.util.Scanner;

/**
 * This is a program that asks for a user input of Type of race along with their total time.
 * Given these inputs, the program should create a pace for how fast they should run each mile.
 *
 * @author Anthony Du
 * @author Dominic Pupo
 */
public class PaceCalculator {

    /**
     * This is a program that asks for a user input of Type of race along with their total time.
     * Given these inputs, the program should create a pace for how fast they should run each mile.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        String raceType, raceTime;
        int raceHour, raceMinute, raceSecond, paceHour, paceMinute, paceSecond;
        final double M_DISTANCE = 26.2;
        final double H_DISTANCE = 13.1;
        final double T_DISTANCE = 6.2;
        final double F_DISTANCE = 3.1;
        final double I_DISTANCE = 1.0;
        final int SIXTY = 60; // number of minutes in hour and number of seconds in minute

        System.out.println("Race Distance Menu:");
        System.out.println("- M: Marathon");
        System.out.println("- H: Half-Marathon");
        System.out.println("- T: 10k");
        System.out.println("- F: 5k");
        System.out.println("- I: Mile");

        Scanner scnr = new Scanner(System.in);

        System.out.print("Race Distance: ");
        raceType = scnr.nextLine();
        raceType = raceType.toUpperCase();

        if (raceType.equals("M") ||
            raceType.equals("H") ||
            raceType.equals("T") ||
            raceType.equals("F") ||
            raceType.equals("I")) {
            System.out.print("Race time (H:MM:SS): ");
            raceTime = scnr.nextLine();

            final int L_COLON_FROM_R = 6;
            final int R_COLON_FROM_R = 3;

            // 1. check if the index of both colons are correct from the right
            // 2. check if there are other colons elsewhere
            //   (String.indexOf() returns -1 when not found)
            // 3. check if the first character is a colon
            if ((raceTime.indexOf(":") == raceTime.length() - L_COLON_FROM_R) &&
                (raceTime.lastIndexOf(":") == raceTime.length() - R_COLON_FROM_R) &&
                (raceTime.substring(0, raceTime.indexOf(":")).indexOf(":") == -1) &&
                (raceTime.substring(raceTime.indexOf(":") + 1,
                                    raceTime.lastIndexOf(":")).indexOf(":") == -1) &&
                (raceTime.substring(raceTime.lastIndexOf(":") + 1).indexOf(":") == -1) &&
                (raceTime.indexOf(":") != 0)) {

                raceHour = Integer.parseInt(raceTime.substring(0, raceTime.indexOf(":")));
                raceMinute = Integer.parseInt(raceTime.substring(raceTime.indexOf(":") + 1,
                                                                 raceTime.lastIndexOf(":")));
                raceSecond = Integer.parseInt(raceTime.substring(raceTime.lastIndexOf(":") + 1));

                if (!(raceMinute >= SIXTY) &&
                    !(raceMinute < 0) &&
                    !(raceSecond < 0) &&
                    !(raceSecond >= SIXTY)) {
                    raceSecond += raceHour * (int)Math.pow(SIXTY, 2) + raceMinute * SIXTY;

                    switch (raceType) {
                        case "M":
                            paceSecond = (int)(raceSecond / M_DISTANCE);
                            break;
                        case "H":
                            paceSecond = (int)(raceSecond / H_DISTANCE);
                            break;
                        case "T":
                            paceSecond = (int)(raceSecond / T_DISTANCE);
                            break;
                        case "F":
                            paceSecond = (int)(raceSecond / F_DISTANCE);
                            break;
                        case "I":
                            paceSecond = (int)(raceSecond / I_DISTANCE);
                            break;
                        default:
                            paceSecond = 0;
                            break;
                    }

                    paceHour = paceSecond / (int)Math.pow(SIXTY, 2);
                    paceMinute = (paceSecond % (int)Math.pow(SIXTY, 2)) / SIXTY;
                    paceSecond -= paceHour * (int)Math.pow(SIXTY, 2) + paceMinute * SIXTY;
                    System.out.printf("%01d:%02d:%02d%n", paceHour, paceMinute, paceSecond);
                } else {
                    System.out.println("Invalid time");
                }

            } else {
                System.out.println("Invalid time");
            }

        } else {
            System.out.println("Invalid distance");
        }
    }
}
