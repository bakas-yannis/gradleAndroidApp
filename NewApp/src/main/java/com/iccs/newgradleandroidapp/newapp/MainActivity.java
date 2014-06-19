package com.iccs.newgradleandroidapp.newapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.iccs.newgradleandroidapp.interfaces.LoginRequestListener;
import com.iccs.newgradleandroidapp.models.LoginResponse;
import com.iccs.newgradleandroidapp.utils.ApplicationController;
import com.iccs.newgradleandroidapp.utils.ServerComunication;
import com.iccs.newgradleandroidapp.utils.VolleyErrorHelper;


public class MainActivity extends ActionBarActivity implements LoginRequestListener{

    private static final String TAG = "MainActivity";
    ServerComunication serverComunication = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");

        serverComunication = new ServerComunication();

        serverComunication.setLoginListener(this);

        serverComunication.login();

    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();

        ApplicationController.getInstance().cancelPendingRequests("LOGIN");

        Log.d(TAG, "onDestroy");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResponse(LoginResponse loginResponse) {
        Toast.makeText(getApplicationContext(), loginResponse.getSession(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(VolleyError error) {
        Toast.makeText(getApplicationContext(), VolleyErrorHelper.getMessage(error, getApplicationContext()), Toast.LENGTH_LONG).show();
    }
}
