package com.google.sample.flickrsearch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by amandeep on 08/06/16.
 */
public class ImageAdapter extends BaseAdapter {
    Context context;
    ArrayList<FlickrItem> items;

    public ImageAdapter(Context context, ArrayList<FlickrItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View mainView;
        mainView = LayoutInflater.from(context).inflate(R.layout.cell, null);

        TextView tv = (TextView) mainView.findViewById(R.id.textView);
        final ImageView iv = (ImageView) mainView.findViewById(R.id.imageView);

        final Handler handler = new Handler();

        final FlickrItem item = (FlickrItem) getItem(i);

        tv.setText(item.title);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final Bitmap image = getImage(item.url);

                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        iv.setImageBitmap(image);
                    }
                };
                handler.post(r);
            }
        };

        Thread th = new Thread(runnable);
        th.start();
        return mainView;
    }

    private Bitmap getImage(String url) {
        Bitmap image = null;
        try {
            URL link = new URL(url);
            URLConnection connection = link.openConnection();
            InputStream stream = connection.getInputStream();
            image = BitmapFactory.decodeStream(stream);
            return image;
        } catch(MalformedURLException e) {
            Log.e("ImageAdapter", "Malformed URL exception: " + e.getMessage());
        } catch(IOException e) {
            Log.e("ImageAdapter", "IO exception: " + e.getMessage());

        }
        return null;
    }
}
