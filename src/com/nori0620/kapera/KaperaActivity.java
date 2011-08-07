package com.nori0620.kapera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
//import android.view.View;
//import android.view.View.OnClickListener;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu( menu );
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.mainmenu, menu );
        return true;
    } 

    public boolean onOptionsItemSelected(MenuItem item) {
    	switch ( item.getItemId() ) {
    		case R.id.menu_item_submenu: {
    		Intent intent = new Intent( KaperaActivity.this, KaperaSubActivity.class );
    			startActivity( intent );
    			return true;
    		}
    		case R.id.menu_item_pronounce: {
    		Intent intent = new Intent( KaperaActivity.this, PronounceExecution.class );
    			startActivity( intent );
    			return true;
    		}
    	}
    	return super.onOptionsItemSelected(item);
    }  
    

//    OnClickListener mBackListener = new OnClickListener() {
//        public void onClick(View v) {
//        	Log.d( "Kapera", "hello!! new paaause" );
//	    }
//    };

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu( menu );
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate( R.menu.mainmenu, menu );
//        return true;
//    }
    
    @Override
    protected void onPause() {
        super.onPause();
    }
    
    
}