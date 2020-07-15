package com.hxy.core.recyclerview.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zhangyue.we.x2c.X2C

/**
 * desc:
 * @author tuoxie on 2020/7/15
 * E-Mail Address：tuoxie@gaoding.com
 **/
abstract class ComRecyclerViewAdapter<T> : RecyclerView.Adapter<RecyclerViewHolder> {
    protected var mDatas: ArrayList<T>? = null
    protected var mContext: Context
    private var mLayoutId: Int = 0

    constructor(context: Context, datas: ArrayList<T>, layoutId: Int) {
        mDatas = datas
        mContext = context
        mLayoutId = layoutId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        var view = X2C.inflate(mContext, mLayoutId, parent,false)
        return RecyclerViewHolder(mContext, view)
    }

    override fun getItemCount(): Int {
        mDatas?.let {
            return it.size
        }
        return 0;
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        mDatas?.let { convert(holder, it.get(position), position) }
    }

    protected abstract fun convert(holder: RecyclerViewHolder, item: T, position: Int)

    fun setDatas(data: ArrayList<T>) {
        mDatas = data
        notifyDataSetChanged()
    }
}