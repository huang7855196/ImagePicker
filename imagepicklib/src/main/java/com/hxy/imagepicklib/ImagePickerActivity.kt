package com.hxy.imagepicklib

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.hxy.core.baseactivity.base.BaseActivity
import com.hxy.imagepicklib.adapter.MediaAdapter
import com.hxy.imagepicklib.adapter.MediaFileAdapter
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
    private var mAdapter: MediaAdapter? = null
    private val PERMISSIONS_STORAGE = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    )


    override fun initView() {
        setTitleText("选择图片")
        initRecycler();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED) {
            startScannerTask()
        } else {
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, 100)
        }
    }

    private fun initRecycler() {
        mAdapter = MediaAdapter(this, ArrayList())
    }

    private fun startScannerTask() {
        PickerManager.mInstance.setPickerConfig(PickerConfig.Builder.build())
        PickerManager.mInstance.loadMedia(this@ImagePickerActivity, MediaCallback())
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_image_picker
    }

    inner class MediaCallback : IMediaCallback {
        override fun onLoadSucceed(array: ArrayList<MediaFile>) {
            recyclerview.adapter = MediaAdapter(this@ImagePickerActivity,array)
            recyclerview.layoutManager = GridLayoutManager(this@ImagePickerActivity, 4)
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
                val sdWResult = grantResults[2]
                //拍照权限
                val cameraGranted = cameraResult == PackageManager.PERMISSION_GRANTED
                //拍照权限
                val sdGranted = sdResult == PackageManager.PERMISSION_GRANTED
                val sdWGranted = sdWResult == PackageManager.PERMISSION_GRANTED
                if (cameraGranted && sdGranted && sdWGranted) {
                    //具有拍照权限，sd卡权限，开始扫描任务
                    startScannerTask()
                } else {
                    //没有权限
                    Toast.makeText(this@ImagePickerActivity,
                            "没有权限",
                            Toast.LENGTH_SHORT)
                            .show()
                    finish()
                }
            }
        }
    }

}