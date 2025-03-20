/*
Kayli Pike
CS2100 - Final Project
This Sixes class extends from abstract class Category.java
and represents the scoring for sixes in Yahtzee.
*/

public class Sixes extends Category
{
  /**
    * Evaluates score for the sixes category based on occurrence of sixes in the given set of dice.
    *
    * @param d Set of dice to be evaluated.
    * @return Score for the sixes category.
    */
   @Override
   public int evaluate(Dice d)
   {
      int total = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         Die die = d.getDie(i);
         if(die.getValue() == 6)
         {
            total += 6;
         }
      }
      return total;
   }
}