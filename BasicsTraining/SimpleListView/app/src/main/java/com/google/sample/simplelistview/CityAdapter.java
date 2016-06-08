package com.google.sample.simplelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by amandeep on 07/06/16.
 */
public class CityAdapter extends BaseAdapter {

    String[] cities;
    Context context;

    // So that reference of outer class is not kept in the memory.
    // static class varialbes don't have access to the class variables.
    static class ViewHolder {
        ImageView iv;
        TextView tv;
    }

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
        String cityName = (String) getItem(i);
        TextView textView = null;
        ImageView imageView = null;
        if (view == null ) {
            // inflate layout
            mainView = LayoutInflater.from(context).inflate(R.layout.row, null);
            ViewHolder mainViewHolder = new ViewHolder();
            mainViewHolder.tv = (TextView) mainView.findViewById(R.id.textView);
            mainViewHolder.iv = (ImageView) mainView.findViewById(R.id.imageView);

            // attach the view holder to the view
            mainView.setTag(mainViewHolder);
            textView = mainViewHolder.tv;
            imageView = mainViewHolder.iv;
        } else {
            mainView = view;
            ViewHolder viewHolder = (ViewHolder) mainView.getTag();
            textView = viewHolder.tv;
            imageView = viewHolder.iv;
        }

        textView.setText(cityName);
        imageView.setImageResource(R.drawable.kings_xi);

        return mainView;
    }
}
