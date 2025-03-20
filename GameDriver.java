/*
Kayli Pike I would like to be evaluated for extra credit from implementing a Player class. 
CS2100 - Final Project
This program kicks off a Yahtzee Game class for 2 players. 

I would like to be evaluated for extra credit from implementing a Player class. 
*/

public class GameDriver 
{
   /**
     * Main method of Yahtzee game program.
     *
     * @param args Command-line arguments (not used in program).
     */
   public static void main(String[] args) 
   {
      System.out.println("*******************************************************");
      System.out.println("WELCOME TO YAHTZEE"); // Display welcome message for players before game begins.
      System.out.println("*******************************************************");
      System.out.println("\n");
      Game yahtzeeGame = new Game(); 
      yahtzeeGame.playGame(); // Play Yahtzee game
   }
}
