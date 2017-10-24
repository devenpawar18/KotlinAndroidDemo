package com.kotlinandroiddemo.screen.app

import android.content.Context
import com.kotlinandroiddemo.api.service.flicker.FlickerService
import com.kotlinandroiddemo.application.KotlinAndroidDemoApplication
import com.kotlinandroiddemo.application.scope.ApplicationScope
import com.kotlinandroiddemo.screen.BaseActivity
import dagger.Component
import org.greenrobot.eventbus.EventBus

/**
 * Created by Deven on 10/20/17.
 */
@ApplicationScope
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
  fun inject(kotlinAndroidDemoApplication: KotlinAndroidDemoApplication)
  fun inject(baseActivity: BaseActivity)

  fun provideKotlinAndroidDemoApplication(): KotlinAndroidDemoApplication
  fun provideContext(): Context
  fun provideEventBus(): EventBus

  // Managers

  //Services
  fun provideFlickerService(): FlickerService
}