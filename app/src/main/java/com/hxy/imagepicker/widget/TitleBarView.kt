package com.hxy.imagepicker.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.hxy.imagepicker.face.TitleBar
import kotlinx.android.synthetic.main.layout_base_title_view.view.*


/**
 * desc:
 * @author hxy on 2020/7/14
 * E-Mail Address：yang7855196@163.com
 **/
class TitleBarView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        FrameLayout(context, attrs, defStyleAttr), TitleBar {

    override fun setTitleText(title: String?) {
        tv_title.text = title
    }

    override fun setLeftIconListener(listener: OnClickListener?) {
        iv_back.setOnClickListener(listener)
    }


}