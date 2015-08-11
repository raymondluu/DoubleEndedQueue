/*
 * TCSS 342 Winter 2013
 * Assigment 2
 */

package util;

/**
 * A List Output Restricted Double Ended Queue class that extends ListQueue and implements
 * Output Restricted Double Ended Queue.
 * 
 * @author Raymond Luu
 * @version Winter 2013
 *
 * @param <E> the generic type parameter
 */
public class ListOutputRestrictedDoubleEndedQueue<E> extends ListQueue<E> 
                                                implements OutputRestrictedDoubleEndedQueue<E>
{
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void enqueueAtFront(final E the_element)
  {
    final ListNode<E> node = new ListNode<E>(the_element);
    if (isEmpty())
    {
      front = node;
    }
    else
    {
      node.next = front;
      front = node;
    }
  }
  
}
