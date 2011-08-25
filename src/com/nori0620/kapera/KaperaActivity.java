package com.nori0620.kapera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
//import android.view.View;
//import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class KaperaActivity extends Activity {
    public Activity ownActivity = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.ownActivity = this;
        super.onCreate(savedInstanceState);
    	setTitle( R.string.main_title );
    	getWindow().requestFeature(Window.FEATURE_LEFT_ICON);
        setContentView(R.layout.main);
    	getWindow().setFeatureDrawableResource( Window.FEATURE_LEFT_ICON, R.drawable.icon );
    	
        Button pronounceButton = (Button) findViewById( R.id.button_select_word);
        pronounceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                  Intent intent = new Intent( KaperaActivity.this, WordListActivity.class );
                  startActivity( intent );
            }
        });
    	
    	
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
            case R.id.menu_item_wordlist: {
                Intent intent = new Intent( KaperaActivity.this, WordListActivity.class );
                startActivity( intent );
                return true;
            }
            case R.id.menu_item_pronounce: {
                Intent intent = new Intent( KaperaActivity.this, PronounceExecutionActivity.class );
                startActivity( intent );
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }  

    @Override
    protected void onPause() {
        super.onPause();
    }
    
    
}