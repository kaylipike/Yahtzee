/*
Kayli Pike
CS2100 - Final Project
This Game class plays the Yahtzee game, alternates 
between 2 Players for 13 turns, scores their turns 
and keeps track of points on scorecards, then ends 
the game. 
*/


import java.util.Scanner;

public class Game {
    private final static int MAX_TURNS = 13;
    private DiceRoll diceRoll;
    private Player player1;
    private Player player2;
    private Scanner scanner;

    /**
     * Constructor for new Game object with two players, a dice roller, and a scanner for user input.
     */
    public Game() 
    {
        player1 = new Player("Player 1", 1);
        player2 = new Player("Player 2", 2);
        scanner = new Scanner(System.in);
        diceRoll = new DiceRoll();
    }

    /**
     * Method to play the Yahtzee game for 13 turns, alternating between two players, and displaying the final scores for both players.
     */
    public void playGame() 
    {
        for (int turn = 1; turn <= MAX_TURNS; turn++) 
        {
            playerTurn(player1);
            playerTurn(player2);
        }

        // Display the final score for both players
        System.out.println("Final Score - Player 1:");
        System.out.println(player1.getScoreCard().toString());

        System.out.println("Final Score - Player 2:");
        System.out.println(player2.getScoreCard().toString());
    }

   /**
     * Method for playing single turn for certain player, with dice rolling and scoring.
     *
     * @param player The player whose turn it is.
     */
    private void playerTurn(Player player) 
    {
        resetSavedDice(player);
        diceRoll.toss();
        // Dislay specified player's name and scorecard
        System.out.println("\n");
        System.out.println("*** Player " + player.getPlayerNumber() + ": ***");
        System.out.println("Player Name: " + player.getName());
        System.out.println(player.getScoreCard().toString());
        System.out.println("*******************************************************");
        
        // rolls = 1 because of intial dice toss counting as 1 of the 3 rolls a player gets on their turn
        int rolls = 1;
        
        // while player still has rolls left
        while (rolls < 3) 
        {
            System.out.println("\n");
            System.out.println("Dice:");
            for (int i = 0; i < 5; i++) 
            {
                String status = player.getSavedDice()[i] ? "SAVE" : "";
                System.out.println((i + 1) + ": value " + diceRoll.getDie(i).getValue() + " " + status);
            }

            System.out.println("\n");
            System.out.println("Please select a die # to toggle it between save and unsave, \"roll\" or \"score\":");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("roll")) 
            {
                rolls++;
                reRollUnsavedDice(player);
                System.out.println(player.getScoreCard().toString());
                System.out.println("*******************************************************");
            } 
            else if (input.equals("score")) 
            {
                scoreAndEndTurn(player);
                return;
            } else {
                try {
                    int dieNumber = Integer.parseInt(input);
                    player.toggleSaveStatus(dieNumber);
                } 
                catch (NumberFormatException e) 
                {
                    System.out.println("Invalid input. Please enter a valid die number, \"roll\", or \"score\":");
                }
            }
        }

        // If the player is out of rolls, force them to score
        System.out.println("\n");
        for (int i = 0; i < 5; i++) 
        {
            String status = player.getSavedDice()[i] ? "SAVE" : "";
            System.out.println((i + 1) + ": value " + diceRoll.getDie(i).getValue() + " " + status);
        }
        System.out.println("\n");
        System.out.println("Out of rolls, you must score");
        scoreAndEndTurn(player);
    }

   /**
     * Displays the categories player can score in and prompts player to choose a category for scoring. Updates the player's scorecard with earned points.
     *
     * @param player The player whose turn it is (the player who is scoring their roll).
     */
   private void scoreAndEndTurn(Player player) 
   {
      System.out.println("Select a category you have not scored in yet: ");
      // Display categories with numbers
      for (int i = 0; i < CategoryValue.values().length; i++) 
      {
         CategoryValue category = CategoryValue.values()[i];
            if (!player.getScoreCard().checkScored(category)) 
            {
               int potentialPoints = player.getScoreCard().getEvaluation(category, diceRoll);
               System.out.println((i + 1) + ": " + category + ", " + potentialPoints + " points");
            }
      }

      // Get user input and validate
      int categoryNumber = -1;
      while (categoryNumber < 1 || categoryNumber > CategoryValue.values().length ||
                player.getScoreCard().checkScored(CategoryValue.values()[categoryNumber - 1])) 
      {
         try 
         {
            categoryNumber = Integer.parseInt(scanner.nextLine());
            if (categoryNumber < 1 || categoryNumber > CategoryValue.values().length ||
                        player.getScoreCard().checkScored(CategoryValue.values()[categoryNumber - 1])) 
            {
               System.out.println("That is not the number of a category you can score. Please enter a valid number.");
            }
         } 
         catch (NumberFormatException e) 
         {
            System.out.println("Invalid input. Please enter a valid number.");
         }
      }

      // Map user input to category
      CategoryValue selectedCategory = CategoryValue.values()[categoryNumber - 1];

      // Score and end turn
      player.getScoreCard().choose(selectedCategory, diceRoll);
      System.out.println("You scored " +  player.getScoreCard().getCategoryScore(selectedCategory) + " points in " + selectedCategory);
   }

   /**
     * Rolls the dice the player did not save.
     *
     * @param player The player who is rolling their unsaved dice.
     */
   private void reRollUnsavedDice(Player player) 
   {
      for (int i = 0; i < 5; i++) 
      {
         if (!player.getSavedDice()[i]) 
         {
            diceRoll.getDie(i).roll();
         }
      }
   }

   /**
     * Resets saved dice for player (in preparation for new turn).
     *
     * @param player The player whose saved dice are being reset.
     */
   private void resetSavedDice(Player player) 
   {
      player.resetSavedDice();
   }
}
