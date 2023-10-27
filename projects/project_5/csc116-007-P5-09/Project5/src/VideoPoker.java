
/**
 * Represents a game of Poker
 * @author Anthony Du
 */
public class VideoPoker {

    /** Indicates that a random game should be played */
    public static final int RANDOM_GAME = -1;

    /** The number of cards in a hand */
    public static final int CARDS_IN_HAND = 5;

    /** The number of points that the player has when the game begins */
    public static final int STARTING_POINTS = 100;

    /** The number of points needed to play a new game */
    public static final int POINTS_FOR_NEW_GAME = 10;

    /** The number of points awarded for a Royal Flush */
    public static final int ROYAL_FLUSH = 100;

    /** The number of points awarded for a Straight Flush */
    public static final int STRAIGHT_FLUSH = 60;

    /**  The number of points awarded for Four of a Kind */
    public static final int FOUR_OF_A_KIND = 50;

    /** The number of points awarded for a Full House */
    public static final int FULL_HOUSE = 40;

    /** The number of points awarded for a Flush */
    public static final int FLUSH = 30;

    /** The number of points awarded for a Straight */
    public static final int STRAIGHT = 25;

    /** The number of points awarded for Three of a Kind */
    public static final int THREE_OF_A_KIND = 15;

    /** The number of points awarded for Two Pairs */
    public static final int TWO_PAIRS = 10;

    /** The number of points awarded for One Pair */
    public static final int ONE_PAIR = 7;

    /** The deck of cards that functions as a draw pile */
    private Deck deck;

    /** The hand of cards that the player has */
    private Hand hand;

    /** The number of points that the player has */
    private int points;

    /** Constructs a VideoPoker Object
     * @param seed the seed for randomization
     */
    public VideoPoker(int seed) {
        deck = new Deck(seed);
        points = STARTING_POINTS;
    }

    /**
     * Returns the current number of points
     * @return the current number of points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Accepts the index of a card in the hand, returns the gif filename of the Card
     * @param index the index of a card in the hand
     * @return the gif filename of a Card
     */
    public String getCardFileName(int index) {
        return "cards/" + hand.getCard(index).toString() + ".gif";
    }

    /**
     * Accepts the index of a card in the hand, returns a card in the hand with that index
     * @param index the index of a card in the hand
     * @return a card in the hand with specified index
     */
    public Card getCard(int index) {
        return hand.getCard(index);
    }

    /**
     * Starts a new game
     */
    public void newGame() {
        points -= POINTS_FOR_NEW_GAME;
        deck.shuffle();
        Card[] cards = new Card[CARDS_IN_HAND];
        for (int i = 0; i < CARDS_IN_HAND; i++) {
            cards[i] = deck.nextCard();
        }
        hand = new Hand(cards);
    }

    /**
     * Replaces a card in the hand with the next card in the draw pile
     * @param index the index of a card in the hand to be replaced
     */
    public void replaceCard(int index) {
        hand.replace(index, deck.nextCard());
    }

    /**
     * Returns the name of the hand achieved with the greatest number of points,
     * added the appropriate number of points to the current points
     * @return the name of the hand achieved with the greatest number of points
     */
    public String scoreHand() {
        if (hand.isRoyalFlush()) {
            points += ROYAL_FLUSH;
            return "Royal Flush";
        } else if (hand.isStraightFlush()) {
            points += STRAIGHT_FLUSH;
            return "Straight Flush";
        } else if (hand.hasFourOfAKind()) {
            points += FOUR_OF_A_KIND;
            return "Four of a Kind";
        } else if (hand.isFullHouse()) {
            points += FULL_HOUSE;
            return "Full House";
        } else if (hand.isFlush()) {
            points += FLUSH;
            return "Flush";
        } else if (hand.isStraight()) {
            points += STRAIGHT;
            return "Straight";
        } else if (hand.hasThreeOfAKind()) {
            points += THREE_OF_A_KIND;
            return "Three of a Kind";
        } else if (hand.hasTwoPairs()) {
            points += TWO_PAIRS;
            return "Two Pairs";
        } else if (hand.hasOnePair()) {
            points += ONE_PAIR;
            return "One Pair";
        } else {
            return "No Pair";
        }
    }

}
