package com.kotlinandroiddemo.screen

/**
 * Created by Deven on 10/23/17.
 */
interface BasePresenter<T> {
  fun takeView(view: T)
  fun dropView()
  fun nextScreen()
}