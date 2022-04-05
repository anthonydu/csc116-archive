import java.util.Scanner;

public class WordCombiner {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String firstWord = scnr.next();
        String secondWord = scnr.next();
        String finalWord, tempWord;

        if (firstWord.compareTo(secondWord) > 0) {
            tempWord = firstWord;
            firstWord = secondWord;
            secondWord = tempWord;
        }

        if (firstWord.length() % 2 == 0) {
            if (secondWord.length() % 2 == 0) {
                finalWord = firstWord.substring(0, firstWord.length() / 2) + secondWord.substring(secondWord.length() / 2);
            } else {
                finalWord = firstWord.substring(0, firstWord.length() / 2) + secondWord.substring((secondWord.length() - 1) / 2);
            }
        } else {
            if (secondWord.length() % 2 == 0) {
                finalWord = firstWord.substring(0, (firstWord.length() - 1) / 2) + secondWord.substring(secondWord.length() / 2);
            } else {
                finalWord = firstWord.substring(0, (firstWord.length() - 1) / 2) + secondWord.substring((secondWord.length() - 1) / 2);
            }
        }
        System.out.println(finalWord);
    }
}
