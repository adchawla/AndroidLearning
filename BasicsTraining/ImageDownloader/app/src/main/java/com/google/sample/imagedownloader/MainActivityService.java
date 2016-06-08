package com.google.sample.imagedownloader;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivityService extends AppCompatActivity {

    ImageView imageView;

    ResultReceiver imageRecieiver = new ResultReceiver(new Handler()) {
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            Bitmap image = resultData.getParcelable("IMAGE");
            imageView.setImageBitmap((image));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
    }


    public void downloadImage(View view) {
        Intent intent = new Intent(this, DownloaderService.class);
        intent.putExtra("RECEIVER", imageRecieiver);
        intent.putExtra("URL", "https://img.new.livestream.com/accounts/00000000001a662c/1dfeaf60-4111-4c2b-b3c6-9a3026396a56.jpg");
        startService(intent);
    }
}
