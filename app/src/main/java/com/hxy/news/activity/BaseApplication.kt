package com.hxy.news.activity

import android.app.Application
import android.content.Context
import android.content.res.Resources

/**
 * desc:
 * @author tuoxie on 2020/7/16
 * E-Mail Address：tuoxie@gaoding.com
 **/
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        baseApplication = this
    }

    companion object {
        private var baseApplication: BaseApplication? = null
        val appContext: Context?
            get() = baseApplication

        val appResources: Resources
            get() = baseApplication!!.resources
    }
}