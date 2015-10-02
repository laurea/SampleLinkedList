package com.atsistemas.utils;


import com.atsistemas.utils.SampleLinkedList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Test for check doubly linked list
 */
public class SampleIteratorLinkedListTest 
    extends TestCase
{
    
    public void testListIterator() {
    	SampleLinkedList<String> list = new SampleLinkedList<String>();
        
        // Inicializedraor
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        
        SampleIteratorLinkedList<String> iterator = list.getIteratorLinkedList();
        while(iterator.hasNext()){
        	iterator.next();
        	assertTrue(true);
        }
        while(iterator.hasPrevius()){
        	iterator.previus();
        	assertTrue(true);
        }
        
        iterator.toStart();
        
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("D", iterator.next());
        assertFalse(iterator.hasNext());
        
        iterator.toEnd();
        assertEquals("D", iterator.previus());
        assertTrue(iterator.hasPrevius());
        assertEquals("C", iterator.previus());
        assertTrue(iterator.hasPrevius());
        assertEquals("B", iterator.previus());
        assertTrue(iterator.hasPrevius());
        assertEquals("A", iterator.previus());
        assertFalse(iterator.hasPrevius());
        
        iterator.toStart();
        
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasPrevius());
        assertEquals("C", iterator.previus());
        assertTrue(iterator.hasPrevius());
        assertEquals("B", iterator.previus());
        assertTrue(iterator.hasPrevius());
        assertEquals("A", iterator.previus());
        assertFalse(iterator.hasPrevius());
    }
    public void testCheckIteratorAddFirstBefore() {
    	SampleLinkedList<String> list = new SampleLinkedList<String>();
        
        // Inicializedraor
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        
        SampleIteratorLinkedList<String> iterator = list.getIteratorLinkedList();
        
        // Test insert after
        
        iterator.addBefore("00");
        
        assertEquals("A", iterator.previus());
        assertEquals("00", iterator.previus());
        
        iterator.toStart();
        assertTrue(iterator.hasNext());
        assertEquals("00", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("D", iterator.next());
        assertFalse(iterator.hasNext());        
    }
    public void testCheckIteratorAddBefore() {
    	SampleLinkedList<String> list = new SampleLinkedList<String>();
        
        // Inicializedraor
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        
        SampleIteratorLinkedList<String> iterator = list.getIteratorLinkedList();
        
        // Test insert after
        
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        
        iterator.previus();
        iterator.addBefore("AA");
        
        iterator.toStart();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("AA", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("D", iterator.next());
        assertFalse(iterator.hasNext());        
    }
    public void testCheckIteratorAddAfterInLast() {
    	SampleLinkedList<String> list = new SampleLinkedList<String>();
        
        // Inicializedraor
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        
        SampleIteratorLinkedList<String> iterator = list.getIteratorLinkedList();
        
        iterator.toEnd();
        
        iterator.addAfter("DD");
        
        assertTrue(iterator.hasNext());
        assertEquals("D", iterator.next());
        assertTrue(iterator.hasNext());     
        assertEquals("DD", iterator.next());
        
        iterator.toStart();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("D", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("DD", iterator.next());
        assertFalse(iterator.hasNext());
    }
    public void testCheckIteratorAddAfter() {
    	SampleLinkedList<String> list = new SampleLinkedList<String>();
        
        // Inicializedraor
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        
        SampleIteratorLinkedList<String> iterator = list.getIteratorLinkedList();
        
        // Test insert after
        
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        
        iterator.previus();
        iterator.addAfter("BB");
        
        iterator.toStart();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("BB", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("D", iterator.next());
        assertFalse(iterator.hasNext());        
    }
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SampleIteratorLinkedListTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SampleIteratorLinkedListTest.class );
    }
}