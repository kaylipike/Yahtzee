/*
Kayli Pike
CS2100 - Final Project
This DiceRoll class extends from Dice.java and 
represents an array of dice to be rolled when
playing Yahtzee.
*/

public class DiceRoll extends Dice
{
   private final static int NUM_DIE = 5;
   
   /**
     * Constructor for new DiceRoll object, initializing set of five dice.
     */
   public DiceRoll()
   {
      super(NUM_DIE);
      for (int i = 0; i < NUM_DIE; i++) 
      {
         addDie(new Die());
      }
   }
   
   /**
     * Rolls all dice in set, gets new random values for each die.
     */
   public void toss() 
   {
      for (int i = 0; i < getNumDice(); i++) 
      {         
         getDie(i).roll();
      }
   }
}