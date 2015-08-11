/*
 * TCSS 342 Winter 2013
 * Assignment 2
 */

package util;

/**
 * An Output Restricted Double Ended Queue interface that will extend Queue.
 * 
 * @author Raymond Luu
 * @version Winter 2013
 * 
 * @param <E> the generic type parameter
 */
public interface OutputRestrictedDoubleEndedQueue<E> extends Queue<E>
{
  
  /**
   * Insert a new item into the queue at the front.
   * 
   * @param the_element the element to be inserted.
   */
  void enqueueAtFront(E the_element);
  
}
