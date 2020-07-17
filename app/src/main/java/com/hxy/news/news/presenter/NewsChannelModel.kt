package com.hxy.news.news.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hxy.core.utils.thread.ThreadUtils
import com.hxy.news.R
import com.hxy.news.activity.BaseApplication
import com.hxy.news.news.model.NewsChannelEntity
import java.util.*
import kotlin.collections.ArrayList

/**
 * desc:
 * @author tuoxie on 2020/7/16
 * E-Mail Address：tuoxie@gaoding.com
 **/
class NewsChannelModel : ViewModel() {
    private var mNewsChannel: MutableLiveData<ArrayList<NewsChannelEntity>>? = null

    fun getNewsChannel(): LiveData<ArrayList<NewsChannelEntity>> {
        if (mNewsChannel == null) {
            mNewsChannel = MutableLiveData<ArrayList<NewsChannelEntity>>()
        }
        return mNewsChannel!!
    }

    fun setNewsChannel(newsChannelModel: ArrayList<NewsChannelEntity>) {
        mNewsChannel!!.value = newsChannelModel
    }

    fun loadChannel() {
        ThreadUtils.runOnAnyThread {
            var mChannels = ArrayList<NewsChannelEntity>()
            var names = BaseApplication.appContext!!.resources.getStringArray(R.array.news_channel_name_static)
            var ids = BaseApplication.appContext!!.resources.getStringArray(R.array.news_channel_id_static)
            for (i in ids.indices) {
                mChannels.add(NewsChannelEntity(names.get(i), ids.get(i)))
            }
            ThreadUtils.runOnUiThread {
                setNewsChannel(mChannels)
            }
        }
    }

}