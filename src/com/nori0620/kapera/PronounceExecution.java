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
public class PronounceExecution extends Activity {
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
                  // インテント作成
                  Intent intent = new Intent(
                          RecognizerIntent.ACTION_RECOGNIZE_SPEECH); // ACTION_WEB_SEARCH
                  intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.US.toString() );                  
                  intent.putExtra(
                          RecognizerIntent.EXTRA_PROMPT,
                          "VoiceRecognitionTest"); // お好きな文字に変更できます
                  
                  // インテント発行
                  startActivityForResult(intent, REQUEST_CODE);
              } catch (ActivityNotFoundException e) {
                  // このインテントに応答できるアクティビティがインストールされていない場合
                  Toast.makeText(PronounceExecution.this,
                      "ActivityNotFoundException", Toast.LENGTH_LONG).show();
              }
    	  }
	    });
	}
	
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 自分が投げたインテントであれば応答する
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String resultsString = "";
            
            // 結果文字列リスト
            ArrayList<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            
            for (int i = 0; i< results.size(); i++) {
                // ここでは、文字列が複数あった場合に結合しています
                resultsString += results.get(i);
            }
            
            // トーストを使って結果を表示
            Toast.makeText(this, resultsString, Toast.LENGTH_LONG).show();
        }
        
        super.onActivityResult(requestCode, resultCode, data);
    }	
	
}
