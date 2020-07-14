package com.hxy.imagepicklib.model

import androidx.annotation.Keep
import java.io.Serializable

/**
 * desc:
 * @author tuoxie on 2020/7/14
 * E-Mail Address：tuoxie@gaoding.com
 **/
@Keep
class MediaFile : Serializable {
    private var path: String? = null
    private var mime: String? = null
    private var folderId: Int? = null
    private var folderName: String? = null
    private var duration: Long = 0
    private var isVideo = false
    private var dateToken: Long = 0

    private var dateModified: Long = 0

    fun isVideo(): Boolean {
        return isVideo
    }

    fun setVideo(video: Boolean) {
        isVideo = video
    }

    fun getPath(): String? {
        return path
    }

    fun setPath(path: String?) {
        this.path = path
    }

    fun getMime(): String? {
        return mime
    }

    fun setMime(mime: String?) {
        this.mime = mime
    }

    fun getFolderId(): Int? {
        return folderId
    }

    fun setFolderId(folderId: Int?) {
        this.folderId = folderId
    }

    fun getFolderName(): String? {
        return folderName
    }

    fun setFolderName(folderName: String?) {
        this.folderName = folderName
    }

    fun getDuration(): Long {
        return duration
    }

    fun setDuration(duration: Long) {
        this.duration = duration
    }

    fun getDateToken(): Long {
        return dateToken
    }

    fun setDateToken(dateToken: Long) {
        this.dateToken = dateToken
    }

    fun getDateModified(): Long {
        return dateModified
    }

    fun setDateModified(dateModified: Long) {
        this.dateModified = dateModified
    }
}