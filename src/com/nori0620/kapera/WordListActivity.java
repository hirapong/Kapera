package com.nori0620.kapera;

import android.app.Activity;
//import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WordListActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_word_list);
	    String[] data = {"but", "bat", "bot"}; 
	    ArrayAdapter<String> arrayAdapter
		= new ArrayAdapter<String>( this, R.layout.plain_list_item, data ); 
		ListView list = (ListView)findViewById( R.id.ListView01);
		list.setAdapter( arrayAdapter );
		
	}
	
}
