import java.util.Arrays;

/**
 * Represents a hand of cards
 * @author Dan Longo
 * @author Suzanne Balik
 * @author Anthony Du
 */
public class Hand {

    /** The number of cards in a hand */
    public static final int CARDS_IN_HAND = 5;

    /** Contains cards in hand */
    private Card[] hand;

    /** Used in hasFourOfAKind to avoid checkstyle error */
    public static final int FOUR = 4;

    /**
     * Constrcts a Card object
     * @param hand the initial hand of cards dealt
     * @throws IllegalArgumentException for null array, invalid array length, and null element
     */
    public Hand(Card[] hand) {
        if (hand == null) {
            throw new IllegalArgumentException("Null array");
        }
        if (hand.length != CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid array length");
        }
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                throw new IllegalArgumentException("Null element");
            }
        }
        this.hand = hand;
    }

    /**
     * Returns the card in the hand with a specified index
     * @param index the index to get card from
     * @return the card in the hand with a specified index
     * @throws IllegalArgumentException for invalid index
     */
    public Card getCard(int index) {
        if (index < 0 || index >= CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid index");
        }
        return hand[index];
    }

    /**
     * Replaces a card in the hand with a new card
     * @param index the index of the card to replace
     * @param card the new card to be added to the hand
     * @throws IllegalArgumentException for invalid index and null card
     */
    public void replace(int index, Card card) {
        if (index < 0 || index >= CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid index");
        }
        if (card == null) {
            throw new IllegalArgumentException("Null card");
        }
        hand[index] = card;
    }

    /**
     * Returns a String representation of the Hand
     * @return a String representation of the Hand
     */
    public String toString() {
        String handString = "[";
        for (int i = 0; i < hand.length - 1; i++) {
            handString += hand[i].toString() + ", ";
        }
        handString += hand[hand.length - 1].toString() + "]";
        return handString;
    }

    /**
     * Returns whether the two Hands are exactly the same
     * @param o the other Hand
     * @return whether the two Hands are exactly the same
     */
    public boolean equals(Object o) {
        if (o instanceof Hand) {
            Hand oHand = (Hand) o;
            for (int i = 0; i < hand.length; i++) {
                if (!this.getSortedHand()[i].equals(oHand.getSortedHand()[i])) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * Counts the number of cards with each value in the hand
     * @return tally array containing number of cards of each value from 2 to 14.
     */
    public int[] getCounts() {
        int[] counts = new int[Card.HIGHEST_VALUE + 1];
        for (int i = 0; i < hand.length; i++) {
            counts[hand[i].getValue()]++;
        }
        return counts;
    }

    /**
     * Creates a copy of the hand sorted first by value, then by suit
     * @return copy of the hand sorted first by value, then by suit
     */
    public Card[] getSortedHand() {
        Card[] sortedHand = Arrays.copyOf(hand, hand.length);
        Arrays.sort(sortedHand);
        return sortedHand;
    }

    // Poker Hand Methods - from the lowest to the highest rank

    /**
     * Returns whether the Hand has exactly one pair
     * @return whether the Hand has exactly one pair
     */
    public boolean hasOnePair() {
        if (getNumberOfFrequenciesOf(2) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns whether the Hand has exactly two pairs
     * @return whether the Hand has exactly two pairs
     */
    public boolean hasTwoPairs() {
        if (getNumberOfFrequenciesOf(2) == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns whether the Hand has three of a kind
     * @return whether the Hand has three of a kind
     */
    public boolean hasThreeOfAKind() {
        if (getNumberOfFrequenciesOf(3) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns whether the Hand forms a straight
     * @return whether the Hand forms a straight
     */
    public boolean isStraight() {
        for (int i = 0; i < hand.length - 1; i++) {
            if (getSortedHand()[i].getValue() != getSortedHand()[i + 1].getValue() - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns whether the Hand forms a flush
     * @return whether the Hand forms a flush
     */
    public boolean isFlush() {
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i].getSuit() != hand[i + 1].getSuit()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns whether the Hand forms a full house
     * @return whether the Hand forms a full house
     */
    public boolean isFullHouse() {
        if (getNumberOfFrequenciesOf(2) == 1 && getNumberOfFrequenciesOf(3) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns whether the Hand has four of a kind
     * @return whether the Hand has four of a kind
     */
    public boolean hasFourOfAKind() {
        if (getNumberOfFrequenciesOf(FOUR) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns whether the Hand forms a straight flush
     * @return whether the Hand forms a straight flush
     */
    public boolean isStraightFlush() {
        if (isFlush() && isStraight()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns whether the Hand forms a royal flush
     * @return whether the Hand forms a royal flush
     */
    public boolean isRoyalFlush() {
        if (isStraightFlush() && getSortedHand()[0].getValue() == 10) {
            return true;
        } else {
            return false;
        }
    }

    // Helper Methods Added By Student (Anthony Du)

    /**
     * Returns a 2D array of the values and their frequencies in the hand
     * @return a 2D array of the values and their frequencies in the hand
     */
    private int[][] getValueFrequencies() {
        int[][] frequencies = new int[0][2];

        handLoop: // run through each card in the hand
        for (int i = 0; i < hand.length; i++) {
            // run through each item in frequencies
            for (int j = 0; j < frequencies.length; j++) {
                // if value already exist in one of the items
                if (hand[i].getValue() == frequencies[j][0]) {
                    // add increment the frequency of the item by 1
                    frequencies[j][1] += 1;
                    // contunue to the next card
                    continue handLoop;
                }
            }
            // if the value of the current card is not found in the frequencies array
            // increment the length of the array by 1
            frequencies = Arrays.copyOf(frequencies, frequencies.length + 1);
            // add a new item in the array
            frequencies[frequencies.length - 1] = new int[2];
            // set the value of the item to the value of the card
            frequencies[frequencies.length - 1][0] = hand[i].getValue();
            // set the frequency of the item to 1
            frequencies[frequencies.length - 1][1] = 1;
        }

        return frequencies;
    }

    /**
     * Uses the getValueFrequencies function to get a 2D array of values and frequencies,
     * accepts a specific frequency,
     * and returns the number of times that frequency occurs in the array/hand.
     * @param frequency the frequency to be checked
     * @return the number of times that frequency occurs in the hand
     * @throws IllegalArgumentException for a non-positive frequency
     */
    private int getNumberOfFrequenciesOf(int frequency) {
        if (frequency <= 0) {
            throw new IllegalArgumentException("Invalid frequency");
        }
        int count = 0;
        // get an array of items with their frequencies
        int[][] frequencies = getValueFrequencies();
        // run through each item in the array
        for (int i = 0; i < frequencies.length; i++) {
            // match the number of the desired frequency in the array
            if (frequencies[i][1] == frequency) {
                // increment the count by 1
                count += 1;
            }
        }
        return count;
    }
}
