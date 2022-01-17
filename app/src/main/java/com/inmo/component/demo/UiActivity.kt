package com.inmo.component.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.inmo.component.R
import kotlinx.android.synthetic.main.activity_ui.*

class UiActivity : AppCompatActivity() {
    private val TAG = "UiActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui)
        initView()
    }

    private fun initView() {

    }
}