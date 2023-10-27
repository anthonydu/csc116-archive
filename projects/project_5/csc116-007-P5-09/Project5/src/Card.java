
/**
 * Represents a card
 * @author Anthony Du
 */
public class Card implements Comparable<Card> {

    /** A character that represents the clubs suit */
    public static final char CLUBS = 'c';

    /** A character that represents the diamonds suit */
    public static final char DIAMONDS = 'd';

    /** A character that represents the spades suit */
    public static final char SPADES = 's';

    /** A character that represents the hearts suit */
    public static final char HEARTS = 'h';

    /** The lowest possible value of a card */
    public static final int LOWEST_VALUE = 2;

    /** The lowest possible value of a card */
    public static final int HIGHEST_VALUE = 14;

    /** Represents the number on a card */
    private int value;

    /** Represents the suit on a card */
    private char suit;

    /**
     * Constrcts a Card object
     * @param value value of the card
     * @param suit suit of the card
     * @throws IllegalArgumentException with message "Invalid suit" if suit is invalid
     */
    public Card(int value, char suit) {
        if (value < LOWEST_VALUE || value > HIGHEST_VALUE) {
            throw new IllegalArgumentException("Invalid value");
        }
        switch (suit) {
            case CLUBS: case DIAMONDS: case SPADES: case HEARTS: break;
            default: throw new IllegalArgumentException("Invalid suit");
        }
        this.value = value;
        this.suit = suit;
    }

    /**
     * Returns the value of the Card
     * @return the value of the Card
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the suit of the Card
     * @return the suit of the Card
     */
    public char getSuit() {
        return suit;
    }

    /**
     * Returns whether the two Cards are exactly the same
     * @param o the other Card
     * @return whether the two Cards are exactly the same
     */
    public boolean equals(Object o) {
        if (o instanceof Card) {
            Card oCard = (Card) o;
            return this.value == oCard.value && this.suit == oCard.suit;
        }
        else {
            return false;
        }
    }

    /**
     * Returns a String representation of the Card
     * @return a String representation of the Card
     */
    public String toString() {
        return "" + suit + value;
    }

    /**
     * This method is used for sorting the cards in a player's hand in a game of
     * Poker. Cards are sorted first by value, then by suit.
     *
     * @param other
     *            The Card object to which this Card is being compared.
     * @return negative value if this Card should be before the other Card,
     *         positive value if this Card should be after the other Card.
     */
    public int compareTo(Card other) {
        if (this.value != other.value) {
            return this.value - other.value;
        } else {
            return this.suit - other.suit;
        }
    }
}
