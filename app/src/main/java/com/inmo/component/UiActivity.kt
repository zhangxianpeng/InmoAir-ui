package com.inmo.component

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ui.*

class UiActivity : AppCompatActivity() {
    private val TAG = "UiActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui)
        initView()
    }

    private fun initView() {
        switch_btn.setOnSwitchListener { _, isOn ->
            Log.e(TAG, "isOn =$isOn")
        }
    }
}