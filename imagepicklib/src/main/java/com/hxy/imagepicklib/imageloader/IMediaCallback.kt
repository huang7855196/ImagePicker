package com.hxy.imagepicklib.imageloader

import com.hxy.imagepicklib.model.MediaFile

/**
 * desc:
 * @author tuoxie on 2020/7/15
 * E-Mail Address：tuoxie@gaoding.com
 **/
interface IMediaCallback {
    fun onLoadSucceed(array: ArrayList<MediaFile>)
    fun onLoadFail()
}