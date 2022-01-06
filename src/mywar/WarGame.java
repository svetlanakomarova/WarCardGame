package mywar;

/**
 * This class implements the rules applied to the game of war
 *
 * @author Svetlana Komarova - April 19, 2021
 *
 */
public class WarGame extends Game {

    private final int DECK_SIZE = 52;
 

    public WarGame(String gameName) {
        super(gameName);
    }

    @Override
    public void play() {
        
        
        String name1 = this.getPlayers().get(0).getPlayerID();
        String name2 = this.getPlayers().get(1).getPlayerID();

        GroupOfCards warDeck = new GroupOfCards(DECK_SIZE);
        Pile pileOne = new Pile();
        Pile pileTwo = new Pile();

        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                RegularCard c = new RegularCard(r, s);
                warDeck.addCard(c);
            }
        }

        warDeck.shuffle();

        for (int i = 0; i < warDeck.getSize(); i++) {
            pileOne.addCard(warDeck.getCard(i));
            i++;
            pileTwo.addCard(warDeck.getCard(i));
        }

       // RegularCard c1 = new RegularCard();
        //RegularCard c2 = new RegularCard();

        while (true) { //!(pileOne.noMoreCards() || pileTwo.noMoreCards()

            RegularCard c1 = pileOne.popCard();
            RegularCard c2 = pileTwo.popCard();

            //each player place one card face up
            if (!(c1.isFaceUp)) {
                c1.flipCard();
            }
            if (!(c2.isFaceUp)) {
                c2.flipCard();
            }

            //display the face up card
            System.out.println( name1 +" plays card is " + c1);
            System.out.println( name2 + " plays card is " + c2);

            //rank comparation between two cards
            if (c1.beats(c2)) { //(c1.getRank() > c2.getRank()){//if player 1 win
                pileOne.addCard(c1);
                pileOne.addCard(c2);  //higher rank wins both cards and 

                System.out.println( name1 +" wins the round\n");
            }//end if
            else if (c2.beats(c1)) {//if(c1.getRank() < c2.getRank()){//if player 2 win 
                pileTwo.addCard(c2);
                pileTwo.addCard(c1);

                System.out.println( name2 +" wins the round\n");
            }//end else if
            else { //war happens when both cards' rank matched
                System.out.println("WAR!!!");

                //creating war group of 4 cards 
                Pile war1 = new Pile();
                Pile war2 = new Pile();

                //checking do players have enough (4)cards to stay in game
                for (int x = 0; x < 4; x++) {
                    //either one player runs out of card is game over
                    if (pileOne.getSize() == 0 || pileTwo.getSize() == 0) {
                        break;
                    }//end if

                    war1.addCard(pileOne.popCard());  //place additional card for war
                    war2.addCard(pileTwo.popCard());

                    if (x < 3) {
                        if (war1.getCard(x).isFaceUp) {
                            war1.getCard(x).flipCard();
                        }
                        if (war2.getCard(x).isFaceUp) {
                            war2.getCard(x).flipCard();
                        }

                        System.out.println("War card for " + name1 + " is " + war1.getCard(x).toString()
                                + "\nWar card for " + name2 + " is " + war2.getCard(x).toString());
                    }

                }//end for

                //only compare result when both players have enough cards for war
                if (war1.getSize() == 4 && war2.getSize() == 4) {

                    if (!(war1.getLastCard().isFaceUp)) {
                        war1.getLastCard().flipCard();
                    }
                    if (!(war2.getLastCard().isFaceUp)) {
                        war2.getLastCard().flipCard();
                    }
                    System.out.println("Top 'war' card for " + name1 +" is " + war1.getLastCard().toString());
                    System.out.println("Top 'war' card for " + name2 + " is " + war2.getLastCard().toString());

                    //if player 1 wins the war round
                    if (war1.getLastCard().beats(war2.getLastCard())) {
                        for (int i = 0; i < 4; i++) {
                            pileOne.addCard(war1.removeLastCard()); //player1 get all 10 cards

                            pileOne.addCard(war2.removeLastCard());
                        }
                        pileOne.addCard(c2);
                        System.out.println( name1 + " wins the war round\n");
                        //otherwise player 2 wins the war round
                    } else if (war2.getLastCard().beats(war1.getLastCard())) {
                        for (int i = 0; i < 4; i++) {
                            pileTwo.addCard(war1.removeLastCard()); //player2 get all 10 cards

                            pileTwo.addCard(war2.removeLastCard());
                        }
                        pileOne.addCard(c2);
                        System.out.println( name2 + " wins the 'war' round\n");
                    } else {
                        System.out.println("War again!!!");
                        // repeat war
                    }
                }//end if

            }//end war round else

            //game over either one player runs out of card(deck size is 0)
            if (pileOne.getSize() == 0) {
                
                declareWinner(1, 0);
                break;
            } else if (pileTwo.getSize() == 0) {
                
                declareWinner(0, 1);

                break;
            }
        }//end while 
    }

    @Override
    public void declareWinner(int winner, int lost) {
        
        String w = this.getPlayers().get(winner).getPlayerID();
        String l = this.getPlayers().get(lost).getPlayerID();

        System.out.println("Game over\n" + l  + " is out of cards\n" + w + " wins the game");

    }
}