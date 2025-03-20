/*
Kayli Pike
CS2100 - Final Project
This FullHouse class extends from abstract class Category.java
and represents the scoring for a full house in Yahtzee.
*/

public class FullHouse extends Category
{
  /**
    * Evaluates score for the full house category based on if 3 of the die in the set have the same value and the other 2 their own shared value.
    *
    * @param d Set of dice to be evaluated.
    * @return Score for the full house category.
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

      boolean hasThree = false;
      boolean hasTwo = false;

      // Check for three of a kind and two of a kind
      for (int value = 1; value <= 6; value++)
      {
         if (counts[value] == 3)
         {
            hasThree = true;
         }
         else if (counts[value] == 2)
         {
            hasTwo = true;
         }
      }

      // Return score for a full house (25 points) or 0 if not met
      return (hasThree && hasTwo) ? 25 : 0;
   }
}