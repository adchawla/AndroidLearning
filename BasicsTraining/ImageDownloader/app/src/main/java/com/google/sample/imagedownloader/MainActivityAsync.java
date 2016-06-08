package com.google.sample.imagedownloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivityAsync extends AppCompatActivity {

    ImageView imageView;

    class ImageDownloaderTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            String link = strings[0];
            Bitmap image = getImage(link);
            if (image != null) {
                Log.i("Image Downloader Task", "Image Downloaded successfully");
            }
            return image;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if ( bitmap != null ) {
                imageView.setImageBitmap(bitmap);
            }
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
    }


    public void downloadImage(View view) {
        ImageDownloaderTask task = new ImageDownloaderTask();
        task.execute("https://img.new.livestream.com/accounts/00000000001a662c/1dfeaf60-4111-4c2b-b3c6-9a3026396a56.jpg");
    }
}
