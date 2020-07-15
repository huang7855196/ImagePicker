package com.hxy.core.baseactivity.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hxy.core.baseactivity.utils.ActivityStateHelper
import com.hxy.core.baseactivity.widget.TitleBar
import com.zhangyue.we.x2c.X2C

/**
 * desc:
 * @author hxy on 2020/7/14
 * E-Mail Address：yang7855196@163.com
 **/
abstract class BaseActivity : AppCompatActivity() {
    private lateinit var mActivityStateHelper: ActivityStateHelper;
    private lateinit var mTitleBar: TitleBar
    private val DefaultTitleLayoutId: Int = com.hxy.core.R.layout.layout_base_title_view

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var layoutId = getLayoutId()
        if (layoutId != 0) {
            mActivityStateHelper = ActivityStateHelper(this, layoutId)
            mActivityStateHelper.setUp()
        }
        initView()
    }

    fun setUpContentView(layoutResID: Int) {
        X2C.setContentView(this, layoutResID)
    }

    fun setTitleText(title: String) {
        getTitleBar().setTitleText(title)
    }

    fun getTitleBar(): TitleBar {
        ensureTitleBar()
        return mTitleBar!!
    }

    private fun ensureTitleBar() {
        mActivityStateHelper.setupTitleView(DefaultTitleLayoutId)
        mTitleBar = mActivityStateHelper.getTitleBar()
        mTitleBar.setLeftIconListener(View.OnClickListener {
            finish()
        })
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun initView()

}