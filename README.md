# Two-Player Yahtzee Game

**Author:** Kayli Pike

---

## Overview

This project implements a two-player console-based version of Yahtzee, the classic dice game centered on probability, decision-making, and strategic scoring.
Players compete across 13 rounds, rolling five dice to achieve high-scoring combinations while managing their scorecard categories efficiently. The game follows official Yahtzee rules and incorporates a fully object-oriented design for clarity, maintainability, and modularity.

---

## Gameplay

Each round, both players take turns rolling five dice. A player may roll up to three times per turn, choosing to save specific dice between rolls to optimize their outcome. After the final roll, the player must select a scoring category — which can only be used once during the game.

The scoring system is divided into two sections:

### Upper Section

* Ones, Twos, Threes, Fours, Fives, Sixes – Score the total of the chosen number rolled.
* Bonus: Achieved if the player scores 63 points or more in the upper section.

### Lower Section

* Three of a Kind
* Four of a Kind
* Full House
* Small Straight
* Large Straight
* Yahtzee (Five of a Kind)
* Chance

Additional Yahtzee bonuses are awarded for rolling extra Yahtzees after the first.

---

## Object-Oriented Design

The project is structured around clear object-oriented programming principles, using encapsulation, modularity, and abstraction to manage game logic.
Key classes include:

| Class                        | Responsibility                               |
| ---------------------------- | -------------------------------------------- |
| `Die`                        | Represents a single die and its value        |
| `Dice`                       | Manages a set of five dice and roll logic    |
| `DiceRoll`                   | Encapsulates a single roll state             |
| `Category` / `CategoryValue` | Defines and manages scoring categories       |
| `ScoreCard`                  | Tracks and updates player scores             |
| `Game`                       | Controls the overall game logic and flow     |
| `GameDriver`                 | Handles user interaction and turn sequencing |

This structure allows for clean code organization and easy scalability.


---

## User Interaction

Players interact with the program via the command line of whatever IDE is used to run the program. During each turn, users may:

* Type `"roll"` to roll the dice.
* Enter a number between 1–5 to toggle saving or unsaving an individual die.
* Type `"score"` to select a scoring category for the current dice configuration.

The program employs exception handling to validate input and maintain a smooth gameplay experience.

---

## Scoring and Rules

* The game automatically calculates the total score after all 13 rounds.
* Both upper and lower section bonuses are applied as per Yahtzee rules.
* Yahtzee bonuses are awarded for any additional Yahtzees rolled after the first.

At the end of the game, the final scores for both players are displayed, and the winner is declared.

---

## Technical Details

* **Language:** Java
* **Paradigm:** Object-Oriented Programming (OOP)
* **Error Handling:** Robust exception management for user inputs
* **Interface:** Command-line text-based UI
* **Documentation:** Clear comments and logical class structure

---

## Acknowledgments

* **Starter Code:** Provided by Professor Jackie Horton
* **Author:** All additional code, including class implementations and logic, written by Kayli Pike

---

## Contact

For questions, feedback, or collaboration inquiries, please contact:

**Email:** [kayli.pike@gmail.com](mailto:kayli.pike@gmail.com)

---

**© 2023 Kayli Pike**
