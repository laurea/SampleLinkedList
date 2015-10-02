package com.atsistemas.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Main test for check doubly linked list
 */
public class SampleLinkedListSuitTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SampleLinkedListSuitTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
    	TestSuite testSuite = new TestSuite();
    	testSuite.addTestSuite(SampleLinkedListTest.class);
    	testSuite.addTestSuite(SampleIteratorLinkedListTest.class);
    	return testSuite;
    }
}