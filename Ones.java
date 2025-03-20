/*
Kayli Pike
CS2100 - Final Project
This Ones class extends from abstract class Category.java
and represents the scoring for ones in Yahtzee.
*/

public class Ones extends Category
{
  /**
    * Evaluates score for the ones category based on occurrence of ones in the given set of dice.
    *
    * @param d Set of dice to be evaluated.
    * @return Score for the ones category.
    */
   @Override
   public int evaluate(Dice d)
   {
      int total = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         Die die = d.getDie(i);
         if(die.getValue() == 1)
         {
            total += 1;
         }
      }
      return total;
   }
}