package com.kotlinandroiddemo.screen.splash

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife

import com.kotlinandroiddemo.R
import javax.inject.Inject

class SplashView @Inject constructor() : Fragment(), SplashContract.View {
  @Inject
  protected lateinit var presenter: SplashPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    (activity as SplashActivity).getSplashComponent().inject(this)
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater!!.inflate(R.layout.fragment_splash_view, container, false)
    ButterKnife.bind(this, view)

    return view
  }

  override fun onResume() {
    super.onResume()
    this.presenter.takeView(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    this.presenter.dropView()
  }

  override fun getContext(): Context {
    return this.activity
  }
}
