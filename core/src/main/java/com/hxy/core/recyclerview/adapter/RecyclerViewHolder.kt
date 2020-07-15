package com.hxy.core.recyclerview.adapter

import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * desc:
 * @author tuoxie on 2020/7/15
 * E-Mail Address：tuoxie@gaoding.com
 **/
open class RecyclerViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var mViews: SparseArray<View>? = null
    protected var mConvertView: View? = null

    init {
        mViews = SparseArray<View>()
        mConvertView = itemView
        mConvertView?.setTag(this)
    }

    fun getView(viewId: Int): View? {
        var view = mViews?.get(viewId)
        if (view == null) {
            view = mConvertView?.findViewById(viewId)
            mViews?.put(viewId, view)
        }
        return view
    }

}