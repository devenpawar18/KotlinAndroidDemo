package com.kotlinandroiddemo.screen.home

import com.kotlinandroiddemo.api.model.PhotoInfo
import com.kotlinandroiddemo.screen.BasePresenter
import com.kotlinandroiddemo.screen.BaseView

/**
 * Created by Deven on 10/23/17.
 */
interface HomeContract {
  interface View : BaseView<Presenter> {
    fun updateView(photoInfo: PhotoInfo)
  }

  interface Presenter : BasePresenter<View> {
    fun fetchPhotos()
  }
}