package com.google.sample.countryinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CountryListActivity extends AppCompatActivity {

    TextView countryListTextView;
    Set<String> countrySet = new HashSet<>();
    ArrayList<String> countryList = new ArrayList<>();
    boolean countrySetChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        countryListTextView = (TextView) findViewById(R.id.textView);

        ArrayList<String> newSavedList = null;
        if( savedInstanceState != null )
            newSavedList = savedInstanceState.getStringArrayList("COUNTRY_LIST");
        if (newSavedList != null ) {
            countryList = newSavedList;
            for( String countryName : countryList ) {
                countrySet.add(countryName.toUpperCase());
            }
            countrySetChanged = true;
        } else {
            countryListTextView.setText("");
        }
    }

    public void addNewCountry(View view) {
        Intent intent = new Intent(this, AddCountryActivity.class);
        startActivityForResult(intent, 101);
    }

    private String getStringFromArrayList(ArrayList<String> list) {
        StringBuffer buffer = new StringBuffer();
        for (String name : list ) {
            buffer.append(name);
            buffer.append("\n");
        }
        return buffer.toString();
    }

    private String getStringFromSet(Set<String> set) {
        StringBuffer buffer = new StringBuffer();
        for(String item : set ) {
            buffer.append(item + ", ");
        }
        buffer.append("\n");
        return buffer.toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK) {
            String countryName = data.getStringExtra("COUNTRY_NAME");
            if (countryName != null && countryName.length() != 0 ) {
                int initialSize = countrySet.size();
                countrySet.add(countryName.toUpperCase());
                if (countrySet.size() > initialSize) {
                    countrySetChanged = true;
                    countryList.add(countryName);
                }
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save the string array list
        outState.putStringArrayList("COUNTRY_LIST", countryList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (countrySetChanged) {
            countryListTextView.setText(getStringFromArrayList(countryList));
            countrySetChanged = false;
        }
    }
}
