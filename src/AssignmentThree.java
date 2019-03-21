/**
 * This application simulates a card game...
 * 
 * @author Team 6: Jared Cheney, Andrew Meraz, Mina Mansour, Chul Kim and 
 *    Agustin Garcia
 *
 */
public class AssignmentThree
{

   public static void main(String[] args)
   {
      // valid
      Card card1 = new Card();
      System.out.println(card1);
      
      // valid
      Card card2 = new Card('4', Card.Suit.clubs);
      System.out.println(card2);
      
      
      // invalid
      Card card3 = new Card('G', Card.Suit.hearts);
      System.out.println(card3);
      
      // valid made invalid
      card1.set('X', Card.Suit.spades);
      System.out.println(card1);
      
      // invalid made valid
      card3.set('T', Card.Suit.diamonds);
      System.out.println(card3);
      
      // testing equals
      System.out.println(card1.equals(card1));
      System.out.println(card1.equals(card2));
   }

}

/*
 * A class that represents a playing card
 * Values: A, 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K
 * Suits: clubs, diamonds, hearts, spades
 */
class Card
{
   private char value;
   private boolean errorFlag;
   private Suit suit;
   public enum Suit {clubs, diamonds, hearts, spades};

   public Card()
   {
      this('A', Suit.spades);
   }

   public Card(char value, Suit suit)
   {
      set(value, suit);
   }

   public String toString()
   {
      String message;

      if (!errorFlag) {
         message = String.format("%s of %s", value, suit);
      } else {
         message = "ERROR: Invalid card";
      }
      
      return message;
   }

   public boolean set(char value, Suit suit)
   {
      boolean wasSet;

      if (isValid(value, suit)) {
         setValue(value);
         setSuit(suit);
         errorFlag = false;
         wasSet = true;
      } else {
         errorFlag = true;
         wasSet = false;
      }
      
      return wasSet;
   }

   public boolean equals(Card card)
   {
      boolean areEqual;
      
      if(value == card.value && suit == card.suit) {
         areEqual = true;
      } else {
         areEqual = false;
      }
      
      return areEqual;
   }

   private boolean isValid(char value, Suit suit)
   {
      boolean validCard;
      
      switch(value) {
         case 'A':
         case '2':
         case '3':
         case '4':
         case '5':
         case '6':
         case '7':
         case '8':
         case '9':
         case 'T':
         case 'J':
         case 'Q':
         case 'K':
            validCard = true;
            break;
         default:
            validCard =  false;
      }
      
      return validCard;
   }

   public Suit getSuit()
   {
      return suit;
   }

   public void setSuit(Suit suit)
   {
      this.suit = suit;
   }

   public char getValue()
   {
      return value;
   }

   public void setValue(char value)
   {
      this.value = value;
   }

   public boolean isErrorFlag()
   {
      return errorFlag;
   }

   public void setErrorFlag(boolean errorFlag)
   {
      this.errorFlag = errorFlag;
   }
   
   
}

/*
 * A class that represents the cards held by a single player
 */
class Hand
{
   // empty
}

/*
 * A class that represents the source of the cards for dealing and,
 * as the game progresses, the place from which players can receive new cards
 */
class Deck
{
   // empty
}