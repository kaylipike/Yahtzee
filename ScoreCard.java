/*
Kayli Pike
CS2100 - Final Project
This ScoreCard class represents the scorecard used by players
in the Yahtzee game. It tracks the scores for various categories 
and totals all points earned. 
*/

import java.util.ArrayList;

public class ScoreCard 
{
   private ArrayList<Category> scorecard;
   private int yahtzeeBonus;
   private int NUM_CATS = 13;

  /**
    * Constructor for new ScoreCard object. Initializes the scorecard with instances for each category and sets Yahtzee bonus to zero.
    */
   public ScoreCard() 
   {
      scorecard = new ArrayList<>(); // the collection of Category objects
      yahtzeeBonus = 0;

      // Create concrete instances for each category and add to the ArrayList
      for (int i = 0; i < NUM_CATS; i++) 
      {
         scorecard.add(new Ones()); 
         scorecard.add(new Twos());
         scorecard.add(new Threes());
         scorecard.add(new Fours());
         scorecard.add(new Fives());
         scorecard.add(new Sixes());
         scorecard.add(new ThreeOfAKind());
         scorecard.add(new FourOfAKind());
         scorecard.add(new FullHouse());
         scorecard.add(new SmStraight());
         scorecard.add(new LgStraight());
         scorecard.add(new Yahtzee());
         scorecard.add(new Chance());
      }
   }

   /**
     * Records value earned from scoring in the specified category based on the players dice roll.
     *
     * @param cv The chosen category to be scored in.
     * @param d  The dice roll used to determine the points to score.
     */
   public void choose(CategoryValue cv, Dice d) 
   {
      Category category = scorecard.get(cv.ordinal());
      int[] counts = new int[7];

      // Count occurrences of each die value
      for (int i = 0; i < d.getNumDice(); i++) 
      {
         Die die = d.getDie(i);
         counts[die.getValue()]++;
      }

      // Check for five of a kind
      for (int value = 1; value <= 6; value++) 
      {
         if (counts[value] >= 5 && getCategoryScore(CategoryValue.YAHTZEE) == 50 && yahtzeeBonus < 3) 
         {
            yahtzeeBonus++;
         }
      }
      category.addValue(d);
   }

   /**
     * Returns potential amount of points that could be earned in a specified category based on player's given dice roll.
     *
     * @param cv The category to evaluate the points for.
     * @param d  The dice roll to use when evaluating.
     * @return The potential number of points for the specified category.
     */
   public int getEvaluation(CategoryValue cv, Dice d) 
   {
      Category category = scorecard.get(cv.ordinal());
      return category.evaluate(d);
   }

   /**
     * Checks if user specified category has already been scored in.
     *
     * @param cv The category to check.
     * @return true if the category has been scored, false otherwise.
     */
   public boolean checkScored(CategoryValue cv) 
   {
      Category category = scorecard.get(cv.ordinal());
      return category.getUsed();
   }
   
   /**
     * Returns score for specified category.
     *
     * @param cv The category to get the score for.
     * @return The score of the category.
     */
   public int getCategoryScore(CategoryValue cv) 
   {
      Category category = scorecard.get(cv.ordinal());
      return category.getScore();
   }

   /**
     * Calculates and returns total score for upper portion of scorecard.
     *
     * @return The total for the upper part of the scorecard.
     */
   public int scoreTop() 
   {
      int topScore = 0;
      for (int i = 0; i < 6; i++) 
      {
         topScore += scorecard.get(i).getScore();
      }
      return topScore;
   }

   /**
     * Calculates and returns total score for lower portion of scorecard.
     *
     * @return The total for the lower part of the scorecard.
     */
   public int scoreBottom() 
   {
      int bottomScore = 0;
      for (int i = 6; i < NUM_CATS; i++) 
      {
         bottomScore += scorecard.get(i).getScore();
      }
      return bottomScore;
   }

   /**
     * Calculates and returns total score of scorecard.
     *
     * @return The total score.
     */
   public int score() 
   {
      return scoreTop() + scoreBottom() + yahtzeeBonus * 100;
   }   
   
   /**
     * Generates string representation of current scorecard. 
     *
     * @return A string representation of the current scorecard.
     */
   @Override
   public String toString() 
   {
      StringBuilder result = new StringBuilder();
      result.append("Current Scorecard:\n");

      result.append("Ones: " + getCategoryScore(CategoryValue.ONES) + "\n");
      result.append("Twos: " + getCategoryScore(CategoryValue.TWOS) + "\n");
      result.append("Threes: " + getCategoryScore(CategoryValue.THREES) + "\n");
      result.append("Fours: " + getCategoryScore(CategoryValue.FOURS) + "\n");
      result.append("Fives: " + getCategoryScore(CategoryValue.FIVES) + "\n");
      result.append("Sixes: " + getCategoryScore(CategoryValue.SIXES) + "\n");

      result.append("Three of a Kind: " + getCategoryScore(CategoryValue.THREE_OF_A_KIND) + "\n");
      result.append("Four of a Kind: " + getCategoryScore(CategoryValue.FOUR_OF_A_KIND) + "\n");
      result.append("Full House: " + getCategoryScore(CategoryValue.FULL_HOUSE) + "\n");
      result.append("Small Straight: " + getCategoryScore(CategoryValue.SM_STRAIGHT) + "\n");
      result.append("Large Straight: " + getCategoryScore(CategoryValue.LG_STRAIGHT) + "\n");
      result.append("Yahtzee: " + getCategoryScore(CategoryValue.YAHTZEE) + "\n");
      result.append("Chance: " + getCategoryScore(CategoryValue.CHANCE) + "\n");

      result.append("Yahtzee bonus: " + yahtzeeBonus + "\n");
      result.append("Upper Total: " + scoreTop() + "\n");
      result.append("Lower Total: " + scoreBottom() + "\n");
      result.append("Total: " + score() + "\n");

      return result.toString();
   }
}