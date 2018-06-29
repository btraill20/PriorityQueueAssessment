package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

//@param <T>
public class SortedArrayPriorityQueueTest<T> extends PriorityQueueTest<T> {
    
    public SortedArrayPriorityQueueTest() {
    }

    @Before
    @Override
    public void setUp() 
    {
        //the 8 in the curly brackets is to set the size of the array.
        instance = new SortedArrayPriorityQueue<>(8);
    }

     //Test of add method, of class PriorityQueue.

    @Test
    public void testQueueSize() throws Exception {
        System.out.println("QueueSize");
        int item = 0;
        instance.add(item, 1);
        instance.add(item, 2);
        instance.add(item, 3);
        String expResult = "[1, 2, 3]";
        System.out.println("Expected result: " +expResult);
        String result = instance.toString();
        System.out.println("Actual result: " +result);
        assertEquals(expResult, result);
    }
    
}
