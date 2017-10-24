package com.kotlinandroiddemo.screen.splash

import com.kotlinandroiddemo.application.scope.ScreenScope
import com.kotlinandroiddemo.screen.app.AppComponent
import dagger.Component

/**
 * Created by Deven on 10/23/17.
 */
@ScreenScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(SplashModule::class))
interface SplashComponent : AppComponent {
  fun inject(splashActivity: SplashActivity)
  fun inject(splashView: SplashView)
}