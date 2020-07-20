package com.hxy.news.news.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.*
import androidx.annotation.Keep
import java.util.*

/**
 * desc:
 * @author tuoxie on 2020/7/17
 * E-Mail Address：tuoxie@gaoding.com
 **/
@Keep
class NewsInfoEntity {
    private var postid: String? = null
    private var hasCover = false
    private var hasHead = 0
    private var replyCount = 0
    private var hasImg = 0
    private var digest: String? = null
    private var hasIcon = false
    private var docid: String? = null
    private var title: String? = null
    private var ltitle: String? = null
    private var order = 0
    private var priority = 0
    private var lmodify: String? = null
    private var boardid: String? = null
    private var photosetID: String? = null
    private var template: String? = null
    private var votecount = 0
    private var skipID: String? = null
    private var alias: String? = null
    private var skipType: String? = null
    private var cid: String? = null
    private var hasAD = 0
    private var source: String? = null
    private var ename: String? = null
    private var imgsrc: String? = null
    private var tname: String? = null
    private var ptime: String? = null

    /**
     * title : "悬崖村" 孩子上学需爬800米悬崖
     * tag : photoset
     * imgsrc : http://img1.cache.netease.com/3g/2016/5/24/2016052421435478ea5.jpg
     * subtitle :
     * url : 00AP0001|119327
     */
    private var ads: List<AdsBean?>? = null

    /**
     * imgsrc : http://img3.cache.netease.com/3g/2016/5/24/2016052416484243560.jpg
     */
    private var imgextra: List<ImgextraBean?>? = null

    fun getPostid(): String? {
        return postid
    }

    fun setPostid(postid: String?) {
        this.postid = postid
    }

    fun isHasCover(): Boolean {
        return hasCover
    }

    fun setHasCover(hasCover: Boolean) {
        this.hasCover = hasCover
    }

    fun getHasHead(): Int {
        return hasHead
    }

    fun setHasHead(hasHead: Int) {
        this.hasHead = hasHead
    }

    fun getReplyCount(): Int {
        return replyCount
    }

    fun setReplyCount(replyCount: Int) {
        this.replyCount = replyCount
    }

    fun getHasImg(): Int {
        return hasImg
    }

    fun setHasImg(hasImg: Int) {
        this.hasImg = hasImg
    }

    fun getDigest(): String? {
        return digest
    }

    fun setDigest(digest: String?) {
        this.digest = digest
    }

    fun isHasIcon(): Boolean {
        return hasIcon
    }

    fun setHasIcon(hasIcon: Boolean) {
        this.hasIcon = hasIcon
    }

    fun getDocid(): String? {
        return docid
    }

    fun setDocid(docid: String?) {
        this.docid = docid
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getLtitle(): String? {
        return ltitle
    }

    fun setLtitle(ltitle: String?) {
        this.ltitle = ltitle
    }

    fun getOrder(): Int {
        return order
    }

    fun setOrder(order: Int) {
        this.order = order
    }

    fun getPriority(): Int {
        return priority
    }

    fun setPriority(priority: Int) {
        this.priority = priority
    }

    fun getLmodify(): String? {
        return lmodify
    }

    fun setLmodify(lmodify: String?) {
        this.lmodify = lmodify
    }

    fun getBoardid(): String? {
        return boardid
    }

    fun setBoardid(boardid: String?) {
        this.boardid = boardid
    }

    fun getPhotosetID(): String? {
        return photosetID
    }

    fun setPhotosetID(photosetID: String?) {
        this.photosetID = photosetID
    }

    fun getTemplate(): String? {
        return template
    }

    fun setTemplate(template: String?) {
        this.template = template
    }

    fun getVotecount(): Int {
        return votecount
    }

    fun setVotecount(votecount: Int) {
        this.votecount = votecount
    }

    fun getSkipID(): String? {
        return skipID
    }

    fun setSkipID(skipID: String?) {
        this.skipID = skipID
    }

    fun getAlias(): String? {
        return alias
    }

    fun setAlias(alias: String?) {
        this.alias = alias
    }

    fun getSkipType(): String? {
        return skipType
    }

    fun setSkipType(skipType: String?) {
        this.skipType = skipType
    }

    fun getCid(): String? {
        return cid
    }

    fun setCid(cid: String?) {
        this.cid = cid
    }

    fun getHasAD(): Int {
        return hasAD
    }

    fun setHasAD(hasAD: Int) {
        this.hasAD = hasAD
    }

    fun getSource(): String? {
        return source
    }

    fun setSource(source: String?) {
        this.source = source
    }

    fun getEname(): String? {
        return ename
    }

    fun setEname(ename: String?) {
        this.ename = ename
    }

    fun getImgsrc(): String? {
        return imgsrc
    }

    fun setImgsrc(imgsrc: String?) {
        this.imgsrc = imgsrc
    }

    fun getTname(): String? {
        return tname
    }

    fun setTname(tname: String?) {
        this.tname = tname
    }

    fun getPtime(): String? {
        return ptime
    }

    fun setPtime(ptime: String?) {
        this.ptime = ptime
    }

    fun getAds(): List<AdsBean?>? {
        return ads
    }

    fun setAds(ads: List<AdsBean?>?) {
        this.ads = ads
    }

    fun getImgextra(): List<ImgextraBean?>? {
        return imgextra
    }

    fun setImgextra(imgextra: List<ImgextraBean?>?) {
        this.imgextra = imgextra
    }

    class AdsBean {
        var title: String? = null
        var tag: String? = null
        var imgsrc: String? = null
        var subtitle: String? = null
        var url: String? = null

    }

    class ImgextraBean {
        var imgsrc: String? = null

    }

    fun describeContents(): Int {
        return 0
    }

    fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(postid)
        dest.writeByte(if (hasCover) 1.toByte() else 0.toByte())
        dest.writeInt(hasHead)
        dest.writeInt(replyCount)
        dest.writeInt(hasImg)
        dest.writeString(digest)
        dest.writeByte(if (hasIcon) 1.toByte() else 0.toByte())
        dest.writeString(docid)
        dest.writeString(title)
        dest.writeString(ltitle)
        dest.writeInt(order)
        dest.writeInt(priority)
        dest.writeString(lmodify)
        dest.writeString(boardid)
        dest.writeString(photosetID)
        dest.writeString(template)
        dest.writeInt(votecount)
        dest.writeString(skipID)
        dest.writeString(alias)
        dest.writeString(skipType)
        dest.writeString(cid)
        dest.writeInt(hasAD)
        dest.writeString(source)
        dest.writeString(ename)
        dest.writeString(imgsrc)
        dest.writeString(tname)
        dest.writeString(ptime)
        dest.writeList(ads)
        dest.writeList(imgextra)
    }

    fun NewsSummary() {}

    protected fun NewsSummary(`in`: Parcel) {
        postid = `in`.readString()
        hasCover = `in`.readByte().toInt() != 0
        hasHead = `in`.readInt()
        replyCount = `in`.readInt()
        hasImg = `in`.readInt()
        digest = `in`.readString()
        hasIcon = `in`.readByte().toInt() != 0
        docid = `in`.readString()
        title = `in`.readString()
        ltitle = `in`.readString()
        order = `in`.readInt()
        priority = `in`.readInt()
        lmodify = `in`.readString()
        boardid = `in`.readString()
        photosetID = `in`.readString()
        template = `in`.readString()
        votecount = `in`.readInt()
        skipID = `in`.readString()
        alias = `in`.readString()
        skipType = `in`.readString()
        cid = `in`.readString()
        hasAD = `in`.readInt()
        source = `in`.readString()
        ename = `in`.readString()
        imgsrc = `in`.readString()
        tname = `in`.readString()
        ptime = `in`.readString()
        ads = ArrayList()
        `in`.readList(ads, AdsBean::class.java.classLoader)
        imgextra = ArrayList()
        `in`.readList(imgextra, ImgextraBean::class.java.classLoader)
    }

}