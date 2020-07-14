package com.hxy.imagepicklib

import android.content.Context
import com.hxy.imagepicklib.config.PickerConfig
import com.hxy.imagepicklib.model.MediaFile
import com.hxy.imagepicklib.scanner.AbstractMediaScanner

/**
 * desc:
 * @author hxy on 2020/7/14
 * E-Mail Address：yang7855196@163.com
 **/
class PickerManager private constructor() {
    private lateinit var mScanners: Array<AbstractMediaScanner<MediaFile>>
    private var mPickerConfig: PickerConfig? = null

    companion object {
        var mInstance = Holder.INSTANCE
    }

    fun setPickerConfig(pickerConfig: PickerConfig?) {
        mPickerConfig = pickerConfig
        mPickerConfig?.let {
            initConfig(it)
        }
    }

    private fun initConfig(pickerConfig: PickerConfig) {

    }

    private object Holder {
        var INSTANCE = PickerManager()
    }

    fun loadMedia(context: Context) {

    }

}