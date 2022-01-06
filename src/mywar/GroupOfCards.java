package mywar;


import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. 
 * HINT, you might want to subclass this more than once. 
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 * @modified by Svetlana Komarova 
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<RegularCard> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int givenSize) {
        size = givenSize;
        cards = new ArrayList();
    }

    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<RegularCard> showCards()
    {
        return cards;
    }
    
    public void addCard(RegularCard c) {
        cards.add(c);

    }

    public RegularCard removeCard(int i) {
        return cards.remove(i);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }

    public RegularCard getCard(int i) {

        return cards.get(i);

    }


}//end class

