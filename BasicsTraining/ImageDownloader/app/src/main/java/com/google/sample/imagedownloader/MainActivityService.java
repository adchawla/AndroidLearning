package com.google.sample.imagedownloader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivityService extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
    }


    public void downloadImage(View view) {
        Intent intent = new Intent(this, DownloaderService.class);
        intent.putExtra("URL", "https://img.new.livestream.com/accounts/00000000001a662c/1dfeaf60-4111-4c2b-b3c6-9a3026396a56.jpg");
        startService(intent);
    }
}
