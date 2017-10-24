package com.kotlinandroiddemo.screen.splash

import android.content.Intent
import android.os.Handler
import com.kotlinandroiddemo.screen.home.HomeActivity
import com.kotlinandroiddemo.util.ViewUtils
import javax.inject.Inject

/**
 * Created by Deven on 10/23/17.
 */
class SplashPresenter @Inject constructor() : SplashContract.Presenter {
  private var splashView: SplashContract.View? = null

  override fun takeView(splashView: SplashContract.View) {
    this.splashView = ViewUtils.checkNotNull(splashView, "SplashView can't be null")
    this.splashView = splashView
    this.nextScreen()
  }

  override fun dropView() {
    this.splashView = null
  }

  override fun nextScreen() {
    val SPLASH_DISPLAY_LENGTH = 1000

    Handler().postDelayed({
      val splashActivity = this.splashView!!.getContext() as SplashActivity
      val intent = Intent(splashActivity, HomeActivity::class.java)
      splashActivity.startActivity(intent)
      splashActivity.finish()
    }, SPLASH_DISPLAY_LENGTH.toLong())
  }
}