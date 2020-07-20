package com.hxy.news.news.fragment

import android.util.Log
import com.google.gson.Gson
import com.hxy.core.base.base.BaseFragment
import com.hxy.core.net.OkhttpManager
import com.hxy.news.R
import com.hxy.news.news.model.NewsInfoEntity
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * desc:
 * @author tuoxie on 2020/7/17
 * E-Mail Address：tuoxie@gaoding.com
 **/
class NewFragment : BaseFragment() {
    override fun initView() {

    }

    override fun initData() {
        OkhttpManager.instance.startRequest("http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html",
                object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        Log.e("","")
                    }

                    override fun onResponse(call: Call, response: Response) {
                        var result = response.body.toString()
                        try {
                            var json = JSONObject(result)
                            var j= json.getJSONArray("T1348647909107")
                        } finally {

                        }
                    }

                })
    }

    fun initRecyclerView(it: ArrayList<NewsInfoEntity>) {
        Log.e("", "");
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_new
    }
}
