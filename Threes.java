/*
Kayli Pike
CS2100 - Final Project
This Threes class extends from abstract class Category.java
and represents the scoring for threes in Yahtzee.
*/

public class Threes extends Category
{
  /**
    * Evaluates score for the threes category based on occurrence of threes in the given set of dice.
    *
    * @param d Set of dice to be evaluated.
    * @return Score for the threes category.
    */
   @Override
   public int evaluate(Dice d)
   {
      int total = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         Die die = d.getDie(i);
         if(die.getValue() == 3)
         {
            total += 3;
         }
      }
      return total;
   }
}