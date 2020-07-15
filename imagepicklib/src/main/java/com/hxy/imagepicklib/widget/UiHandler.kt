package com.hxy.imagepicklib.widget

import android.os.Handler
import android.os.Looper

/**
 * desc:
 * @author tuoxie on 2020/7/15
 * E-Mail Address：tuoxie@gaoding.com
 **/
object UiHandler {
    private var sHandler: Handler? = null

    private fun prepare() {
        if (sHandler == null) {
            sHandler = Handler(Looper.getMainLooper())
        }
    }


    fun post(r: Runnable) {
        prepare()
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r.run()
        } else {
            sHandler?.let {
                it.post(r)
            }
        }
    }

}