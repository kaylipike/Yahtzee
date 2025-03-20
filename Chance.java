/*
Kayli Pike
CS2100 - Final Project
This Chance class extends from abstract class Category.java
and represents the scoring for chance in Yahtzee.
*/

public class Chance extends Category
{
   /**
    * Evaluates score for chance category as sum of all dice values in given set of dice.
    *
    * @param dice Set of dice to be evaluated.
    * @return Total score for the chance category.
    */
   @Override
   public int evaluate(Dice dice)
   {
      // Sum up all the dice values
      int total = 0;
      for (int i = 0; i < dice.getNumDice(); i++)
      {
         Die die = dice.getDie(i);
         total += die.getValue();
      }

      // Return the sum as the score for the Chance category
      return total;
   }
}