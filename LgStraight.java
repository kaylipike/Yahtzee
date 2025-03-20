/*
Kayli Pike
CS2100 - Final Project
This LgStraight class extends from abstract class Category.java
and represents the scoring for a large straight in Yahtzee.
*/

public class LgStraight extends Category
{
  /**
    * Evaluates the score for the large straight category based on occurrence of a large straight in the set of dice.
    *
    * @param d Set of dice to be evaluated.
    * @return Total score for large straight category.
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

      // Check for a large straight (sequence of 5)
      for (int value = 1; value <= 2; value++)
      {
         if (counts[value] > 0 && counts[value + 1] > 0 && counts[value + 2] > 0 && counts[value + 3] > 0 && counts[value + 4] > 0)
         {
            // Return score for a large straight (40 points)
            return 40;
         }
      }

      // No large straight found, score is 0
      return 0;
   }
} 