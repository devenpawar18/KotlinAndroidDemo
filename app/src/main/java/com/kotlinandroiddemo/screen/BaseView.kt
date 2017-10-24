package com.kotlinandroiddemo.screen

import android.content.Context

/**
 * Created by Deven on 10/23/17.
 */
interface BaseView<T> {
  fun getContext(): Context
}