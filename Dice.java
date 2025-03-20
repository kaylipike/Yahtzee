/*
Kayli Pike
CS2100 - Final Project
This Dice class represents an array of dice 
and includes how it's values may be used or changed.
*/

import java.util.ArrayList;
import java.io.*;

public class Dice
{
   private ArrayList<Die> dice;
   private final static int DEF_CAP = 5;
   
   /**
     * Constructs new Dice object with a maximum capacity of 5 dice.
     */
   public Dice()
   {
      dice = new ArrayList<>(DEF_CAP);
   }
   
   /**
     * Constructor for new Dice object with a certain number of dice.
     *
     * @param num Number of dice to be added.
     */
   public Dice(int num)
   {
      dice = new ArrayList<>(num);
   }
   
   /**
     * Adds a die to array.
     *
     * @param d Specific die to be added.
     */
   public void addDie(Die d)
   {
      dice.add(d);
   }
   
   /**
     * Gets the number of dice in the array.
     *
     * @return Number of dice in array.
     */
   public int getNumDice()
   {
      return dice.size();
   }
   
   /**
     * Gets a die from the array based on its index.
     *
     * @param i The index of the die to get.
     * @return The specific die.
     */
   public Die getDie(int i)
   {
      return dice.get(i);
   }
   
   /**
     * Removes a certin die from the array based on its index.
     *
     * @param i The index of the die to remove.
     * @return The updated Dice object after removing the die.
     * @throws IndexOutOfBoundsException If the index is not in the correct range.
     */
   public Dice removedDie(int i)
   {
      if (i >= 0 && i < dice.size())
      {
         dice.remove(i);
      }
      else
      {
         throw new IndexOutOfBoundsException("" + i + "is not a valid die value");
      }
      return this;
   }
   
   /**
     * Counts the occurrences of a certain value among the dice in array.
     *
     * @param val The value to count occurences of.
     * @return The number of time it occurred in array.
     */
   public int count(int val)
   {
      int count = 0;
      for (Die die : dice)
      {
         if (die.getValue() == val)
         {
            count++;
         }
      }
      return count;
   }
   
   /**
     * Calculates sum of all dice values in array.
     *
     * @return Sum of all dice values in array.
     */  
   public int sum()
   {
      int total = 0;
      for (Die die : dice)
      {
         total += die.getValue();
      }
      return total;
   }
   
   /**
     * Checks if a value is present in the dice of array.
     *
     * @param val Value to check for.
     * @return true if the value is in array of dice, false otherwise.
     */
   public boolean contains(int val)
   {
      for (Die die : dice)
      {
         if (die.getValue() == val)
         {
            return true;
         }
      }
      return false;
   }
   
   /**
     * Generates string representation of dice array with corresponding values of each die.
     *
     * @return String representation of dice in array.
     */
   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < dice.size(); i++)
      {
         result.append((i + 1)).append(": value ").append(dice.get(i).getValue());
         
         if (i < dice.size() - 1)
         {
            result.append("\n");
         }
      }
      return result.toString();
   }  
}