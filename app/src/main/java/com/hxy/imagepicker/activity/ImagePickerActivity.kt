package com.hxy.imagepicker.activity

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.hxy.imagepicker.R
import com.hxy.imagepicker.base.BaseActivity
import com.hxy.imagepicklib.PickerManager
import com.hxy.imagepicklib.config.PickerConfig
import com.hxy.imagepicklib.imageloader.IMediaCallback
import com.hxy.imagepicklib.model.MediaFile
import kotlinx.android.synthetic.main.activity_image_picker.*

/**
 * desc:图片选择页面
 * @author hxy on 2020/7/14
 * E-Mail Address：yang7855196@163.com
 **/
class ImagePickerActivity : BaseActivity() {

    override fun initView() {
        setTitleText("选择图片")
        initRecycler();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED) {
            startScannerTask()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE), 100)
        }
    }

    private fun initRecycler() {
        recyclerview.adapter
    }

    private fun startScannerTask() {
        PickerManager.mInstance.setPickerConfig(PickerConfig.Builder.build())
        PickerManager.mInstance.loadMedia(this, MediaCallback())
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_image_picker;
    }

    inner class MediaCallback : IMediaCallback {
        override fun onLoadSucceed(array: ArrayList<MediaFile>) {
            Toast.makeText(this@ImagePickerActivity, "加载完成", Toast.LENGTH_SHORT).show()
        }

        override fun onLoadFail() {

        }

    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100) {
            if (grantResults.size >= 1) {
                //相机权限
                val cameraResult = grantResults[0]
                //sd卡权限
                val sdResult = grantResults[1]
                //拍照权限
                val cameraGranted = cameraResult == PackageManager.PERMISSION_GRANTED
                //拍照权限
                val sdGranted = sdResult == PackageManager.PERMISSION_GRANTED
                if (cameraGranted && sdGranted) {
                    //具有拍照权限，sd卡权限，开始扫描任务
                    startScannerTask()
                } else {
                    //没有权限
                    Toast.makeText(this@ImagePickerActivity,
                            "没有权限",
                            Toast.LENGTH_SHORT)
                            .show()
                }
            }
        }
    }

}