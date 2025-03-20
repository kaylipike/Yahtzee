# Yahtzee
This project implements a two-player game of Yahtzee, a popular dice game where the objective is to maximize your score by rolling five dice and achieving specific combinations. The game follows the traditional Yahtzee rules, which include 13 rounds where each player gets one turn per round. Players roll five dice up to three times per round, with the option to save dice between rolls. After each turn, players must choose a category on their scorecard to score points, and once a category is used, it cannot be selected again.

The Yahtzee scoring system is split into two sections: the upper section and the lower section. The upper section consists of individual categories (Ones, Twos, Threes, etc.), where players earn points based on the number rolled. The lower section contains more complex combinations like Three of a Kind, Full House, Small Straight, Large Straight, Yahtzee (Five of a Kind), and Chance. The game also includes a Yahtzee bonus system, which rewards players with extra points if they roll additional Yahtzees after the first one.

The game is built using object-oriented principles and includes several classes: Die, Category, CategoryValue, Dice, DiceRoll, ScoreCard, and Game. The Die class represents a single die, and the Dice class manages a collection of dice. The ScoreCard class tracks the player's progress throughout the game, storing scores for each category. The Game and GameDriver classes handle the game flow, including prompting the user for input and ensuring proper turn-taking.

The user interacts with the game through the command line. During each turn, the player can choose from three options: "roll", "score", or enter an integer between 1 and 5 to toggle the saved status of individual dice. The program uses exception handling to ensure that user input is valid and that the game runs smoothly.

The final score is calculated based on the categories the player has scored throughout the game, including both the top and bottom sections of the scorecard. The Yahtzee bonus is added to the final score for each additional Yahtzee rolled after the first.

This project follows the core principles of good programming practices, with clear documentation, exception handling, and a robust user interface. 

Sources: Some source code provided by Professor Jackie Horton. All other code authored by Kayli Pike. Please contact knpike@uvm.edu with any questions.


