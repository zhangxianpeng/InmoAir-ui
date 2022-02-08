package com.inmo.component;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.inmo.component.demo.ConfirmCancelDialogTestActivity;
import com.inmo.component.demo.IconConfirmCancelDialogTestActivity;
import com.inmo.component.demo.LoadingViewActivity;
import com.inmo.component.demo.NetworkActivity;
import com.inmo.ui.utils.PopupToastUtil;

import java.util.Arrays;

public class MainActivity extends BaseActivity {

    ListView listView;
    String[] testItems = new String[]{"Air组件-带有Icon的确认取消弹框-带动效",
            "Air组件-没有Icon的确认取消弹框-带动效",
            "Air组件-LoadingView",
            "Air组件-网络请求",
            "Air组件-全局Toast样式"};

    TextView content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        content = findViewById(R.id.tv_content);
//        content.setText("选中照片已同步请前往手机端查看请");
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
                case 4:
//                    PopupToastUtil.showToast(MainActivity.this, ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0), "缓存已清理");
                    PopupToastUtil.showToast(MainActivity.this, ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0),
                            "缓存已清理");
                    PopupToastUtil.showToast(MainActivity.this, ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0),
                            "连接蓝牙选中照片同步前往手机查看");
                    break;
                default:
                    break;
            }
        });
    }
}
