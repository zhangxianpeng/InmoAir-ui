package com.inmo.component;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.inmo.component.demo.ConfirmCancelDialogTestActivity;
import com.inmo.component.demo.IconConfirmCancelDialogTestActivity;
import com.inmo.component.demo.LoadingViewActivity;
import com.inmo.component.demo.NetworkActivity;

import java.util.Arrays;

public class MainActivity extends BaseActivity {

    ListView listView;
    String[] testItems = new String[]{"Air组件-带有Icon的确认取消弹框-带动效", "Air组件-没有Icon的确认取消弹框-带动效", "Air组件-LoadingView", "Air组件-网络请求"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_listview, R.id.tv_test_name, Arrays.asList(testItems));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            switch (i) {
                case 0:
                    startActivity(new Intent(MainActivity.this, IconConfirmCancelDialogTestActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(MainActivity.this, ConfirmCancelDialogTestActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(MainActivity.this, LoadingViewActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(MainActivity.this, NetworkActivity.class));
                    break;
                default:
                    break;
            }
        });
    }
}
