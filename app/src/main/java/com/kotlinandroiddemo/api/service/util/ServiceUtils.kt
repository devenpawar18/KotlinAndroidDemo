package com.kotlinandroiddemo.api.service.util

import com.kotlinandroiddemo.util.service.IFailureCallback
import com.kotlinandroiddemo.util.service.ISuccessCallback
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by Deven on 10/20/17.
 */
class ServiceUtils {
  companion object {
    private const val RETRY_COUNT = 5
    private val RETRY_DELAY_MILLIS: Long = TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS)
    private val TIMEOUT_MILIS: Long = TimeUnit.MILLISECONDS.convert(30, TimeUnit.SECONDS)

    fun <T> defaults(observable: Observable<T>, successCallback: ISuccessCallback<T>, failureCallback: IFailureCallback): Disposable {
      return defaults(observable, successCallback, failureCallback, TIMEOUT_MILIS, TimeUnit.MILLISECONDS)
    }

    fun <T> defaults(observable: Observable<T>, successCallback: ISuccessCallback<T>, failureCallback: IFailureCallback, timeout: Long, timeoutTimeUnit: TimeUnit): Disposable {
      return observable.retryWhen(RetryWithDelay(RETRY_COUNT, RETRY_DELAY_MILLIS))
              .timeout(timeout, timeoutTimeUnit)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(successCallback, failureCallback)
    }
  }
}