package com.hxy.core.base.utils

import android.view.View
import android.view.ViewStub
import com.hxy.core.R
import com.hxy.core.base.base.BaseActivity
import com.hxy.core.base.widget.TitleBar
import kotlinx.android.synthetic.main.activity_base_content.*

/**
 * desc:
 * @author hxy on 2020/7/14
 * E-Mail Address：yang7855196@163.com
 **/
class ActivityStateHelper constructor(activity: BaseActivity, contentLayoutRes: Int) {
    private var mContentLayoutRes: Int = contentLayoutRes
    private var mActivity: BaseActivity = activity
    private var mView: View? = null
    private var mTitleView: View? = null

    fun setUp(): View {
        if (mView == null) {
            mActivity.setUpContentView(R.layout.activity_base_content)
            if (mActivity.lcee_main != null) {
                mView = mActivity.lcee_main
            }
            setupContentView()
        }
        return mView!!
    }

    /**
     * 设置内容部分
     */
    private fun setupContentView() {
        val contentStub = mActivity.lcee_stub_content as ViewStub
        if (contentStub != null) {
            contentStub.layoutResource = mContentLayoutRes
            val inflateView = contentStub.inflate()
            val background = inflateView.background
            if (background != null) {
                inflateView.background = null
                mView?.background = background
            }
        }
    }

    fun getTitleBar(): TitleBar {
        return mTitleView as TitleBar
    }

    /**
     * 设置标题部分
     */
    fun setupTitleView(titleLayoutRes: Int): View {
        if (mTitleView != null) {
            return mTitleView!!
        }
        val titleStub = mActivity.lcee_stub_titlebar as ViewStub;
        if (titleStub != null) {
            titleStub.layoutResource = titleLayoutRes;
            mTitleView = titleStub.inflate()
        }
        return mTitleView!!
    }
}