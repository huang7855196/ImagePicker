package com.hxy.core.base.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zhangyue.we.x2c.X2C

/**
 * desc:
 * @author tuoxie on 2020/7/16
 * E-Mail Address：tuoxie@gaoding.com
 **/
abstract class BaseFragment : Fragment() {
    protected var mRootView: View? = null
    private var mIsDataLoad: Boolean = false;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mRootView = X2C.inflate(context, getLayoutResource(), container, false)
        }
        initView()
        return mRootView
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isAdded && !mIsDataLoad) {
            initData()
            mIsDataLoad = true
        }
    }

    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract fun getLayoutResource(): Int
}