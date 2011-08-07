package com.nori0620.kapera;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class PronounceExecution extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_pronounce_execution);
	    Button button = (Button) findViewById( R.id.layout_pronounce_exec_buttton);
	    Log.d("Kapera",button.toString());
	    button.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
    		  Toast.makeText(PronounceExecution.this,
                      "HelloClicked", Toast.LENGTH_LONG).show();
    	  }
	    });
	}
}
