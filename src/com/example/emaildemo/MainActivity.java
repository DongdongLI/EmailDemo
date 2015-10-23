package com.example.emaildemo;

import android.app.Activity;
import android.content.Intent;
import android.content.ReceiverCallNotAllowedException;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText recipient;
	EditText subject;
	EditText message;
	Button sendBtn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        recipient=(EditText)findViewById(R.id.recipient);
        subject=(EditText)findViewById(R.id.subject);
        message=(EditText)findViewById(R.id.message);
        sendBtn=(Button)findViewById(R.id.send);
        
        sendBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				String[] recipientAddr={recipient.getText().toString()};//address has to be in string[] in order to be received
				
				Intent intent=new Intent(Intent.ACTION_SEND);
				intent.setData(Uri.parse("mailto:"));
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_EMAIL, recipientAddr);
				intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
				intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
				
				startActivity(Intent.createChooser(intent, "Send Email..."));
				finish();
				
			}
		});
    }
}
