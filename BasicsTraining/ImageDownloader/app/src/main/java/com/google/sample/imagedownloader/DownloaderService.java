package com.google.sample.imagedownloader;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloaderService extends Intent {
    public DownloaderService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("DownloaderService", "Service Created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        Log.i("DownloaderService", "Service Started");
        String url = intent.getStringExtra("URL");
        Bitmap img = getImage(url);
        return START_NOT_STICKY;
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


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
