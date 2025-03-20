/*
Kayli Pike
CS2100 - Final Project
This abstract Category class is for all 
categories present on the scorecard. 
*/

public abstract class Category
{
   private int score;
   private boolean used;
   
   /**
     * Abstract method to be used in subclasses. Evaluates score for category based on dice roll.
     *
     * @param d Dice roll to be scored.
     * @return Score for the category.
     */
   public abstract int evaluate(Dice d);
   
   /**
     * Adds score to category if the category has not been scored in yet.
     *
     * @param d Dice roll to be used for scoring.
     */
   public void addValue(Dice d)
   {
      if (!used)
      {
         score = evaluate(d);
         used = true;
      }
   }

   /**
     * Returns score for the category.
     *
     * @return Score for the category.
     */
   public int getScore()
   {
      return score;
   }
   
   /**
     * Checks if category has already been chosen and scored in.
     *
     * @return true if the category has been used, false otherwise.
     */
   public boolean getUsed()
   {
      return used;
   }  
}