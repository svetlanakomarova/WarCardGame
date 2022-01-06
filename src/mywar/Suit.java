package mywar;

/**
 * This class represents a group of constants - Suit
 *
 * @author Svetlana Komarova
 *
 */
public enum Suit {
    //enum constant with values
    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    private final String suitText;

    // constructor
    Suit(String suitText) {
        this.suitText = suitText;
    }

    //returns Suit in string
    public String printSuit() {
        return suitText;
    }
}
