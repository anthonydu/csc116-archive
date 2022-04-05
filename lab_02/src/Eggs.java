import java.util.Scanner;

class Eggs {
    public static void main(String[] args) {
        int numEggs, numDozens, numIndividuals;
        double dozenPrice = 3.25;
        double individualPrice = 0.45;
        double totalPrice;
        Scanner orderScanner = new Scanner(System.in);

        System.out.print("Enter number of eggs in order: ");
        numEggs = orderScanner.nextInt();
        numDozens = numEggs / 12;
        numIndividuals = numEggs % 12;
        totalPrice = numDozens * dozenPrice + numIndividuals * individualPrice;
        System.out.printf("You ordered %d eggs. That is %d dozen at $3.25 per dozen and %d loose eggs at 45 cents each for a total of $%.2f.%n", numEggs, numDozens, numIndividuals, totalPrice);
    }
}
