package com.olkunmustafa.prettypreloaderssample;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by olkunmustafa on 30/12/2016.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);
    }
}
