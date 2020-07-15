package com.hxy.imagepicklib.adapter

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hxy.imagepicklib.R
import com.hxy.imagepicklib.model.MediaFile
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_media.*
import kotlinx.android.synthetic.main.item_media.view.*

/**
 * desc:
 * @author tuoxie on 2020/7/15
 * E-Mail Address：tuoxie@gaoding.com
 **/
class MediaFileAdapter(private var mDatas: ArrayList<MediaFile>) : RecyclerView.Adapter<MediaFileAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_media, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        if (mDatas != null) {
            return mDatas.size
        } else {
            return 0;
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        //Glide.with(mContext!!).asBitmap().centerCrop().dontAnimate().load(mDatas?.get(position)?.getPath()).into(holder.imageView!!)
        holder.bindForecast(mDatas.get(position))
    }

    fun setDatas(data: ArrayList<MediaFile>) {
        mDatas = data
        notifyDataSetChanged()
    }

    class MyHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindForecast(forecast: MediaFile) {
            with(forecast) {
                Glide.with(containerView.context).asBitmap().centerCrop().dontAnimate().load(forecast.getPath()).into(containerView.icon)
                containerView.icon.setImageBitmap(BitmapFactory.decodeFile(forecast.getPath()))
            }
        }
    }
}