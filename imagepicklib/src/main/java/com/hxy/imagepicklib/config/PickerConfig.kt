package com.hxy.imagepicklib.config

import com.hxy.imagepicklib.imageloader.IMediaCallback
import com.hxy.imagepicklib.model.MediaFile
import com.hxy.imagepicklib.scanner.AbstractMediaScanner


/**
 * desc:
 * @author tuoxie on 2020/7/14
 * E-Mail Address：tuoxie@gaoding.com
 **/
class PickerConfig {
    private val mShowImage: Boolean
    private val mMinTimeMs: Long
    private val mShowVideo: Boolean
    private val mCustomMediaScanner: AbstractMediaScanner<MediaFile>?
    private val mMediaCallback: IMediaCallback?

    private constructor(builder: Builder) {
        mShowImage = builder.mShowImage
        mShowVideo = builder.mShowVideo
        mCustomMediaScanner = builder.mScanner
        mMinTimeMs = builder.mMinTimeMs
        mMediaCallback = builder.mMediaCallback
    }

    fun isShowImage(): Boolean {
        return mShowImage
    }

    fun isShowVideo(): Boolean {
        return mShowVideo
    }

    fun getMinTime(): Long {
        return mMinTimeMs
    }

    fun getCustomScanner(): AbstractMediaScanner<MediaFile>? {
        return mCustomMediaScanner
    }

    object Builder {
        var mShowImage: Boolean = true
        var mShowVideo: Boolean = true
        var mMinTimeMs: Long = 0
        var mScanner: AbstractMediaScanner<MediaFile>? = null
        var mMediaCallback: IMediaCallback? = null

        fun withScanner(scanner: AbstractMediaScanner<MediaFile>?): Builder {
            mScanner = scanner
            return this
        }

        fun withMediaCallback(callback: IMediaCallback): Builder {
            mMediaCallback = callback
            return this
        }

        fun withShowImage(showImage: Boolean): Builder {
            mShowImage = showImage
            return this
        }

        fun withShowVideo(showVideo: Boolean): Builder {
            mShowVideo = showVideo
            return this
        }

        fun withMinTimeMs(minTimeMs: Long): Builder {
            mMinTimeMs = minTimeMs
            return this
        }

        fun build() = PickerConfig(this);

    }
}