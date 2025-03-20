/*
Kayli Pike
CS2100 - Final Project
This SmStraight class extends from abstract class Category.java
and represents the scoring for a small straight in Yahtzee.
*/

public class SmStraight extends Category
{
  /**
    * Evaluates the score for the small straight category based on occurrence of a small straight in the set of dice.
    *
    * @param d Set of dice to be evaluated.
    * @return Total score for small straight category.
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

      // Check for a small straight (sequence of 4)
      for (int value = 1; value <= 3; value++)
      {
         if (counts[value] > 0 && counts[value + 1] > 0 && counts[value + 2] > 0 && counts[value + 3] > 0)
         {
            // Return score for a small straight (30 points)
            return 30;
         }
      }

      // No small straight found, score is 0
      return 0;
   }
}