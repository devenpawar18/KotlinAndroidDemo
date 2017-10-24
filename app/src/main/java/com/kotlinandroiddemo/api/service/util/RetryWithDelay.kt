package com.kotlinandroiddemo.api.service.util

import io.reactivex.Observable
import io.reactivex.functions.Function
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

/**
 * Created by Deven on 10/20/17.
 */
class RetryWithDelay(var countMaximum: Int, var delayMilis: Long) : Function<Observable<out Throwable>, Observable<*>> {
  companion object {
    val HTTP_STATUS_CODES_DO_NOT_RETRY = intArrayOf(HttpURLConnection.HTTP_BAD_REQUEST,
            HttpURLConnection.HTTP_NOT_FOUND,
            HttpURLConnection.HTTP_CONFLICT,
            HttpURLConnection.HTTP_FORBIDDEN)
  }

  private var retryCountMaximum: Int
  private var retryDelayMilis: Long
  private var retryCount: Int

  init {
    this.retryCountMaximum = countMaximum
    this.retryDelayMilis = delayMilis
    this.retryCount = 0
  }


  override fun apply(attempts: Observable<out Throwable>): Observable<*> {
    return attempts.flatMap({ pThrowable ->
      this.retryCount++
      // Depends
      val retry = true
      if (retry) {
        Observable.timer(this.retryDelayMilis, TimeUnit.MILLISECONDS)
      } else {
        Observable.error<Any>(pThrowable)
      }
    })
  }
}