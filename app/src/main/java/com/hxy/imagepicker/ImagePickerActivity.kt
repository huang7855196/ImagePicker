package com.hxy.imagepicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhangyue.we.x2c.X2C

/**
 * desc:
 * @author tuoxie on 2020/7/14
 * E-Mail Address：tuoxie@gaoding.com
 **/
class ImagePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        X2C.setContentView(this, R.layout.activity_image_picker)
    }
}