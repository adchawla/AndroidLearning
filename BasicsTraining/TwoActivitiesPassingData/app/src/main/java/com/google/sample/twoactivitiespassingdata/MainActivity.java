package com.google.sample.twoactivitiespassingdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userEditText;
    public static final String USER_TEXT_KEY="USER_TEXT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEditText = (EditText) findViewById(R.id.editText);
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View view = inflater.inflate(R.layout.main, null);
//        setContentView(view);
    }

    public void showText(View view) {
        String userText = userEditText.getText().toString();

        // Remember: Toast need a activity context, so it can't work on an application context.
//        Toast.makeText(this, userText, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, SecondActivity.class);
        // add some extras on the intent
        intent.putExtra(MainActivity.USER_TEXT_KEY, userText);
        startActivity(intent);
    }
}
