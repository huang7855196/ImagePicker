package com.hxy.imagepicklib.scanner

import android.content.Context
import android.database.Cursor
import android.net.Uri
import java.util.*

/**
 * desc:
 * @author tuoxie on 2020/7/14
 * E-Mail Address：tuoxie@gaoding.com
 **/
abstract class AbstractMediaScanner<T>{

    /**
     * 查询URI
     *
     * @return
     */
    protected abstract fun getScanUri(): Uri?

    /**
     * 查询列名
     *
     * @return
     */
    protected abstract fun getProjection(): Array<String?>?

    /**
     * 查询条件
     *
     * @return
     */
    protected abstract fun getSelection(): String?

    /**
     * 查询条件值
     *
     * @return
     */
    protected abstract fun getSelectionArgs(): Array<String>?

    /**
     * 查询排序
     *
     * @return
     */
    protected abstract fun getOrder(): String?

    /**
     * 对外暴露游标，让开发者灵活构建对象
     *
     * @param cursor
     * @return
     */
    protected abstract fun parse(cursor: Cursor?): T?

    /**
     * 根据查询条件进行媒体库查询，隐藏查询细节，让开发者更专注业务
     *
     * @return
     */
    open fun queryMedia(context : Context): ArrayList<T>? {
        val list = ArrayList<T>()
        val contentResolver = context.contentResolver
        val cursor = contentResolver.query(getScanUri()!!, getProjection(), getSelection(), getSelectionArgs(), getOrder())
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val t: T? = parse(cursor)
                if (t != null) {
                    list.add(t)
                }
            }
            cursor.close()
        }
        return list
    }
}