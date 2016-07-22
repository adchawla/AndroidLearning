package com.google.sample.simplecontentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String CALL_LOGS_URL = "content://call_log/calls";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse(CALL_LOGS_URL);

        ContentResolver resolver = getContentResolver();

        // send the query to the content provider
        Cursor cursor = resolver.query(uri, null, null, null, null);

        if (cursor.getCount() > 0 ) {
            // by default cursor is at -1 position
            cursor.moveToFirst();

            int numberIndex = cursor.getColumnIndex(CallLog.Calls.NUMBER);

            do {
                String number = cursor.getString(numberIndex);
                Log.i("MainActivity", "Called number = " + number);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
    }
}
