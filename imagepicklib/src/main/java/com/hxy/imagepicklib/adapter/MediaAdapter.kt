package com.hxy.imagepicklib.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.hxy.core.recyclerview.adapter.ComRecyclerViewAdapter
import com.hxy.core.recyclerview.adapter.RecyclerViewHolder
import com.hxy.imagepicklib.R
import com.hxy.imagepicklib.model.MediaFile
import kotlinx.android.synthetic.main.item_media.view.*

/**
 * desc:
 * @author tuoxie on 2020/7/15
 * E-Mail Address：tuoxie@gaoding.com
 **/
class MediaAdapter constructor(context: Context, datas: ArrayList<MediaFile>) :
        ComRecyclerViewAdapter<MediaFile>(context, datas, R.layout.item_media) {

    override fun convert(holder: RecyclerViewHolder, item: MediaFile, position: Int) {
        Glide.with(mContext).asBitmap().centerCrop().dontAnimate().load(item.getPath()).into(holder.itemView.icon)
    }
}