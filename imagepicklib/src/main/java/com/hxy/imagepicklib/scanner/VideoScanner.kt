package com.hxy.imagepicklib.scanner

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.hxy.imagepicklib.model.MediaFile

/**
 * desc:
 * @author tuoxie on 2020/7/14
 * E-Mail Address：tuoxie@gaoding.com
 **/
class VideoScanner constructor(minTimeMs: Long) : AbstractMediaScanner<MediaFile>() {
    private val SELECTION_VIDEO_DURATION = MediaStore.Video.Media.DURATION + "> ? "
    private val mSkipMinTime: Boolean = if (minTimeMs > 0) true else false
    private val mMinTimeMs: Long = minTimeMs

    override fun getScanUri(): Uri? {
        return MediaStore.Video.Media.EXTERNAL_CONTENT_URI
    }

    override fun getProjection(): Array<String?>? {
        return arrayOf(MediaStore.Video.Media.DATA,
                MediaStore.Video.Media.MIME_TYPE,
                MediaStore.Video.Media.BUCKET_ID,
                MediaStore.Video.Media.BUCKET_DISPLAY_NAME,
                MediaStore.Video.Media.DURATION,
                MediaStore.Video.Media.DATE_TAKEN,
                MediaStore.Video.Media.DATE_MODIFIED)
    }

    override fun getSelection(): String? {
        return if (mSkipMinTime) SELECTION_VIDEO_DURATION else null
    }

    override fun getSelectionArgs(): Array<String>? {
        return if (mSkipMinTime) arrayOf(mMinTimeMs.toString()) else null
    }

    override fun getOrder(): String? {
        return MediaStore.Video.Media.DATE_MODIFIED + " desc"
    }

    override fun parse(cursor: Cursor?): MediaFile? {
        var needAdd = true
        val path = cursor!!.getString(cursor!!.getColumnIndex(MediaStore.Video.Media.DATA))
        // 如果mLimitVideo不为空，则加载mLimitVideo中指定的视频格式
        // 如果mLimitVideo不为空，则加载mLimitVideo中指定的视频格式
        if (!needAdd) {
            return null
        }
        val mime = cursor!!.getString(cursor!!.getColumnIndex(MediaStore.Video.Media.MIME_TYPE))
        val folderId = cursor!!.getInt(cursor!!.getColumnIndex(MediaStore.Video.Media.BUCKET_ID))
        val folderName = cursor!!.getString(cursor!!.getColumnIndex(MediaStore.Video.Media.BUCKET_DISPLAY_NAME))
        val duration = cursor!!.getLong(cursor!!.getColumnIndex(MediaStore.Video.Media.DURATION))
        val dateToken = cursor!!.getLong(cursor!!.getColumnIndex(MediaStore.Video.Media.DATE_TAKEN))
        val dateModified = cursor!!.getLong(cursor!!.getColumnIndex(MediaStore.Video.Media.DATE_MODIFIED))

        val mediaFile = MediaFile()
        mediaFile.setPath(path)
        mediaFile.setMime(mime)
        mediaFile.setFolderId(folderId)
        mediaFile.setFolderName(folderName)
        mediaFile.setDuration(duration)
        mediaFile.setDateToken(dateToken)
        mediaFile.setVideo(true)
        mediaFile.setDateModified(dateModified)

        return mediaFile
    }
}