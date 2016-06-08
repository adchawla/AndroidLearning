package com.google.sample.simplelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView cityListView;
    String[] cities;
    ArrayAdapter<String> citiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityListView = (ListView) findViewById(R.id.listView);
        cities = getResources().getStringArray(R.array.cities);

        // Using Android provided ArrayAdapter and list view
        citiesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, cities);

        // Using Android provided ArrayAdapter and our own implemented view
        citiesAdapter = new ArrayAdapter<String>(this, R.layout.row, R.id.textView, cities);

        //attach adapter ot the list view
        cityListView.setAdapter(citiesAdapter);
    }
}
