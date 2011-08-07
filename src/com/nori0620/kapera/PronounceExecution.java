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
                  // �C���e���g�쐬
                  Intent intent = new Intent(
                          RecognizerIntent.ACTION_RECOGNIZE_SPEECH); // ACTION_WEB_SEARCH
                  intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.US.toString() );                  
                  intent.putExtra(
                          RecognizerIntent.EXTRA_PROMPT,
                          "VoiceRecognitionTest"); // ���D���ȕ����ɕύX�ł��܂�
                  
                  // �C���e���g���s
                  startActivityForResult(intent, REQUEST_CODE);
              } catch (ActivityNotFoundException e) {
                  // ���̃C���e���g�ɉ����ł���A�N�e�B�r�e�B���C���X�g�[������Ă��Ȃ��ꍇ
                  Toast.makeText(PronounceExecution.this,
                      "ActivityNotFoundException", Toast.LENGTH_LONG).show();
              }
    	  }
	    });
	}
	
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // �������������C���e���g�ł���Ή�������
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String resultsString = "";
            
            // ���ʕ����񃊃X�g
            ArrayList<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            
            for (int i = 0; i< results.size(); i++) {
                // �����ł́A�����񂪕����������ꍇ�Ɍ������Ă��܂�
                resultsString += results.get(i);
            }
            
            // �g�[�X�g���g���Č��ʂ�\��
            Toast.makeText(this, resultsString, Toast.LENGTH_LONG).show();
        }
        
        super.onActivityResult(requestCode, resultCode, data);
    }	
	
}
