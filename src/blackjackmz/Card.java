package blackjackmz;

import java.util.*;

/**
 *
 * @author Lit
 */
public class Card {
    int value;
    String suit;
    boolean isAce = false, isFace = false;
    
    public Card() {
        value = 1;
        suit = "Hearts";
        isAce = true;
    }
    
    public Card(int val, String s) {
        suit = s;
        if(val == 1) {
            value = val;
            isAce = true;
        }
        
        if(val > 1 && val <= 13)
            value = val;
        else value = 1;
    }
    
    public int getValue() {
        return value;
    }
    
    public void printCard() {
        if(value == 1)
            System.out.print("Ace of " + suit);
        else if(value == 11)
            System.out.print("Jack of " + suit);
        else if(value == 12)
            System.out.print("Queen of " + suit);
        else if(value == 13)
            System.out.print("King of " + suit);
        else System.out.print(value + " of " + suit); 
        //System.out.println();
    }
}
