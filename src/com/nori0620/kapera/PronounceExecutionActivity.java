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
        setContentView(R.layout.activity_pronounce_execution);
        Button button = (Button) findViewById( R.id.layout_pronounce_exec_buttton);
        Log.d("Kapera",button.toString());
        button.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
              try {
                  Intent intent = new Intent(
                          RecognizerIntent.ACTION_RECOGNIZE_SPEECH); // ACTION_WEB_SEARCH
                  intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.US.toString() );                  
                  intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                  intent.putExtra(
                          RecognizerIntent.EXTRA_PROMPT,
                          "VoiceRecognitionTest"); // Ç®çDÇ´Ç»ï∂éöÇ…ïœçXÇ≈Ç´Ç‹Ç∑
                  
                  startActivityForResult(intent, REQUEST_CODE);
              } catch (ActivityNotFoundException e) {
                  Toast.makeText(PronounceExecutionActivity.this,
                      "ActivityNotFoundException", Toast.LENGTH_LONG).show();
              }
          }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String resultsString = "";
            ArrayList<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            for (int i = 0; i< results.size(); i++) {
                resultsString += results.get(i);
            }
            Toast.makeText(this, resultsString, Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }	
	
}
