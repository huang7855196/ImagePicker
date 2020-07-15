package com.hxy.imagepicker.adapter

import android.content.Context
import com.hxy.core.recyclerview.adapter.ComRecyclerViewAdapter
import com.hxy.core.recyclerview.adapter.RecyclerViewHolder
import com.hxy.imagepicklib.model.MediaFile

/**
 * desc:
 * @author tuoxie on 2020/7/15
 * E-Mail Address：tuoxie@gaoding.com
 **/
class MediaAdapter constructor(context: Context, datas: ArrayList<MediaFile>, layoutId: Int) :
        ComRecyclerViewAdapter<MediaFile>(context, datas, layoutId) {

    override fun convert(holder: RecyclerViewHolder, item: MediaFile, position: Int) {

    }
}