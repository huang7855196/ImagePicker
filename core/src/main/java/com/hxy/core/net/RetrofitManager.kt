package com.hxy.core.net

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * desc:
 * @author tuoxie on 2020/7/16
 * E-Mail Address：tuoxie@gaoding.com
 **/
class RetrofitManager {
    private lateinit var retrofit: Retrofit

    companion object {
        val instance = Holder.instance
    }

    private constructor() {
        getRetrofit()
    }

    private object Holder {
        val instance = RetrofitManager()
    }

    private fun getRetrofit() {
        val builder = OkHttpClient.Builder().build()
        val client: OkHttpClient = OkHttpClient()
                .newBuilder()
                .readTimeout(8000, TimeUnit.MILLISECONDS)
                .connectTimeout(8000, TimeUnit.MILLISECONDS)
                //.addInterceptor(interceptor())
                .build()
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create()
        retrofit = Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://c.m.163.com/")
                .build()
    }

    fun <T> getApi(service: Class<T>?): T {
        return retrofit.create(service)
    }

//    class interceptor : Interceptor {
//        override fun intercept(chain: Interceptor.Chain): Response {
////            var request = chain.request()
////            val cacheControl = request.cacheControl.toString()
////            if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
////                request = request.newBuilder()
////                        .cacheControl(if (TextUtils.isEmpty(cacheControl)) CacheControl.FORCE_NETWORK else CacheControl.FORCE_CACHE)
////                        .build()
////            }
////            val originalResponse = chain.proceed(request)
////            return if (NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
////                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
////                originalResponse.newBuilder()
////                        .header("Cache-Control", cacheControl)
////                        .removeHeader("Pragma")
////                        .build()
////            } else {
////                originalResponse.newBuilder()
////                        .header("Cache-Control", "public, only-if-cached, max-stale=" + com.jaydenxiao.androidfire.api.Api.CACHE_STALE_SEC)
////                        .removeHeader("Pragma")
////                        .build()
//            }
//        }

}