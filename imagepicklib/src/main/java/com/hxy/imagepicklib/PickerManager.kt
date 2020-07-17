package com.hxy.imagepicklib

import android.content.Context
import com.hxy.imagepicklib.config.PickerConfig
import com.hxy.imagepicklib.imageloader.IMediaCallback
import com.hxy.imagepicklib.model.MediaFile
import com.hxy.imagepicklib.scanner.AbstractMediaScanner
import com.hxy.imagepicklib.scanner.ImageScanner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * desc:
 * @author hxy on 2020/7/14
 * E-Mail Address：yang7855196@163.com
 **/
class PickerManager private constructor() {
    private var mScanners: ArrayList<AbstractMediaScanner<MediaFile>> = ArrayList()
    private var mMediaFiles: ArrayList<MediaFile> = ArrayList()
    var mPickerConfig: PickerConfig? = null

    companion object {
        val mInstance = Holder.INSTANCE
    }

    private object Holder {
        val INSTANCE = PickerManager()
    }

    fun setPickerConfig(pickerConfig: PickerConfig?) {
        mPickerConfig = pickerConfig
        mPickerConfig?.let {
            initConfig(it)
        }
    }

    private fun initConfig(pickerConfig: PickerConfig) {
        mScanners.clear()
        if (pickerConfig.getCustomScanner() != null) {
            mScanners.add(pickerConfig.getCustomScanner()!!)
        } else {
            if (pickerConfig.isShowImage()) {
                mScanners.add(ImageScanner())
            }
//            if (pickerConfig.isShowVideo()) {
//                mScanners.add(VideoScanner(pickerConfig.getMinTime()))
//            }
        }
    }

    fun loadMedia(context: Context, callback: IMediaCallback) {

        GlobalScope.launch(Dispatchers.IO) {
            for (scanner in mScanners) {
                val queryMedia = scanner.queryMedia(context) as ArrayList
                mMediaFiles.addAll(queryMedia)
            }
            launch(Dispatchers.Main) {
                callback.onLoadSucceed(mMediaFiles)
            }
        }
    }
}