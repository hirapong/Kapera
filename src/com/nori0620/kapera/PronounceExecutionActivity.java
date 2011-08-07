package com.nori0620.kapera;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class PronounceExecutionActivity extends Activity {
    private static final int REQUEST_CODE = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent received = getIntent();
        String word =  received.getStringExtra("KAPERA_PRONOUNCE_WORD");
        setTitle( word + "の発音チェック" );
        setContentView(R.layout.activity_pronounce_execution);
        Button button = (Button) findViewById( R.id.layout_pronounce_exec_buttton);
        Log.d("Kapera",button.toString());
        button.setOnClickListener(new View.OnClickListener() {
          private String word;
          public View.OnClickListener setWord( String word ){
              this.word = word;
              return this;
          }
          public void onClick(View v) {
              try {
                  Intent intent = new Intent(
                          RecognizerIntent.ACTION_RECOGNIZE_SPEECH); // ACTION_WEB_SEARCH
                  intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.US.toString() );                  
                  intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                  intent.putExtra("KAPERA_PRONOUNCE_WORD", this.word );
                  Log.d("Kapera", "onclick:" + this.word );
                  intent.putExtra(
                      RecognizerIntent.EXTRA_PROMPT,
                      "発音してみよう!"
                  );
                  
                  startActivityForResult(intent, REQUEST_CODE);
              } catch (ActivityNotFoundException e) {
                  Toast.makeText(PronounceExecutionActivity.this,
                      "ActivityNotFoundException", Toast.LENGTH_LONG).show();
              }
          }
        }.setWord(word));
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String resultsString = "";
            Intent wordIntent = getIntent(); // why can i get word from (Intent)data??
            String word =  wordIntent.getStringExtra("KAPERA_PRONOUNCE_WORD");
            ArrayList<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            for (int i = 0; i< results.size(); i++) {
                resultsString += results.get(i);
            }
            Intent intent = new Intent( PronounceExecutionActivity.this, PronounceResultActivity.class );
            intent.putExtra( "KAPERA_PRONOUNCE_WORD", word );
            intent.putExtra( "KAPERA_PRONOUNCE_INPUT", resultsString );
            startActivity(intent);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }	
	
}
