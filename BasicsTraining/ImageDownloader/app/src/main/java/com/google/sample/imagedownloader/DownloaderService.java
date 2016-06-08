package com.google.sample.imagedownloader;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloaderService extends IntentService {

    ResultReceiver imageReceiver;

    public DownloaderService() {
        super("DownloaderService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String url = intent.getStringExtra("URL");
        Bitmap image = getImage(url);
        imageReceiver = intent.getParcelableExtra("RECEIVER");
        if (url != null) {
            Log.i("DownloaderService", "Image Download");
            Bundle bundle = new Bundle();
            bundle.putParcelable("IMAGE",image);
            imageReceiver.send(101, bundle);
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


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
