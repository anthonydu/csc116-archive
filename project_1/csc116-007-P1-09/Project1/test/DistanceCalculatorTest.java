/**
 * Tests DistanceCalculator program
 * @author Suzanne Balik
 */
public class DistanceCalculatorTest {
    /**
     * Tests DistanceCalculator program
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        double distance = DistanceCalculator.calculateHorizontalDistance(20.3, 34.9, 3.5);
        System.out.printf("\nExpected: 61.190108  \nActual:   %.6f\n", distance);
        distance = DistanceCalculator.calculateVerticalDistance(2.74, .45);
        System.out.printf("\nExpected: 7.223636 \nActual:   %.6f\n", distance);
    }
}
