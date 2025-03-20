/*
Kayli Pike
CS2100 - Final Project
This FourOfAKind class extends from abstract class Category.java
and represents the scoring for four of a kind in Yahtzee.
*/

public class FourOfAKind extends Category
{
  /**
    * Evaluates score for the four of a kind category based on if there is at least four occurences of the same value in the given set of dice.
    *
    * @param d Set of dice to be evaluated.
    * @return Score for the four of a kind category.
    */
   @Override
   public int evaluate(Dice d) 
   {
      int[] counts = new int[7];
      int sum = 0;

      // Count occurrences of each die value
      for (int i = 0; i < d.getNumDice(); i++) 
      {
         Die die = d.getDie(i);
         counts[die.getValue()]++;
         sum += die.getValue();
      }

      // Check for at least four of a kind
      for (int value = 1; value <= 6; value++) 
      {
         if (counts[value] >= 4) 
         {
            // Return the sum of all dice values
            return sum;
         }
      }

      // No four of a kind found, score is 0
      return 0;
   }
}