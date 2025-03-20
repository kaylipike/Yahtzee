/*
Kayli Pike
CS2100 - Final Project
This Die class represents a single six-sided die, 
generates and gets a value between 1 and 6 for it, 
and shows its value. 
*/

import java.util.Random;

public class Die
{
   private int value;
   private final static int SIDES = 6;
   private static Random r = new Random();
  
   /**
     * Constructor for a Die object and rolls it to generate an initial random value.
     */
   public Die()
   {
      roll();
   }
   
   /**
     * Method for rolling the die, getting a new random value between 1 and 6 for it.
     */
   public void roll()
   {
      value = r.nextInt(SIDES) + 1;
   }
   
   /**
     * Gets current value of die.
     *
     * @return Value of the die.
     */
   public int getValue()
   {
      return value;
   }
   
   /**
     * Returns a string representation of the die with its current value.
     *
     * @return A string representation of the die.
     */
   @Override
   public String toString()
   {
      return "value " + value;
   }
}