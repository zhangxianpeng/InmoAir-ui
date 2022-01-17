package com.inmo.component.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.inmo.component.NetWorkUtil
import com.inmo.component.R
import com.inmo.network.AndroidNetworking
import com.inmo.network.error.ANError
import com.inmo.network.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_network.*
import org.json.JSONObject

class NetworkActivity : AppCompatActivity() {
    private val TAG = "NetworkActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)
        checkNetwork()
        btn_get.setOnClickListener { doGet() }
        btn_post.setOnClickListener { doPost() }
    }

    private fun checkNetwork() {
        val url = "www.baidu.com"
        NetWorkUtil.isNetWorkAvailable(url, object : Comparable<Boolean> {
            override fun compareTo(available: Boolean): Int {
                if (available) {
                    Log.e(TAG, "正常")
                } else {
                    Log.e(TAG, "不正常")
                }
                return 0
            }
        })
    }

    private fun doGet() {
        AndroidNetworking.get("http://47.108.221.230:4041/im/version/update")
            .addQueryParameter("model", "X")
            .addQueryParameter("versionNumber", "1")
            .setTag("get Request")
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e(TAG, "onResponse = " + response.toString())
                }

                override fun onError(error: ANError) {
                    Log.e(TAG, "onError = " + error.message)
                }
            })
    }

    private fun doPost() {
        TODO("Not yet implemented")
    }

}