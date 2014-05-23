package com.iccs.newgradleandroidapp.newapp.tests;

import android.test.ActivityInstrumentationTestCase2;
import com.iccs.newgradleandroidapp.newapp.MainActivity;
import com.robotium.solo.Solo;

/**
 * Created by giannis on 5/22/14.
 */
public class MainActivityRobotiumTest extends ActivityInstrumentationTestCase2<MainActivity>{

    private Solo solo;

    public MainActivityRobotiumTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        //super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testTextView() throws Exception {

        //assertEquals(true, solo.searchText("Hello world!"));
        //assertTrue(solo.waitForText("Hello world!"));
        solo.assertCurrentActivity("wrong activity", MainActivity.class);

    }

    @Override
    public void tearDown() throws Exception {
        //super.tearDown();
        solo.finishOpenedActivities();
    }
}
