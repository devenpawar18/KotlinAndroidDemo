package com.kotlinandroiddemo.screen.home

import com.kotlinandroiddemo.application.scope.ScreenScope
import com.kotlinandroiddemo.screen.app.AppComponent
import dagger.Component

/**
 * Created by Deven on 10/23/17.
 */
@ScreenScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(HomeModule::class))
interface HomeComponent : AppComponent {
  fun inject(homeActivity: HomeActivity)
  fun inject(homeView: HomeView)
}