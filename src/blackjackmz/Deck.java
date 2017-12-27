package blackjackmz;

import java.util.*;

/**
 *
 * @author Lit
 */
public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();
    String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    
    public Deck() {
        for(String s : suits) {
            for(int i = 1; i <= 13; i++) {
                cards.add(new Card(i, s));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public Card takeCard() {
        return cards.remove(0);
    }
    
    public void addCard(Card c) {
        cards.add(0, c);
    }
    
    public void printDeck() {
        for(Card c : cards) {
            c.printCard();
        }
    }
    
    public boolean deckEmpty() {
        if (cards.isEmpty())
            return true;
        else return false;
    }
}
