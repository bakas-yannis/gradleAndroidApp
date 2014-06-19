package com.iccs.newgradleandroidapp.newapp.tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iccs.newgradleandroidapp.newapp.SimpleAdder;
import com.iccs.newgradleandroidapp.models.LoginResponse;
import com.iccs.newgradleandroidapp.requests.LoginRequest;
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

    public void  testGson() throws  Exception {

        Gson gson = new GsonBuilder().create();
        LoginResponse p = gson.fromJson("{ \"session\": \"0b2f1f3e-301c-4077-bb5d-4585e1a6ca63\" }", LoginResponse.class);

        boolean equal = p.getSession().equals("0b2f1f3e-301c-4077-bb5d-4585e1a6ca63");

        assertTrue(equal);
    }

    public void testLoginRequestGetUrl() throws Exception {

        String correctURL = "http://broadbit.com:8080/rest-api/identity.json/login?id=iccs-vehicle-one&password=11a92f75e0460e95218a6d85b76bc02b";

        String testedURL = LoginRequest.getURL("http://broadbit.com:8080/rest-api", "iccs-vehicle-one", "11a92f75e0460e95218a6d85b76bc02b");

        assertEquals(correctURL, testedURL);
    }
}
