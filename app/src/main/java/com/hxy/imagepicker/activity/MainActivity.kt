package com.hxy.imagepicker.activity

import android.content.Intent
import com.hxy.imagepicker.R
import com.hxy.imagepicker.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * desc:
 * @author hxy on 2020/7/14
 * E-Mail Address：yang7855196@163.com
 **/
class MainActivity : BaseActivity() {
    override fun initView() {
        setTitleText("首页")
        tv.setOnClickListener {
            startActivity(Intent(this, ImagePickerActivity::class.java))
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main;
    }
}