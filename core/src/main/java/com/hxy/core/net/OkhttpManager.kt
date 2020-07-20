package com.hxy.core.net

import android.util.Log
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * desc:
 * @author tuoxie on 2020/7/16
 * E-Mail Address：tuoxie@gaoding.com
 **/
class OkhttpManager {
    private var mOkHttpClient: OkHttpClient? = null

    companion object {
        val instance = Holder.instance
    }

    private constructor() {
        getOkhttp()
    }

    private object Holder {
        val instance = OkhttpManager()
    }

    private fun getOkhttp(): OkHttpClient {
        if (mOkHttpClient == null) {
            mOkHttpClient = OkHttpClient()
                    .newBuilder()
                    .readTimeout(8000, TimeUnit.MILLISECONDS)
                    .connectTimeout(8000, TimeUnit.MILLISECONDS)
                    .build()
        }
        return mOkHttpClient!!
    }

    fun startRequest(url: String,responseCallback: Callback) {
        val request: Request = Request.Builder()
                .url(url)
                .get() //默认就是GET请求，可以不写
                .build()
        getOkhttp().newCall(request).enqueue(responseCallback)
    }
}