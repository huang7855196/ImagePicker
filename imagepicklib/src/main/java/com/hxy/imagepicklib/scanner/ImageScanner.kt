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
class ImageScanner : AbstractMediaScanner<MediaFile>() {
    private val SELECTION_IMAGE_MIME_TYPE = MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=?"
    private val SELECTION_IMAGE_MIME_TYPE_WITHOUT_GIF = MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=?"
    private val SELECTION_ID = MediaStore.Images.Media.BUCKET_ID + "=? and (" + SELECTION_IMAGE_MIME_TYPE + " )"
    private val SELECTION_ID_WITHOUT_GIF = MediaStore.Images.Media.BUCKET_ID + "=? and (" + SELECTION_IMAGE_MIME_TYPE_WITHOUT_GIF + " )"
    private val SELECTION_ARGS_IMAGE_MIME_TYPE = arrayOf("image/jpeg", "image/png", "image/jpg", "image/gif")
    private val SELECTION_ARGS_IMAGE_MIME_TYPE_WITHOUT_GIF = arrayOf("image/jpeg", "image/png", "image/jpg")
    private var mNeedGif = false


    override fun getScanUri(): Uri? {
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    }

    override fun getProjection(): Array<String?>? {
        return arrayOf(
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.MIME_TYPE,
                MediaStore.Images.Media.BUCKET_ID,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
                MediaStore.Images.Media.DATE_TAKEN,
                MediaStore.Images.Media.DATE_MODIFIED
        )
    }

    override fun getSelection(): String? {
        return if (mNeedGif) SELECTION_IMAGE_MIME_TYPE else SELECTION_IMAGE_MIME_TYPE_WITHOUT_GIF
    }

    override fun getSelectionArgs(): Array<String>? {
        return if (mNeedGif) SELECTION_ARGS_IMAGE_MIME_TYPE else SELECTION_ARGS_IMAGE_MIME_TYPE_WITHOUT_GIF
    }

    override fun getOrder(): String? {
        return MediaStore.Images.Media.DATE_MODIFIED + " desc"
    }

    override fun parse(cursor: Cursor?): MediaFile {
        val path = cursor!!.getString(cursor!!.getColumnIndex(MediaStore.Images.Media.DATA))
        val mime = cursor!!.getString(cursor!!.getColumnIndex(MediaStore.Images.Media.MIME_TYPE))
        val folderId = cursor!!.getInt(cursor!!.getColumnIndex(MediaStore.Images.Media.BUCKET_ID))
        val folderName = cursor!!.getString(cursor!!.getColumnIndex(MediaStore.Images.Media.BUCKET_DISPLAY_NAME))
        val dateToken = cursor!!.getLong(cursor!!.getColumnIndex(MediaStore.Images.Media.DATE_TAKEN))
        val dateModified = cursor!!.getLong(cursor!!.getColumnIndex(MediaStore.Images.Media.DATE_MODIFIED))
        val mediaFile = MediaFile()
        mediaFile.setPath(path)
        mediaFile.setMime(mime)
        mediaFile.setFolderId(folderId)
        mediaFile.setFolderName(folderName)
        mediaFile.setDateToken(dateToken)
        mediaFile.setDateModified(dateModified)

        return mediaFile
    }
}