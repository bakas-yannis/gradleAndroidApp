package com.iccs.newgradleandroidapp.newapp.tests;

import com.iccs.newgradleandroidapp.newapp.SimpleAdder;
import junit.framework.TestCase;

/**
 * Created by Giannis on 19/5/2014.
 */
public class SimpleAdderTest extends TestCase{


    public void testSimpleAdder() throws Exception {

        int result = SimpleAdder.simpleAdd(1,4);
        assertEquals(5,result);
    }

    public void testSimpleAdder2() throws Exception {

        int result = SimpleAdder.simpleAdd(1,1);
        assertEquals(2,result);
    }

    public void testSimpleAdder3() throws Exception {

        int result = SimpleAdder.simpleAdd(1,1);
        assertEquals(2,result);
    }
}
