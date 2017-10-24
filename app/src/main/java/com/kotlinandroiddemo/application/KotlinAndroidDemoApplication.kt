package com.kotlinandroiddemo.application

import android.app.Application
import com.kotlinandroiddemo.screen.app.AppComponent
import com.kotlinandroiddemo.screen.app.AppModule
import com.kotlinandroiddemo.screen.app.DaggerAppComponent

/**
 * Created by Deven on 10/20/17.
 */
class KotlinAndroidDemoApplication : Application() {
  private lateinit var appComponent: AppComponent

  override fun onCreate() {
    instance = this
    super.onCreate()

    appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()

    getAppComponent().inject(this)
  }

  fun getAppComponent(): AppComponent {
    return appComponent
  }

  companion object {
    const val BASE_URL = "https://api.flickr.com/"

    lateinit var instance: KotlinAndroidDemoApplication

    fun getKotlinAndroidDemoApplication(): KotlinAndroidDemoApplication {
      return instance
    }
  }
}