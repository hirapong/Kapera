package com.nori0620.kapera;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class KaperaActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    	setTitle( R.string.main_title );
    	getWindow().requestFeature(Window.FEATURE_LEFT_ICON);
        setContentView(R.layout.main);
    	getWindow().setFeatureDrawableResource( Window.FEATURE_LEFT_ICON, R.drawable.icon );
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.d( "Kapera", "hello!! new paaause" );
    }
    
    
}