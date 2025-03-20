/*
Kayli Pike
CS2100 - Final Project
This Fours class extends from abstract class Category.java
and represents the scoring for fours in Yahtzee.
*/

public class Fours extends Category 
{
  /**
    * Evaluates score for the fours category based on occurrence of fours in the given set of dice.
    *
    * @param d Set of dice to be evaluated.
    * @return Score for the fours category.
    */
   @Override
   public int evaluate(Dice d)
   {
      int total = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         Die die = d.getDie(i);
         if(die.getValue() == 4)
         {
            total += 4;
         }
      }
      return total;
   }
}