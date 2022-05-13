import java.util.Random;

/**
 * Represents a deck of cards
 * @author Anthony Du
 */
public class Deck {

    /** The number of cards in a deck */
    public static final int CARDS_IN_DECK = 52;

    /** An array of cards that represents the deck */
    private Card[] cards;

    /** The index of the next card to be drawn */
    private int next = 0;

    /** The seed for randomization */
    private int seed;

    /** The number of cards in a suit */
    public static final int CARDS_IN_SUIT = 13;

    /**
     * Conctructor for a Deck object
     * @param seed seed for randomization
     */
    public Deck(int seed) {
        cards = new Card[CARDS_IN_DECK];
        for (int i = 0; i < cards.length; i++) {
            switch (i / CARDS_IN_SUIT) {
                case 0:
                    cards[i] = new Card(i % CARDS_IN_SUIT + 2, 'c');
                    break;
                case 1:
                    cards[i] = new Card(i % CARDS_IN_SUIT + 2, 'd');
                    break;
                case 2:
                    cards[i] = new Card(i % CARDS_IN_SUIT + 2, 'h');
                    break;
                case 3:
                    cards[i] = new Card(i % CARDS_IN_SUIT + 2, 's');
                    break;
                default:
                    break;
            }
        }
        this.seed = seed;
    }

    /** Shuffles the deck using Random(seed) */
    public void shuffle() {
        Random random;
        if (seed == -1) {
            random = new Random();
        } else {
            random = new Random(seed);
        }
        for (int i = cards.length - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            Card randomCard = cards[randomIndex];
            cards[randomIndex] = cards[i];
            cards[i] = randomCard;
        }
    }

    /**
     * Returns the next card in the deck
     * @return the next card in the deck
     */
    public Card nextCard() {
        Card theNextCard = null;
        try {
            theNextCard = cards[next];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalStateException("No more cards");
        }
        next += 1;
        return theNextCard;
    }

    /**
     * Returns whether the two Decks are exactly the same
     * @param o the other Deck
     * @return whether the two Decks are exactly the same
     */
    public boolean equals(Object o) {
        if (o instanceof Deck) {
            Deck oDeck = (Deck) o;
            if (this.toString().equals(oDeck.toString())
                && this.next == oDeck.next && this.seed == oDeck.seed) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Returns a String representation of the Deck
     * @return a String representation of the Deck
     */
    public String toString() {
        String cardsString = "";
        for (int i = 0; i < cards.length; i++) {
            cardsString += "card " + i + ": " + cards[i].toString() + "\n";
        }
        return cardsString;
    }
}
