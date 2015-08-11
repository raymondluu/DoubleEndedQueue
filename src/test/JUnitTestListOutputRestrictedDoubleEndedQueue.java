/*
 * TCSS 342 Winter 2013
 * Assignment 2
 */

package test;

import org.junit.Before;
import org.junit.Test;

import util.ListOutputRestrictedDoubleEndedQueue;
import util.UnderflowException;

import static org.junit.Assert.*;

/**
 * A List Output Restricted Double Ended Queue JUnit Test.
 * 
 * @author Raymond Luu
 * @version Winter 2013
 *
 */
public class JUnitTestListOutputRestrictedDoubleEndedQueue
{
  /**
   * Expected string output.
   */
  private static final String MY_EXPECTED = "Front ->[1, 2, 1, ]<- Back";
  
  /**
   * A queue to test with.
   */
  private ListOutputRestrictedDoubleEndedQueue<Integer> my_queue;
  
  /**
   * Initialize the queue before each test is ran.
   */
  @Before
  public void setUp()
  {
    my_queue = new ListOutputRestrictedDoubleEndedQueue<Integer>();
  }
  
  // Tests
  
  /**
   * Test method for List Output Restricted Double Ended Queue.
   */
  @Test
  public void testListOutputRestrictedDoubleEndedQueue()
  {
    assertTrue("New Queue should be empty so Front equals null", my_queue.isEmpty());
  }
  
  /**
   * Test method for enqueue().
   */
  @Test
  public void testEnqueue()
  {
    // test when queue is empty
    my_queue.enqueue(1);
    
    assertSame("enqueue() did not add the right first element", my_queue.getFront(), 1);
    
    // test when queue is not empty
    my_queue.enqueue(2);
    my_queue.dequeue();
    
    assertSame("enqueue() did not add the right second element", my_queue.getFront(), 2);
  }
  
  /**
   * Test method for dequeue() when empty.
   */
  @Test(expected = UnderflowException.class)
  public void testDequeueEmpty()
  {
    my_queue.dequeue();
  }
  
  /**
   * Test method for dequeue().
   */
  @Test
  public void testDequeue()
  {
    my_queue.enqueue(1);
    my_queue.dequeue();
    
    assertTrue("dequeue() did not remove the element", my_queue.isEmpty());
  }
  
  /**
   * Test method for getFront() when empty.
   */
  @Test(expected = UnderflowException.class)
  public void testGetFrontEmpty()
  {
    my_queue.getFront();
  }
  
  /**
   * Test method for getFront().
   */
  @Test
  public void testGetFront()
  {
    my_queue.enqueue(1);
    
    assertSame("getFront() returned the wrong element", my_queue.getFront(), 1);
  }
  
  /**
   * Test method for makeEmpty().
   */
  @Test
  public void testMakeEmpty()
  {
    my_queue.enqueue(1);
    my_queue.makeEmpty();
    
    assertTrue("makeEmpty() did not empty the queue", my_queue.isEmpty());
  }
  
  /**
   * Test method for toString().
   */
  @Test
  public void testToString()
  { 
    my_queue.enqueue(1);
    my_queue.enqueue(2);
    my_queue.enqueue(1);

    assertEquals("toString() did not give correct string", MY_EXPECTED, my_queue.toString());
  }
  
  /**
   * Test method for enqueueAtFront().
   */
  @Test
  public void testEnqueueAtFront()
  {
    // test when queue is empty
    my_queue.enqueueAtFront(1);
    
    assertSame("enqueueAtFront() didn't add the right first element", my_queue.getFront(), 1);
    
    // test when queue is not empty
    my_queue.enqueueAtFront(2);
    my_queue.dequeue();
    
    assertSame("enqueueAtFront() didn't add the right second element", my_queue.getFront(), 1);
  }

}
