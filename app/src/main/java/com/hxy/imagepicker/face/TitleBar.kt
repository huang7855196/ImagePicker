package com.hxy.imagepicker.face

import android.view.View

/**
 * desc:
 * @author tuoxie on 2020/7/14
 * E-Mail Address：tuoxie@gaoding.com
 **/
interface TitleBar {
    fun setTitleText(title: String?) //设置标题文字
    fun setLeftIconListener(listener: View.OnClickListener?) //设置返回键的点击事件
}