package com.iccs.newgradleandroidapp.newapp.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.iccs.newgradleandroidapp.newapp.MainActivity;
import com.iccs.newgradleandroidapp.newapp.R;

/**
 * Created by Giannis on 16/5/2014.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity;
    private TextView mHelloWorldTextView;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();

        activity = getActivity();
        mHelloWorldTextView = (TextView) activity.findViewById(R.id.textView);
    }


    public void testTextView() throws Exception {

        assertNotNull(mHelloWorldTextView);

    }
}
