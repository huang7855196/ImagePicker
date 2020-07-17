package com.hxy.news.api

import com.hxy.news.news.presenter.NewsChannelModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import rx.Observable

/**
 * desc:
 * @author tuoxie on 2020/7/16
 * E-Mail Address：tuoxie@gaoding.com
 **/
interface Api {
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    fun getNewsList(
            @Path("type") type: String?, @Path("id") id: String?,
            @Path("startPage") startPage: Int): Observable<Map<String?, List<NewsChannelModel>>>

}