package com.example.amandeep.simpleintents;

import android.app.Application;
import android.util.Log;

/**
 * Created by amandeep on 06/06/16.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("MyApplication", "Application onCreate");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.i("MyApplication", "Application terminated");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);
    }

    @Override
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.unregisterActivityLifecycleCallbacks(callback);
    }
}
