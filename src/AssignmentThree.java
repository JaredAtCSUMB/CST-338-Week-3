/**
 * This application simulates the dealing of playing cards.
 * It prompts the user to enter how many hands they want and
 * distributes cards to those hands from a deck of 52 cards,
 * both unshuffled and shuffled.
 * 
 * @author Team 6: Jared Cheney, Andrew Meraz, Chul Kim and Agustin Garcia
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
      
      
      //Hand class test
      System.out.println("\nStarting Hand tests......");
      Card card = new Card('9', Card.Suit.clubs);
      Hand hand = new Hand();
      //resetHand() should not throw any error when it's empty
      hand.resetHand();
      hand.takeCard(card);
      System.out.println(card.toString());
      //Lets inspect the card from the hand.
      Card inspectCard = hand.inspectCard(0);
      System.out.println(inspectCard);
      //Test toString()
      System.out.println("Test toString(): " + hand.toString());
      //Change the card
      card.set('2', Card.Suit.diamonds);
      Card cardFromHand = hand.playCard();
      //Changes should NOT have effected what was put in to the hand.
      System.out.println(cardFromHand.toString());
      //We should get an error Card.
      Card exepectedBadCard = hand.inspectCard(5000);
      System.out.println(exepectedBadCard.toString());
      //We should get a null as we have played that card.
      Card goodCard = hand.inspectCard(0);
      System.out.println("Expected null card: " + goodCard);
      System.out.println("End Hand tests......");
      
    //Deck class test
      System.out.println("Starting Deck Test...");
      System.out.println("Unshuffled two decks:");
      Deck twoDeck = new Deck(2);
      int count = 1;
      for(int i = 0; i < 52 * 2; i++)
      {
         System.out.print(twoDeck.dealCard().toString() + " / ");
         if (count == 5)
         {
            System.out.println();
            count = 1;
         }
         else
         {
            count++;
         }
      }
      
      System.out.println("\n\nShuffled two decks:");
      twoDeck.init(2);
      twoDeck.shuffle();
      count = 1;
      for(int i = 0; i < 52 * 2; i++)
      {
         System.out.print(twoDeck.dealCard().toString() + " / ");
         if (count == 5)
         {
            System.out.println();
            count = 1;
         }
         else
         {
            count++;
         }
      }
      System.out.println("\n\nUnshuffled one deck:");
      Deck oneDeck = new Deck();
      count = 1;
      for(int i = 0; i < 52; i++)
      {
         System.out.print(oneDeck.dealCard().toString() + " / ");
         if (count == 5)
         {
            System.out.println();
            count = 1;
         }
         else
         {
            count++;
         }
      }
      
      System.out.println("\n\nShuffled one deck:");
      oneDeck.init(1);
      oneDeck.shuffle();
      count = 1;
      for(int i = 0; i < 52; i++)
      {
         System.out.print(oneDeck.dealCard().toString() + " / ");
         if (count == 5)
         {
            System.out.println();
            count = 1;
         }
         else
         {
            count++;
         }
      }
   }

}

/*
 * A class that represents a playing card
 */
class Card
{
   private char value;
   private boolean errorFlag;
   private Suit suit;
   public enum Suit {clubs, diamonds, hearts, spades};

   // Default card is 'A of spades'
   public Card()
   {
      this('A', Suit.spades);
   }

   public Card(char value, Suit suit)
   {
      set(value, suit);
   }

   /*
    * Sets the value and suit of a Card if value and suit are valid.
    * If valid, set errorFlag to false.
    * If invalid, set errorFlag to true.
    * Returns true/false if the value and suit were set
    */
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

   /*
    * Returns a string representation of a Card object if valid
    * otherwise returns an error message
    */
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

   /*
    * Checks the equality of two Card objects.
    * Returns true if card value and card suit match
    * Returns false otherwise
    */
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

/*
    * Checks the validity of value and suit.
    * Valid values: A, 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K
    * Valid suits: clubs, diamonds, hearts, spades
    * Note: suits are not validated at this time
    */
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

/**
 * A class that represents the cards held by a single player.
 * 
 * Hand object usually contains several cards, so we'll need an array of Card objects (myArray) as the principal member of the Hand class.  
 * Since each game deals a different number of cards into its players hands, and even within a game the number of cards in a hand will increase or decrease,
 * we must keep track of this with an int value (numCards).  
 * 
 * We'll need constructors, mutators, etc., of course.  
 * 
 * We'll also want a way for the hand to receive a card (from the deck or somewhere else), 
 * 
 * and play a card (to the table or to another player).  
 * 
 * These two methods will be called takeCard() and playCard(), respectively. 
 * 
 * Since this class has no information about the game being played, it always puts new cards received by takeCard() into the next available location of the array (index position numCards) 
 * 
 * and plays a card via playCard() from the highest occupied location (index position numCards - 1).  
 * 
 * The client game application would somehow prepare this highest position with the correct card to be played before calling Hand's playCard() method. 
 * 
 *  This detail is not our concern.
 * @author charlesk
 *
 */
class Hand
{
    public static final int MAX_CARDS = 100;
    private Card[] myCards;
    private int numCards;
    
    public Hand() {
       //create a default array of Cards
       this.myCards = new Card[MAX_CARDS];
    }
    
    /**
     * 
     * @return a number of cards
     */
    public int getNumCards() {
       return numCards;
    }

    /**
     * 
     * @param numCards
     */
    public void setNumCards(int numCards) {
       this.numCards = numCards;
    }

    /**
     * remove all cards from the hand (in the simplest way).
     */
    public void resetHand() {
       //nothing to reset as myCards is either null or it's reset already.
       if (this.myCards == null || this.myCards.length == 0) {
          return;
       }
     
       this.myCards = new Card[MAX_CARDS];
    }
    
    /**
     * adds a card to the next available position in the myCards array.
     * This is an object copy, not a reference copy, since the source of the Card might destroy or change 
     * its data after our Hand gets it -- we want our local data to be exactly as it was when we received it.
     * @param card
     * @return true if card was successfully added to the myCards array, otherwise return false.
     */
    public boolean takeCard(Card card) {
       boolean cardWasTaken;
 
       if (this.numCards == this.myCards.length) {
          cardWasTaken = false;
       } else {
          this.myCards[numCards++] = new Card(card.getValue(), card.getSuit());
          cardWasTaken = true;  
       }
        
       return cardWasTaken;
    }
    
    /**
     * 
     * @return Card and removes the card in the top occupied position of the array.
     */
    public Card playCard() {
       Card card = this.myCards[--numCards];
       this.myCards[numCards] = null;
       return card; 
    }

    /**
     * 
     */
    @Override
    public String toString() {
       StringBuilder myCards = new StringBuilder();
  
       for (int i = 0; i < this.numCards; i ++) {
          myCards.append(this.myCards[i]).append(" ");
       }
  
       return myCards.toString();
    }
    
    /**
     * Accessor for an individual card.
     * 
     * @param k
     * @return a card with errorFlag = true if k is bad.
     */
    public Card inspectCard(int k) {
       Card cardToInspect = null;
  
       if (this.myCards == null || this.myCards.length == 0 || k > this.myCards.length) {
          Card errorCard = new Card();
          errorCard.setErrorFlag(true);
          cardToInspect =  errorCard;
       } else {
         cardToInspect = this.myCards[k];
       }
  
       return cardToInspect;
    }
}

/*
 * A class that represents the source of the cards for dealing and,
 * as the game progresses, the place from which players can receive new cards
 */
class Deck
{
   public static final int MAX_CARDS = 6 * 52;
   private static Card[] masterPack = new Card[52];
   private Card[] cards;
   private int topCard;
   
   //Overload the deck class; default only 1 class
   public Deck ()
   {
      allocateMasterPack();
      this.cards = new Card[52];
      init(1);
   }
   
   //Deck class with number of packs as the argument
   public Deck(int numPacks)
   {
      allocateMasterPack();

      //Fatal error if more than 6 decks used. 
      if (numPacks * 52 > MAX_CARDS) {
         System.out.println("Fatal Error. Too many decks. Need "
               + "count between 1 and 6");
         System.exit(0);
      }

      this.cards = new Card[52 * numPacks];
      init(numPacks);
   }
   
   //Initiates the cards array from the masterPack
   public void init(int numPacks)
   {
      topCard = 52 * numPacks - 1;
      int x = 0;

      for(int i = 0; i < numPacks; i++) {
         for(int j = 0; j < 52; j++) {
            cards[x++] = masterPack[j];
         }
      }
   }
   
   //Shuffle changes the position of the cards
   public void shuffle()
   {
      int rand;
      Card temp;

      for(int i = 0; i < cards.length; i++) {
         temp = cards[i]; //create a temp variable for the current card
         //Math.random is used to get a random card from the array to switch
         //with the current card.
         rand = (int)(Math.random() * (cards.length - 1));
         this.cards[i] = this.cards[rand];
         this.cards[rand] = temp;
         
      }
   }
   
   //returns the top card in the deck
   public Card dealCard()
   {
      return this.cards[getTopCard()];
   }
   
   //selects the top card index and adds 1 after the return
   public int getTopCard()
   {
      return topCard--;
   }
   
   //inspects the card to see if it is valid within the deck
   public Card inspectCard(int k)
   {
      Card cardToInspect;

      if(this.cards == null || this.cards.length == 0
            || k > this.cards.length) {
         Card errorCard = new Card();
         errorCard.setErrorFlag(true);
         cardToInspect = errorCard; 
      } else {
         cardToInspect = this.cards[k];
      }

      return cardToInspect;
   }
   
   //creates the master pack of 52 cards that does not change
   private static void allocateMasterPack()
   {
      char cardValue;
      int k = 0; //used to count the index of the masterPack deck.
      Card.Suit[] suits = Card.Suit.values();

      if(masterPack[51] == null) { //if null then create new deck
         for (int x = 0; x < suits.length; x++) {
            for (int i = 1; i < 14; i++) {
               if (i == 1) {
                  cardValue = 'A';
               } else if (i == 10) {
                  cardValue = 'T';
               } else if (i == 11) {
                  cardValue = 'J';
               } else if (i == 12) {
                  cardValue = 'Q';
               } else if (i == 13) {
                  cardValue = 'K';
               } else if (i == 2) {
                  cardValue = '2';
               } else if (i == 3) {
                  cardValue = '3';
               } else if (i == 4) {
                  cardValue = '4';
               } else if (i == 5) {
                  cardValue = '5';
               } else if (i == 6) {
                  cardValue = '6';
               } else if (i == 7) {
                  cardValue = '7';
               } else if (i == 8) {
                  cardValue = '8';
               } else {
                  cardValue = '9';
               }

               masterPack[k++] = new Card(cardValue, suits[x]);
            }
         }
      }
   }
}