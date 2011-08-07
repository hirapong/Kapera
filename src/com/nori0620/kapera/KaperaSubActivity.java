package com.nori0620.kapera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class KaperaSubActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    // ‰æ–Ê‚Ì XML ‚ðŽw’è‚·‚é
	    setContentView(R.layout.kapera_sub_activity);
	    String[] data = {"HT-03A", "Xperia", "NexusOne", "Droid"}; 
	    ArrayAdapter<String> arrayAdapter
		= new ArrayAdapter<String>( this, R.layout.plain_list_item, data ); 
		ListView list = (ListView)findViewById( R.id.ListView01);
		list.setAdapter( arrayAdapter );
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch ( item.getItemId() )
		{
			case R.id.menu_item_submenu:
			{
				Intent intent = new Intent( this, KaperaActivity.class );
				startActivity( intent );
				return true;
			}
		}
		return super.onOptionsItemSelected(item);
	}	
	
}
