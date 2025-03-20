/*
Kayli Pike
CS2100 - Final Project
This Twos class extends from abstract class Category.java
and represents the scoring for twos in Yahtzee.
*/

public class Twos extends Category
{
  /**
    * Evaluates score for the twos category based on occurrence of twos in the given set of dice.
    *
    * @param d Set of dice to be evaluated.
    * @return Score for the twos category.
    */
   @Override
   public int evaluate(Dice d)
   {
      int total = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         Die die = d.getDie(i);
         if(die.getValue() == 2)
         {
            total += 2;
         }
      }
      return total;
   }
}