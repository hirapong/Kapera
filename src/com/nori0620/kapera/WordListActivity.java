package com.nori0620.kapera;

import android.app.Activity;
import android.content.Intent;
//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
//import android.widget.Toast;

public class WordListActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        String[] data = {"ah","bet","but", "bat", "bot", "right", "light"}; 
        ArrayAdapter<String> arrayAdapter
            = new ArrayAdapter<String>( this, R.layout.plain_list_item, data ); 
        ListView list = (ListView)findViewById( R.id.WordList );
        list.setAdapter( arrayAdapter );
        list.setOnItemClickListener(new WordClickAdapter() );
    }
    
    class WordClickAdapter implements OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapter,View view, int position, long id) {
            TextView text = (TextView)view;
            Intent intent = new Intent( WordListActivity.this, PronounceExecutionActivity.class );
            intent.putExtra( "KAPERA_PRONOUNCE_WORD", text.getText() );
            startActivity( intent ); 
        }
    }  
    
}
