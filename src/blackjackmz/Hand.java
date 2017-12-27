/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackmz;

import java.util.*;

/**
 *
 * @author Lit
 */
public class Hand {
    private int handSum = 0;
    private int numAces = 0;
    private boolean isDealer;
    private boolean hasAce = false;
    private boolean blackJack = false;
    private boolean bust = false;
    private ArrayList<Card> hand = new ArrayList<>();
    
    // Default constructor sets only dealer bool to false;
    public Hand() {
        isDealer = false;
    }
    
    // Overloaded constructor that sets dealer bool, and draws first two cards
    public Hand(Deck d, boolean dealer) {
        isDealer = dealer;
        
        Card c1 = d.takeCard();
        Card c2 = d.takeCard();
        
        hand.add(c1);
        hand.add(c2);
        
        if(c1.getValue() == 1 || c2.getValue() == 1) {
            if(c1.getValue() == 1)
                numAces++;
            if(c2.getValue() == 1)
                numAces++;
            if(c1.getValue() >= 10 || c2.getValue() >= 10)
                blackJack = true;
        }
        
        handSum = this.calcHandSum();
    }
    
    // method that calculates the sum of card values in hand
    public int calcHandSum() {
        int sum = 0;
        for(Card c : hand) {
            if(c.getValue() == 1) {
                sum += 11;
            }
            else if(c.getValue() > 10)
                sum += 10;
            else sum += c.getValue();
            
        }
        if(sum > 21) {
            bust = true;
            if(numAces > 0) {
                sum = sum - 10;
                numAces--;
                bust = false;
            }
        }
        return sum;
    }
    
    public int getHandSum() {
        return handSum;
    }
    
    public boolean hasBlackJack() {
        return blackJack;
    }
    
    public boolean busted() {
        return bust;
    }
    
    // Function to hit/add card to hand
    public void hit(Deck d) {
        Card c = d.takeCard();
        hand.add(c);
        if(c.getValue() == 1)
            numAces++;
        handSum = calcHandSum();
    }
    
    public void trashCards(Deck d) {
        for(Card c : hand)
            d.addCard(c);
        hand.clear();
    }
    
    // Prints out cards in hand
    public void printHand() {
        if(isDealer)
            System.out.println("Dealer's hand: ");
        else System.out.println("Your hand: ");
        for(Card c : hand) {
            System.out.print("[");
            c.printCard();
            System.out.print("]");
        }   
        System.out.println("\nHand value: " + handSum);
    }  
}
