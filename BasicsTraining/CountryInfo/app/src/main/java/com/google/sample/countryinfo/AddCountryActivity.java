package com.google.sample.countryinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddCountryActivity extends AppCompatActivity {

    EditText countryNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        countryNameEditText = (EditText) findViewById(R.id.editText);
    }

    public void done(View view) {
        // pass on the data to the
        String countryName = countryNameEditText.getText().toString();

        // Empty intent for data passing
        Intent intent = new Intent();
        intent.putExtra("COUNTRY_NAME", countryName);

        // send the intent to the parent activity
        setResult(RESULT_OK, intent);

        finish();
    }

    public void cancel(View view) {
        setResult(RESULT_CANCELED);

        finish();
    }

}
