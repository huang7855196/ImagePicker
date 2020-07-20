package com.hxy.news.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * desc:
 * @author tuoxie on 2020/7/16
 * E-Mail Address：tuoxie@gaoding.com
 **/
interface Api {

    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    fun getNewsList(
            @Path("type") type: String?, @Path("id") id: String?,
            @Path("startPage") startPage: Int): Call<String>

}