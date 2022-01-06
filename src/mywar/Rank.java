package mywar;

/**
 * This class represents a group of constants - Rank
 *
 * @author Svetlana Komarova - April 14, 2021
 *
 */
public enum Rank {
    //enum constant can have more than one values
    //order needs maintain according to constructor
    //ACE(key,Value)
    DEUCE(2, "2"), THREE(3, "3"),
    FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"),
    EIGHT(8, "8"), NINE(9, "9"), TEN(10, "10"), JACK(11, "Jack"),
    QUEEN(12, "Queen"), KING(13, "King"),ACE(14, "Ace");

    
    private final int rankKey;
    private final String rankValue;

    //constructor
    Rank(int rankKey, String rankValue) {
        this.rankKey = rankKey;
        this.rankValue = rankValue;
    }

    //returns Rank in value
    public int getRank() {
        return rankKey;
    }
    
    //returns Rank in string
    public String printRank() {
        return rankValue;
    }
}
