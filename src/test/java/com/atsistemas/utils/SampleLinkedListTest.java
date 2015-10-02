package com.atsistemas.utils;


import com.atsistemas.utils.SampleLinkedList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Test for check doubly linked list
 */
public class SampleLinkedListTest 
    extends TestCase
{
    /**
     * Check first element
     */
    public void testCheckFirst() {
        SampleLinkedList<String> list = new SampleLinkedList<String>();
        
        // Inicialized
        list.add("Z");
        list.add("B");
        list.add("C");
        
        // Check first element
        assertEquals("Z", list.get(0));
        assertEquals(0, list.indexOf("Z"));
        
        // Updated first element
        list.set(0, "A");

        assertEquals(0, list.indexOf("A"));
        assertEquals("A", list.get(0));
        
        assertEquals(-1, list.indexOf("Z"));
        
        // add first element
        list.add(0, "Z");
        
        assertEquals(list.get(1), "A");
        
        // Remove first element
        list.removeFirst();
        
        assertEquals(list.get(0), "A"); // Check the last first element.
        
        list.addFirst("Z");
        
        list.remove(0);
        
        assertEquals(list.get(0), "A");
    }
    /**
     * Check the last element
     */
    public void testCheckLast() {
        SampleLinkedList<String> list = new SampleLinkedList<String>();
        
        // Inicialized
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        
        // Check last
        assertEquals(list.getLast(), "E");
        assertEquals(list.get(list.size()-1), "E");
        
        // Check remove last
        list.removeLast();
        
        assertEquals("D", list.getLast());
        
         // Check remove last
        list.addLast("Z");
        
        // Updated last
        assertEquals("Z", list.getLast());
        
        list.add("ZZ");
        assertEquals(list.getLast(), "ZZ");
        
        list.addLast("ZZ");
        assertEquals(list.getLast(), "ZZ");
    }
    /**
     * Check the last central element
     */
    public void testCheckCentral() {
    	SampleLinkedList<String> list = new SampleLinkedList<String>();
        
        // Inicialized
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        
        assertEquals("C", list.get(2));
        
        // Update C
        list.set(2, "CC");
        
        assertEquals(list.get(2), "CC");
        
        // Remove CC and add C in 2
        list.remove(2);
        list.add(2, "C");
        
        assertEquals(list.get(2), "C");
        
        // Check size
        assertEquals(list.size(), 5);
    }
    /**
     * Check clear list and size
     */
    public void testClearList() {
    	SampleLinkedList<String> list = new SampleLinkedList<String>();
        
        // Inicialized
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        
        
        // Check size
        assertEquals(list.size(), 5);
        
        // Check is empty list is false
        assertEquals(list.isEmpty(), false);
        
        list.clear(); // Delete element
        
        // Check list is empty
        assertEquals(list.size(), 0);
        
        // Check list is empty
        assertEquals(list.isEmpty(), true);
        
    }
        
    /**
     * The ilegal access to element in array.
     */
    public void testOutOfBoudException() {
    	SampleLinkedList<String> list = new SampleLinkedList<String>();
    	
    	try{
    		list.get(5);
    		assertTrue(false);
    	}catch(RuntimeException e){
    		assertTrue(true);
    	}
    	
    	
    }
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SampleLinkedListTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SampleLinkedListTest.class );
    }
}