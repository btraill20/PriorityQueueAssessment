/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ben
 */
public class SortedlistTest extends PriorityQueueTest {
    
    public SortedlistTest() 
    {
        instance = new Sortedlist<>(8);
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of add method, of class Sortedlist.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Object item = null;
        int priority = 0;
        Sortedlist instance = null;
        instance.add(item, priority);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of head method, of class Sortedlist.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        Sortedlist instance = null;
        Object expResult = null;
        Object result = instance.head();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Sortedlist.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Sortedlist instance = null;
        instance.remove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Sortedlist.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Sortedlist instance = null;
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Sortedlist.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Sortedlist instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
