package com.hxy.core.baseactivity.widget

import android.view.View

/**
 * desc:
 * @author hxy on 2020/7/14
 * E-Mail Address：yang7855196@163.com
 **/
interface TitleBar {
    fun setTitleText(title: String?) //设置标题文字
    fun setLeftIconListener(listener: View.OnClickListener?) //设置返回键的点击事件
}