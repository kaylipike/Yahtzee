/*
Kayli Pike
CS2100 - Final Project
This Player Category class is to represent 
the two players playing the Yahtzee game. 
Each player has a name, a set of 5 dice, and
their own scorecard. 
*/

import java.util.Scanner;

public class Player 
{
   private String playerName;
   private DiceRoll diceRoll;
   private ScoreCard scoreCard;
   private boolean[] savedDice;
   private int playerNumber; 

   /**
     * Constructor for new Player object with a specified name and player number, and initializes other player-related attributes.
     *
     * @param playerName   TName of the player.
     * @param playerNumber Player's number (1 or 2).
     */
   public Player(String playerName, int playerNumber) 
   {
      this.diceRoll = new DiceRoll();
      this.scoreCard = new ScoreCard();
      this.savedDice = new boolean[5];
      this.playerName = playerName;
      this.playerNumber = playerNumber;
        
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter the name for Player " + playerNumber + ": ");
      this.playerName = scanner.nextLine();
   }

   /**
     * Get player's name.
     *
     * @return Name of player.
     */
   public String getName() 
   {
      return playerName;
   }

   /**
     * Gets the DiceRoll object for the player.
     *
     * @return Player's dice roll.
     */
   public DiceRoll getDiceRoll() 
   {
      return diceRoll;
   }

   /**
     * Gets ScoreCard object for the player.
     *
     * @return Player's scorecard.
     */
   public ScoreCard getScoreCard() 
   {
      return scoreCard;
   }

   /**
     * Roll dice for player.
     */
   public void rollDice() 
   {
      diceRoll.toss();
   }

   /**
     * Change save status of a specific die from the player's dice roll.
     *
     * @param dieNumber Number of the die to change save status of.
     */
   public void toggleSaveStatus(int dieNumber) 
   {
      if (dieNumber >= 1 && dieNumber <= 5) 
      {
         savedDice[dieNumber - 1] = !savedDice[dieNumber - 1];
      } 
      else 
      {
         System.out.println("Invalid die number. Please choose a valid die number.");
      }
   }

   /**
     * Scores current dice roll for a specified category and resets saved dice.
     *
     * @param categoryValue Specific category to score the dice roll in.
     */
   public void scoreAndEndTurn(CategoryValue categoryValue) 
   {
      scoreCard.choose(categoryValue, diceRoll);
      resetSavedDice();
   }

   /**
     * Resets saved dice for player for their next turn.
     */
   public void resetSavedDice() 
   {
      for (int i = 0; i < 5; i++) 
      {
         savedDice[i] = false;
      }
   }
    
   /**
     * Gets array of saved die for the player.
     *
     * @return An array that shows the dice that are saved, which is evaluated as true, or unsaved which is false.
     */
   public boolean[] getSavedDice() 
   {
      return savedDice;
   }
    
   /**
     * Get identifying number of the player.
     *
     * @return The player's number.
     */
   public int getPlayerNumber() 
   {
      return playerNumber; 
   }
}
