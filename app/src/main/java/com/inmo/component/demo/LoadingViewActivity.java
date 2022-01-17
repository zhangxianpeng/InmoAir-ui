package com.inmo.component.demo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.inmo.component.R;
import com.inmo.ui.loading.LoadingView;

public class LoadingViewActivity extends AppCompatActivity {

    LoadingView loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_view);
        loadingView = findViewById(R.id.loadingView);
        loadingView.showLoadingView();
    }
}