package blackjackmz;

import java.util.*;

/**
 *
 * @author Lit
 */
public class BlackJackMZ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);
        intro();
        String enter = keyb.nextLine();
        System.out.print("\n\n[GAME START]\n");
        
        boolean gameRunning = true;
        boolean playing = true;
        boolean winner = false;
        
        while(gameRunning) {
            Deck deck = new Deck();
            
            deck.shuffle();
            Hand player = new Hand(deck, false);
            Hand dealer = new Hand(deck, true);
            
            while(playing) {
                System.out.println("The dealer deals you two cards.\n");
                player.printHand();
                if(player.hasBlackJack()) {
                    System.out.println("You have BlackJack! You win!");
                    winner = true;
                    playing = false;
                    break;
                }
                System.out.println("\nWould you like to hit, or stand? (h/s)");
                String input = keyb.nextLine();
                while(input.equalsIgnoreCase("h") && player.getHandSum() <= 21) {
                    System.out.println("\n~You hit~\n");
                    player.hit(deck);
                    player.printHand();
                    if(player.getHandSum() > 21) {
                        System.out.println("You busted! You lose.");
                        winner = false;
                        playing = false;
                        break;
                    }
                    System.out.println("\n"
                            + "Would you like to hit, or stand? (h/s)");
                    input = keyb.nextLine();
                }
                if(!player.busted()) {
                    System.out.println("\nNow it's the dealer's turn.\n");
                    dealer.printHand();
                    if(dealer.hasBlackJack()) {
                        System.out.println("The dealer has BlackJack! You lose.");
                        winner = false;
                        playing = false;
                        break;
                    }
                    while(dealer.getHandSum() < 17) {
                        System.out.println("\n~The dealer hits~\n");
                        dealer.hit(deck);
                        dealer.printHand();
                        if(dealer.getHandSum() > 21) {
                            System.out.println("The dealer busted! You win!");
                            winner = true;
                            playing = false;
                            break;
                        }
                    }
                }
                playing = false;
            }
            
            if(player.getHandSum() > dealer.getHandSum()) {
                winner = true;
                printWinner(winner);
            }
            else if(player.getHandSum() == dealer.getHandSum())
                System.out.println("\nYou won this game, would you like to play another? (y/n)");
            else {
                winner = false;
                printWinner(winner); 
            }
            String replay = keyb.nextLine();
            if (replay.equalsIgnoreCase("n")) {
                System.out.println("Thanks for playing, see you next time!");
                gameRunning = false;
            }
            else playing = true;
        }
        
    }
    
    public static void intro() {
        System.out.print("+---------------------------------------------+\n" +
                         "|            MATT'S BLACKJACK GAME            |\n" +
                         "+---------------------------------------------+\n");
        System.out.print("Welcome to my shitty BlackJack game!  Made by \n");
        System.out.print("your's truly (Matt Zizzi) as a side project. Why\n");
        System.out.print("download a nice app from the blackjack store, when\n");
        System.out.print("you can play a ghetto one through the PC console?\n");
        System.out.print("Hope you enjoy! :p\n");
        System.out.print("Press Enter to continue...");
    }
    
    public static void printWinner(boolean b) {
        if(b)
            System.out.println("You won this game, would you like to play another? (y/n)");
        else System.out.println("You lost this game, would you like to play another? (y/n)");
    }
    
}
