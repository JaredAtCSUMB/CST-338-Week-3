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
      System.out.println("Hello, Team 6!");
   }

}

/*
 * A class that represents a playing card
 * Values: A, 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K
 * Suits: clubs, diamonds, hearts, spades
 */
class Card
{
   public enum Suit {clubs, diamonds, hearts, spades};
   private char value;
   private boolean errorFlag;
   private Suit suit;
   
   public Card()
   {
      this('A', Suit.spades);
   }
   
   // TODO
   public Card(char value, Suit suit)
   {

   }
   
   // TODO
   public String toString()
   {
      return "";
   }
   
   // TODO
   public boolean set(char value, Suit suit)
   {
      return true;
   }
   
   // TODO
   public boolean equals(Card card)
   {
      return true;
   }
   
   // TODO
   private boolean isValid(char value, Suit suit)
   {
      return true;
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