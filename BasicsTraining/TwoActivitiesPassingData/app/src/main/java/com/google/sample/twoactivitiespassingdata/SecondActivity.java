package com.google.sample.twoactivitiespassingdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String data = intent.getStringExtra(MainActivity.USER_TEXT_KEY);
        TextView userView = (TextView) findViewById(R.id.textView2);
        if (data != null) {
            userView.setText(data);
        } else {
            userView.setText("Error: No Text Received");
        }
    }

    public void ok(View view) {
        finish();
    }
}
