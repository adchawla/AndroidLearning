package com.example.amandeep.simpleintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get access to tehe launching intent
        Intent intent = getIntent();
        Log.i("intent", intent.getAction());
    }

    public void launchMain(View view) {
        //create an intent for launching the main activity
        //Explicit Intent
        Intent intent = new Intent(this, MainActivity.class);

        //send the intent to android activity manager
        startActivity(intent);
    }

    public void browseInternet(View view) {
        //Implicit Intent
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.google.com"));
        startActivity(intent);
    }

    public void dialNumber(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel::555-555-5555"));
        startActivity(intent);
    }
}
