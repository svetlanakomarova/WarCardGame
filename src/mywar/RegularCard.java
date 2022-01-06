package mywar;

/**
 * This class represents a playing card - child of class Card
 * @author Svetlana Komarova
 *
 */
public class RegularCard extends Card {
    
 // private fields
    private Suit suit;
    private Rank rank;
    public boolean isFaceUp = false;
    
    //constructor
    public RegularCard() {

    }
    
    //constructor with two parameters
    public RegularCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public String printSuit() {
        return suit.printSuit();
    }
    
    public int getRank() {
        return rank.getRank();
    }
    
    public String printRank() {
        // get rank as a string (primarily for Aces)
        return rank.printRank();
    }
    
    public void flipCard() {
        isFaceUp = !isFaceUp; // reserve the value
    }
    //new
    public boolean isFaceUp(){
        return this.isFaceUp;
    }
    
    /* 
     * Returns a negative number if this object is lower in rank than c,
     * 0 if the cards are equal rank, and a positive number if this object
     * is higher in rank than c. Aces are considered 'high'.
     */

    public boolean beats(RegularCard other ){
        return (this.getRank() - other.getRank() > 0);
    }
    /*
     * Returns true if the objects are equals, otherwise - false 
     */
    public boolean ties(RegularCard other) {
        return this.rank.getRank() == other.getRank() && this.suit.printSuit().equals(other.printSuit());
    }
    
    @Override
    public String toString() {
        String str = "";
        // print rank and suit if face up
        if (isFaceUp) {
            str += rank.printRank() + " of " + suit.printSuit();
        } else {
            str = "Face Down (nothing to see here)";
        }
        return str;
    }

}
