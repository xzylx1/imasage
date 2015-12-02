package com.example.imasage;


import org.w3c.dom.Text;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {
	private EditText number;
	private EditText masage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = (EditText) findViewById(R.id.editText1);
        masage = (EditText) findViewById(R.id.editText2);
        Button send = (Button) findViewById(R.id.button1);
        send.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			String mnumber = number.getText().toString().trim();
			String mmasage = masage.getText().toString().trim();
	        if(TextUtils.isEmpty(mnumber)||TextUtils.isEmpty(mmasage)){
	        	Toast.makeText(this, "kong", 1).show();
	        	return;
	        }else{
	        	SmsManager smsmasager = SmsManager.getDefault();
	        	smsmasager.sendTextMessage(mnumber, null, mmasage, null, null);
	        }
			break;
		}
	}

}
