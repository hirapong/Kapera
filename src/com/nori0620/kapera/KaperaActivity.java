package com.nori0620.kapera;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class KaperaActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.d( "Kapera", "hello!! new pause" );
    }
    
    
}