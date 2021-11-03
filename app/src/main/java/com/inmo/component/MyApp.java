package com.inmo.component;

import android.app.Application;

import com.inmo.network.AndroidNetworking;
import com.inmo.network.interceptors.HttpLoggingInterceptor.Level;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.enableLogging(Level.BODY);
    }
}
