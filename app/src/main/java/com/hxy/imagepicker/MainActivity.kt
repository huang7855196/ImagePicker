package com.hxy.imagepicker

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zhangyue.we.x2c.X2C
import kotlinx.android.synthetic.main.activity_main.*

/**
 * desc:
 * @author tuoxie on 2020/7/14
 * E-Mail Address：tuoxie@gaoding.com
 **/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        X2C.setContentView(this, R.layout.activity_main)
        tv.setOnClickListener {
            startActivity(Intent(this, ImagePickerActivity::class.java))
        }
    }
}