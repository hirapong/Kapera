package com.nori0620.kapera;

import android.app.Activity;
import android.os.Bundle;

public class KaperaSubActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    // 画面の XML を指定する
	    setContentView(R.layout.kapera_sub_activity);
	}
}
