package com.google.sample.simplelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by amandeep on 07/06/16.
 */
public class CityAdapter extends BaseAdapter {

    String[] cities;
    Context context;

    public CityAdapter(String[] cities, Context context) {
        this.cities = cities;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cities.length;
    }

    @Override
    public Object getItem(int position) {
        return cities[position];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View mainView = null;

        if (view == null ) {
            // inflate layout
            mainView = LayoutInflater.from(context).inflate(R.layout.row, null);
        } else {
            mainView = view;
        }

        TextView textView = (TextView) mainView.findViewById(R.id.textView);
        textView.setText(cities[i]);

        return mainView;
    }
}
