package com.kotlinandroiddemo.screen.splash

import android.content.Context
import com.kotlinandroiddemo.screen.BasePresenter
import com.kotlinandroiddemo.screen.BaseView

/**
 * Created by Deven on 10/23/17.
 */
interface SplashContract {

  interface View : BaseView<Presenter> {

  }

  interface Presenter : BasePresenter<View> {

  }
}