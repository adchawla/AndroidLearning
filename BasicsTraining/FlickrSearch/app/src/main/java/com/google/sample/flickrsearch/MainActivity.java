package com.google.sample.flickrsearch;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView imagesGV;
    ArrayList<FlickrItem> items = new ArrayList<>();
    ImageAdapter adapter;

    class FlickrDownloaderTask extends AsyncTask<String, Void, ArrayList<FlickrItem>> {

        @Override
        protected ArrayList<FlickrItem> doInBackground(String... strings) {
            FlickrGetter flickrGetter = new FlickrGetter();
            ArrayList<FlickrItem> items = flickrGetter.fetchItems();
            Log.i("FlickrDownloaderTask", items.toString());
            return items;
        }

        @Override
        protected void onPostExecute(ArrayList<FlickrItem> flickrItems) {
            super.onPostExecute(flickrItems);
            if (flickrItems != null) {
                items.clear();
                items.addAll(flickrItems);
                adapter.notifyDataSetChanged();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagesGV = (GridView) findViewById(R.id.gridView);
        adapter = new ImageAdapter(this, items);
        imagesGV.setAdapter(adapter);
    }

    public void fetchImages(View view) {
        FlickrDownloaderTask task = new FlickrDownloaderTask();
        task.execute();
    }
}
