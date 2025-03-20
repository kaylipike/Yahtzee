/*
Kayli Pike
CS2100 - Final Project
This Fives class extends from abstract class Category.java
and represents the scoring for fives in Yahtzee.
*/

public class Fives extends Category
{
  /**
    * Evaluates score for the fives category based on occurrence of fives in the given set of dice.
    *
    * @param d Set of dice to be evaluated.
    * @return Score for the fives category.
    */
   @Override
   public int evaluate(Dice d)
   {
      int total = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         Die die = d.getDie(i);
         if(die.getValue() == 5)
         {
            total += 5;
         }
      }
      return total;
   }
}