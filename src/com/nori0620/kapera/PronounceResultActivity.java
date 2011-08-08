package com.nori0620.kapera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class PronounceResultActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent received = getIntent();
        String word  =  received.getStringExtra("KAPERA_PRONOUNCE_WORD");
        Log.d("Kapera", "onCreate of result" + word ); 
        String input =  received.getStringExtra("KAPERA_PRONOUNCE_INPUT");
        setTitle( word + "ÇÃî≠âπåãâ " );
        setContentView(R.layout.activity_pronounce_result);
        
        ImageView resultIcon  = (ImageView)findViewById( R.id.PronounceResultIcon  ); 
        TextView  resultTitle = (TextView) findViewById( R.id.PronounceResultTitle ); 
        TextView inputText = (TextView)findViewById( R.id.PronounceResultInput ); 
        if( input.equals(word) ){
            resultIcon.setImageDrawable( getResources().getDrawable( R.drawable.icon_correct ));
            resultTitle.setText( "ê≥â" );
        }
        else{
            resultIcon.setImageDrawable( getResources().getDrawable( R.drawable.icon_incorrect));
            resultTitle.setText( "ä‘à·Ç¢" );
        }
        inputText.setText( input );
        
        Toast.makeText(this, input, Toast.LENGTH_LONG).show();
    }
    
}
