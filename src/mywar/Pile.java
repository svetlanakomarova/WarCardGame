package mywar;

import java.util.LinkedList;

/**
 * This class represents a pile of playing cards
 *
 * @author Svetlana Komarova - March, 2021
 *
 */
public class Pile {

    private LinkedList<RegularCard> pile;

    // construct
    public Pile() {

        pile = new LinkedList();
    }

    public int getSize() {
        return pile.size();
    }

    public void addCard(RegularCard c) {
        pile.add(c);
    }

    public RegularCard popCard() {

        return pile.pop();
    }

    public RegularCard getCard(int i) {
        return pile.get(i);
    }

    public RegularCard getLastCard() {
        return pile.getLast();
    }

    public RegularCard removeLastCard() {
        return pile.removeLast();
    }

}
