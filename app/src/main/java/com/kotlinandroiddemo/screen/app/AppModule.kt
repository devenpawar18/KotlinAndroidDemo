package com.kotlinandroiddemo.screen.app

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kotlinandroiddemo.application.KotlinAndroidDemoApplication
import com.kotlinandroiddemo.application.scope.ApplicationScope
import dagger.Provides
import org.greenrobot.eventbus.EventBus

/**
 * Created by Deven on 10/20/17.
 */
@dagger.Module
class AppModule(val kotlinAndroidDemoAmmplication: KotlinAndroidDemoApplication) {
  private var eventBus: EventBus
  private var gson: Gson


  init {
    val eventBusBuilder = EventBus.builder()
    eventBusBuilder.throwSubscriberException(true)
    this.eventBus = eventBusBuilder.build()

    this.gson = GsonBuilder().create()
  }

  @Provides
  @ApplicationScope
  fun provideKotlinAndroidDemoApplication(): KotlinAndroidDemoApplication {
    return this.kotlinAndroidDemoAmmplication
  }

  @Provides
  @ApplicationScope
  fun provideContext(): Context {
    return this.kotlinAndroidDemoAmmplication
  }

  @Provides
  @ApplicationScope
  fun provideEventBus(): EventBus {
    return this.eventBus
  }
}