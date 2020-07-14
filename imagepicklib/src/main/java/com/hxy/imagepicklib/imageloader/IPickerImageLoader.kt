package com.hxy.imagepicklib.imageloader

import android.widget.ImageView

/**
 * desc:图片选择页面
 * @author hxy on 2020/7/14
 * E-Mail Address：yang7855196@163.com
 **/
interface IPickerImageLoader {
    fun loadImage(imageView: ImageView, path: String?)
    fun loadBigImage(imageView: ImageView, path: String?)
    fun clearMemoryCache()
}