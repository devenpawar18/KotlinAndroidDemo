package com.kotlinandroiddemo.screen.splash

import android.os.Bundle
import com.kotlinandroiddemo.R
import com.kotlinandroiddemo.application.KotlinAndroidDemoApplication
import com.kotlinandroiddemo.screen.BaseActivity
import com.kotlinandroiddemo.util.ViewUtils
import javax.inject.Inject

class SplashActivity : BaseActivity() {
  @Inject
  lateinit var splashView: SplashView

  private lateinit var splashComponent: SplashComponent

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    this.splashComponent = DaggerSplashComponent.builder()
            .appComponent(KotlinAndroidDemoApplication.getKotlinAndroidDemoApplication().getAppComponent())
            .splashModule(SplashModule()).build()

    this.splashComponent.inject(this)

    setContentView(R.layout.activity_splash)

    var splashView = supportFragmentManager.findFragmentById(R.id.splash_container) as SplashView?

    if (splashView == null) {
      splashView = this.splashView
      ViewUtils.addViewToActivity(supportFragmentManager, splashView, R.id.splash_container)
    }
  }

  fun getSplashComponent(): SplashComponent {
    return this.splashComponent
  }
}