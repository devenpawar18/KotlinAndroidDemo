package com.kotlinandroiddemo.screen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlinandroiddemo.application.KotlinAndroidDemoApplication
import com.kotlinandroiddemo.screen.util.PopupManager

open class BaseActivity : AppCompatActivity() {
  internal lateinit var popupManager: PopupManager

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    KotlinAndroidDemoApplication.getKotlinAndroidDemoApplication().getAppComponent().inject(this)

    popupManager = PopupManager(this)
  }
}