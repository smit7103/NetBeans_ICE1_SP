package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * @modifier Smit Patel, 991722748
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();
        
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[rand.nextInt(4)]); // Random suit from 0 to 3
            magicHand[i] = c;
        }
        
        // Ask the user for Card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card value (1 to 13): ");
        int userValue = scanner.nextInt();
        System.out.println("Pick a suit (0 for Hearts, 1 for Diamonds, 2 for Spades, 3 for Clubs): ");
        int userSuitIndex = scanner.nextInt();
        String userSuit = Card.SUITS[userSuitIndex];
        
        // Create the user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        
        // Search the magicHand array for the user's card
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                found = true;
                break;
            }
        }
        
        // Report the result
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
        
        // Add one lucky card hard-coded as 7 of Hearts
        Card luckyCard = new Card();
        luckyCard.setValue(7);
        luckyCard.setSuit("Hearts");

        // Search the magicHand array for the lucky card
        found = false; // Reset the found variable
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equals(luckyCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Report the result for the lucky card
        if (found) {
            System.out.println("The lucky card (7 of Hearts) is in the magic hand!");
        } else {
            System.out.println("The lucky card (7 of Hearts) is not in the magic hand.");
        }
    }
}
