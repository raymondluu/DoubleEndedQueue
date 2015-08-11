/*
 * TCSS 342 Winter 2013
 * Assignment 2
 */

package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.ListOutputRestrictedDoubleEndedQueue;

/**
 * Radix Sort class.
 * 
 * @author Raymond Luu
 * @version Winter 2013
 *
 */
public final class RadixSort
{
  
  /**
   * Constant for Digit 10.
   */
  public static final int DIGIT_TEN = 10;
  
  /**
   * Constant for Digit 100.
   */
  public static final int DIGIT_HUNDRED = 100;
  
  /**
   * Constant for Digit 1000.
   */
  public static final int DIGIT_THOUSAND = 1000;
  
  /**
   * Constant for Digit 0.
   */
  public static final int DIGIT_ZERO = 0;
  
  /**
   * Constant for Digit 1.
   */
  public static final int DIGIT_ONE = 1;
  
  /**
   * Constant for Digit 2.
   */
  public static final int DIGIT_TWO = 2;
  
  /**
   * Constant for Digit 3.
   */
  public static final int DIGIT_THREE = 3;
  
  /**
   * Constant for Digit 4.
   */
  public static final int DIGIT_FOUR = 4;
  
  /**
   * Constant for Digit 5.
   */
  public static final int DIGIT_FIVE = 5;
  
  /**
   * Constant for Digit 6.
   */
  public static final int DIGIT_SIX = 6;
  
  /**
   * Constant for Digit 7.
   */
  public static final int DIGIT_SEVEN = 7;
  
  /**
   * Constant for Digit 8.
   */
  public static final int DIGIT_EIGHT = 8;
  
  /**
   * Constant for Digit 9.
   */
  public static final int DIGIT_NINE = 9;
  
  /**
   * Master queue to hold all the inputs.
   */
  private static ListOutputRestrictedDoubleEndedQueue<Integer> my_master_queue =
                                          new ListOutputRestrictedDoubleEndedQueue<Integer>();
  
  /**
   * ArrayList of my digit queues from 0 to 9.
   */
  private static List<ListOutputRestrictedDoubleEndedQueue<Integer>> my_digit_queues =
                                new ArrayList<ListOutputRestrictedDoubleEndedQueue<Integer>>();
  
  /**
   * Private Radix Sort constructor.
   */
  private RadixSort()
  {
    // empty private constructor
  }
  
  /**
   * Scans file for inputs and places into Queue.
   * 
   * @throws FileNotFoundException if file is not found.
   */
  public static void scanInput() throws FileNotFoundException
  {
    final File file_name = new File("in.txt");
    
    final Scanner input = new Scanner(file_name);
    
    while (input.hasNext())
    {
      my_master_queue.enqueue(input.nextInt());
    }
    
    input.close();
  }
  
  /**
   * Method to sort the numbers.
   * 
   * @param the_digit_place deterimines which digit place to sort by.
   */
  public static void sortNumbers(final int the_digit_place)
  {
    int current = 0;
    int remainder = 0;
    
    // create the queues to be used
    for (int i = 0; i < DIGIT_TEN; i++)
    {
      my_digit_queues.add(new ListOutputRestrictedDoubleEndedQueue<Integer>());
    }
    
    // move elements from master queue to correct digit queue
    while (!my_master_queue.isEmpty())
    {
      current = my_master_queue.dequeue();
      
      remainder = current / the_digit_place % DIGIT_TEN;
      
      for (int i = 0; i < DIGIT_TEN; i++)
      {
        
        // if the place digit equals i then place into correct queue.
        if (remainder == i)
        {
          my_digit_queues.get(i).enqueue(current);
        }
        
      }
      
    }
    
    // move elements from digit queues back into master queue
    for (int i = 0; i < DIGIT_TEN; i++)
    {
      while (!my_digit_queues.get(i).isEmpty())
      {
        my_master_queue.enqueue(my_digit_queues.get(i).dequeue());
      }
    }
  }
  
  /**
   * Method to print out elements onto a file.
   * 
   * @throws FileNotFoundException if file is not found.
   */
  public static void printOutput() throws FileNotFoundException
  {
    final PrintWriter output = new PrintWriter("out.txt");
    
    while (!my_master_queue.isEmpty())
    {
      output.println(my_master_queue.dequeue());
    }
    
    output.close();
  }
  
  /**
   * Main method.
   * 
   * @param the_args the argument.
   * @throws FileNotFoundException if file is not found.
   */
  public static void main(final String[] the_args) throws FileNotFoundException 
  {
    scanInput();
    
    // sort numbers with ones place
    sortNumbers(DIGIT_ONE);
    
    // sort numbers with tens place
    sortNumbers(DIGIT_TEN);
    
    // sort numbers with hundreds place
    sortNumbers(DIGIT_HUNDRED);
    
    // sort numbers with thousands place
    sortNumbers(DIGIT_THOUSAND);
    
    printOutput();
  }

}
