package com.nori0620.kapera;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class PronounceExecutionActivity extends Activity implements  TextToSpeech.OnInitListener {
    private static final int REQUEST_CODE = 0;
    private TextToSpeech  textToSpeech;
    private String word;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.textToSpeech =  new TextToSpeech(this, this);
        Intent received = getIntent();
        this.word =  received.getStringExtra("KAPERA_PRONOUNCE_WORD");
        setTitle( this.word + "の発音チェック" );
        setContentView(R.layout.activity_pronounce_execution);
        ImageButton pronounceButton = (ImageButton) findViewById( R.id.layout_pronounce_exec_buttton);
        ImageButton hearButton = (ImageButton) findViewById( R.id.layout_pronounce_hear_buttton);
        
        pronounceButton.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
              try {
                  Intent intent = new Intent(
                          RecognizerIntent.ACTION_RECOGNIZE_SPEECH); // ACTION_WEB_SEARCH
                  intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.US.toString() );                  
                  intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                  intent.putExtra("KAPERA_PRONOUNCE_WORD", word );
                  Log.d("Kapera", "onclick:" + word );
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
        });
        
        hearButton.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                  try {
                      Toast.makeText(PronounceExecutionActivity.this, word, Toast.LENGTH_LONG).show();
                      textToSpeech.speak(word, TextToSpeech.QUEUE_FLUSH, null); 
                  } catch (ActivityNotFoundException e) {
                      Toast.makeText(PronounceExecutionActivity.this, "ActivityNotFoundException", Toast.LENGTH_LONG).show();
                  }
              }
            });
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String userInput = "";
            Intent wordIntent = getIntent(); // why can i get word from (Intent)data??
            String word =  wordIntent.getStringExtra("KAPERA_PRONOUNCE_WORD");
            ArrayList<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            for (int i = 0; i< results.size(); i++) {
                userInput += results.get(i);
            }
            Intent intent = new Intent( PronounceExecutionActivity.this, PronounceExecutionActivity.class );
            intent.putExtra( "KAPERA_PRONOUNCE_WORD", word );
            intent.putExtra( "KAPERA_PRONOUNCE_INPUT", userInput );
            this.word = word;
            this.renderReuslt(  userInput );
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS) {
            Locale locale = Locale.US;
            if(this.textToSpeech.isLanguageAvailable(locale) >= TextToSpeech.LANG_AVAILABLE) {
                this.textToSpeech.setLanguage(locale);
                this.textToSpeech.setSpeechRate( (float) 0.8);
            }
            else {
                Log.e("TTS", "Not support locale.");
            }
        }
        else {
            Log.e("TTS", "Init error.");
        } 
    }
    
    public void renderReuslt( String userInput ){
        View resultContainer = (View)findViewById( R.id.PronounceResultContainer); 
        resultContainer.setVisibility(View.VISIBLE);
        ImageView resultIcon  = (ImageView)findViewById( R.id.PronounceResultIcon  ); 
        TextView  resultTitle = (TextView) findViewById( R.id.PronounceResultTitle ); 
        TextView inputText = (TextView)findViewById( R.id.PronounceResultInput ); 
        if( userInput.equals(word) ){
            resultIcon.setImageDrawable( getResources().getDrawable( R.drawable.icon_correct ));
            resultTitle.setText( "正解" );
        }
        else{
            resultIcon.setImageDrawable( getResources().getDrawable( R.drawable.icon_incorrect));
            resultTitle.setText( "間違い" );
        }
        inputText.setText( userInput ); 
        Toast.makeText(PronounceExecutionActivity.this, "userInput:" + userInput, Toast.LENGTH_LONG).show();
    }
	
}
