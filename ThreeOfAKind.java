/*
Kayli Pike
CS2100 - Final Project
This ThreeOfAKind class extends from abstract class Category.java
and represents the scoring for three of a kind in Yahtzee.
*/

public class ThreeOfAKind extends Category
{
  /**
    * Evaluates score for the three of a kind category based on if there is at least three occurences of the same value in the given set of dice.
    *
    * @param d Set of dice to be evaluated.
    * @return Score for the three of a kind category.
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

      // Check for at least three of a kind
      for (int value = 1; value <= 6; value++) 
      {
         if (counts[value] >= 3) 
         {
            // Return the sum of all dice values
            return sum;
         }
      }

      // No three of a kind found, score is 0
      return 0;
   }
}