package com.google.sample.imagedownloader;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivityService extends AppCompatActivity {

    ImageView imageView;

    class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("MBR::onReceive", "called");
            Bitmap image = intent.getParcelableExtra("com.amandeep.IMAGE");
            if (image != null ) {
                Log.i("MBR::onReceive", "image received");
                imageView.setImageBitmap(image);
            }
        }
    }

    MyBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        receiver = new MyBroadcastReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.google.sample.imagedownloader.UPDATE_UI");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void downloadImage(View view) {
        Intent intent = new Intent(this, DownloaderService.class);
        intent.putExtra("URL", "http://batslive.pwnet.org/img/bat.png");
        startService(intent);
    }

    public void auto(View view) {
        AlarmManager alMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, DownloaderService.class);
        intent.putExtra("URL",
                "http://batslive.pwnet.org/img/bat.png");

        PendingIntent pendingIntent
                = PendingIntent.getService(this, 1001, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        alMgr.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), 30000, pendingIntent);
    }
}
