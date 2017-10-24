package com.kotlinandroiddemo.api.service.util

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by Deven on 10/20/17.
 */
class RequestInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val original: Request = chain.request()
    val requestBuilder: Request.Builder = original.newBuilder()
    // Add Headers
    // requestBuilder.addHeader("bc", "mc")

    val request: Request = requestBuilder.build()
    return chain.proceed(request)
  }
}