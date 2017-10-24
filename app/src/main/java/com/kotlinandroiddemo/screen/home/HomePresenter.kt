package com.kotlinandroiddemo.screen.home

import com.kotlinandroiddemo.api.model.PhotoInfo
import com.kotlinandroiddemo.api.service.flicker.FlickerService
import com.kotlinandroiddemo.api.service.util.ServiceUtils
import com.kotlinandroiddemo.util.ApiUtils.Companion.API_FORMAT
import com.kotlinandroiddemo.util.ApiUtils.Companion.API_METHOD
import com.kotlinandroiddemo.util.ApiUtils.Companion.API_KEY
import com.kotlinandroiddemo.util.ApiUtils.Companion.API_NO_JSON_CALLBACK
import com.kotlinandroiddemo.util.ViewUtils
import com.kotlinandroiddemo.util.service.IFailureCallback
import com.kotlinandroiddemo.util.service.ISuccessCallback
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by Deven on 10/23/17.
 */
class HomePresenter @Inject constructor() : HomeContract.Presenter {
  private var homeView: HomeContract.View? = null

  @Inject
  lateinit var flickerService: FlickerService

  private var disposables = CompositeDisposable()

  override fun takeView(homeView: HomeContract.View) {
    this.homeView = ViewUtils.checkNotNull(homeView, "HomeView can't be null")
    this.homeView = homeView
    this.fetchPhotos()
  }

  override fun fetchPhotos() {
    val homeActivity = this.homeView!!.getContext() as HomeActivity
    homeActivity.getPopupManager().showProgress(PROGRESS_FETCH_TAG, "Fetching Shit...")
    val fetchObservable = this.flickerService.getPhotoInfo(API_METHOD, API_KEY, API_FORMAT, API_NO_JSON_CALLBACK, "Deven", 1)

    val successCallback = object : ISuccessCallback<PhotoInfo> {
      override fun accept(pPhotoInfo: PhotoInfo) {
        homeView!!.updateView(pPhotoInfo)
        homeActivity.getPopupManager().dismissProgress(PROGRESS_FETCH_TAG)
      }
    }

    val failureCallback = object : IFailureCallback {
      override fun accept(pThrowable: Throwable) {
        homeActivity.toast("Failure")
        homeActivity.getPopupManager().dismissProgress(PROGRESS_FETCH_TAG)
      }
    }

    this.disposables.add(ServiceUtils.defaults(fetchObservable, successCallback, failureCallback))
  }

  override fun dropView() {
    this.disposables.dispose()
    this.homeView = null
  }

  override fun nextScreen() {
    // TODO: Goto Next Screen
  }

  companion object {
    val PROGRESS_FETCH_TAG = "progress.fetch.tag"
  }
}