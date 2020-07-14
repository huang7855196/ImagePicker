package com.hxy.imagepicker.activity

import com.hxy.imagepicker.R
import com.hxy.imagepicker.base.BaseActivity
import com.hxy.imagepicklib.PickerManager

/**
 * desc:图片选择页面
 * @author hxy on 2020/7/14
 * E-Mail Address：yang7855196@163.com
 **/
class ImagePickerActivity : BaseActivity() {

    override fun initView() {
        setTitleText("选择图片")
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_image_picker;
    }

}