package com.hxy.imagepacker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhangyue.we.x2c.X2C

/**
 * desc:
 * @author tuoxie on 2020/7/14
 * E-Mail Address：tuoxie@gaoding.com
 **/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        X2C.setContentView(this, R.layout.activity_main)
    }
}