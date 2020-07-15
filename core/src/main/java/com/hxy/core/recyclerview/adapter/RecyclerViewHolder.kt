package com.hxy.core.recyclerview.adapter

import android.content.Context
import android.util.SparseArray
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * desc:
 * @author tuoxie on 2020/7/15
 * E-Mail Address：tuoxie@gaoding.com
 **/
open class RecyclerViewHolder : RecyclerView.ViewHolder {
    private var mViews: SparseArray<View>? = null
    protected var mConvertView: View? = null
    protected var mContext: Context? = null

    constructor(context: Context?, itemView: View) : super(itemView) {
        mViews = SparseArray<View>()
        mConvertView = itemView
        mConvertView?.setTag(this)
        mContext = context
    }

    fun getView(viewId: Int): View? {
        var view = mViews?.get(viewId)
        if (view == null) {
            view = mConvertView?.findViewById(viewId)
            mViews?.put(viewId, view)
        }
        return view
    }

    fun setImage(resId: Int, path: Int) {
        var view = getView(resId)
        if (view != null && view is ImageView) {
            view.setImageResource(path)
        }
    }

    fun setImage(resId: Int, path: String?) {
        var view = getView(resId)
        if (view != null && view is ImageView) {
            mContext?.let { Glide.with(it).load(path).into(view) }
        }
    }

}