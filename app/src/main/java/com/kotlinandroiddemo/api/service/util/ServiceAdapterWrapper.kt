package com.kotlinandroiddemo.api.service.util

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.greenrobot.eventbus.EventBus
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Deven on 10/20/17.
 */
class ServiceAdapterWrapper {
  companion object {
    private const val BASE_URL = "https://api.flickr.com/"

    fun <T> wrapService(serviceClass: Class<T>, eventBus: EventBus): T {
      val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(getHttpCLient())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

      return retrofit.create(serviceClass)
    }

    fun wrapService(): Retrofit {
      val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(getHttpCLient())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

      return retrofit
    }

    fun getHttpCLient(): OkHttpClient {
      val httpLoggingInterceptor = HttpLoggingInterceptor()
      httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
      val okHttpClient = OkHttpClient.Builder()
      okHttpClient.addInterceptor(httpLoggingInterceptor)
      okHttpClient.addInterceptor(RequestInterceptor())
      return okHttpClient.build()
    }
  }
}