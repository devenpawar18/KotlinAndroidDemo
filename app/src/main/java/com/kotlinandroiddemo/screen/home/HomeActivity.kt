package com.kotlinandroiddemo.screen.home

import android.os.Bundle
import com.kotlinandroiddemo.R
import com.kotlinandroiddemo.application.KotlinAndroidDemoApplication
import com.kotlinandroiddemo.screen.BaseActivity
import com.kotlinandroiddemo.screen.util.PopupManager
import com.kotlinandroiddemo.util.ViewUtils
import javax.inject.Inject

class HomeActivity : BaseActivity() {
  @Inject
  lateinit var homeView: HomeView

  private lateinit var homeComponent: HomeComponent

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    homeComponent = DaggerHomeComponent.builder()
            .appComponent(KotlinAndroidDemoApplication.getKotlinAndroidDemoApplication().getAppComponent())
            .homeModule(HomeModule()).build()

    homeComponent.inject(this)

    setContentView(R.layout.activity_home)

    var homeView = supportFragmentManager.findFragmentById(R.id.home_container) as HomeView?

    if (homeView == null) {
      homeView = this.homeView
      ViewUtils.addViewToActivity(supportFragmentManager, homeView, R.id.home_container)
    }
  }

  fun getHomeComponent(): HomeComponent {
    return homeComponent
  }

  fun getPopupManager(): PopupManager {
    return popupManager
  }
}