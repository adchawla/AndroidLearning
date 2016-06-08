package com.google.sample.imagedownloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    Handler mainThreadHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        mainThreadHandler = new Handler();
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
            Log.e("MainActivity", "Malformed URL exception: " + e.getMessage());
        } catch(IOException e) {
            Log.e("MainActivity", "IO exception: " + e.getMessage());

        }
        return null;
    }

    public void downloadImage(View view) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final Bitmap image = getImage("https://img.new.livestream.com/accounts/00000000001a662c/1dfeaf60-4111-4c2b-b3c6-9a3026396a56.jpg");
                if (image!=null) {
                    Log.i("MainActivity", "Image download complete");
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(image);
                        }
                    };
                    mainThreadHandler.post(r);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }
}
