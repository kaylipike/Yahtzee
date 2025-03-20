/*
Kayli Pike
CS2100 - Final Project
This Yahtzee class extends from abstract class Category.java
and represents the scoring for five of a kind in Yahtzee.
*/

public class Yahtzee extends Category
{
  /**
    * Evaluates score for the yahtzee category based on if there is five occurences of the same value in the given set of dice.
    *
    * @param d Set of dice to be evaluated.
    * @return Score for the yahtzee category.
    */
   @Override
   public int evaluate(Dice d) 
   {
      int[] counts = new int[7];

      // Count occurrences of each die value
      for (int i = 0; i < d.getNumDice(); i++) 
      {
         Die die = d.getDie(i);
         counts[die.getValue()]++;
      }

      // Check for five of a kind
      for (int value = 1; value <= 6; value++) 
      {
         if (counts[value] >= 5) 
         {
            // Return 50 for Yahtzee
            return 50;
         }
      }

      // No five of a kind found, score is 0
      return 0;
   }
}