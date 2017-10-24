package com.kotlinandroiddemo.screen.home

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.kotlinandroiddemo.R
import com.kotlinandroiddemo.api.model.Photo
import com.kotlinandroiddemo.api.model.PhotoInfo
import org.jetbrains.anko.toast
import timber.log.Timber
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by Deven on 10/23/17.
 */
class HomeView @Inject constructor() : Fragment(), HomeContract.View, FlickerAdapter.OnListItemClickListener {
  @Inject
  lateinit var presenter: HomePresenter

  @BindView(R.id.recyclerView)
  lateinit var recyclerView: RecyclerView

  private lateinit var adapter: FlickerAdapter
  private val photos = ArrayList<Photo>()

  init {
    Timber.d("Reached")
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    (activity as HomeActivity).getHomeComponent().inject(this)
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater!!.inflate(R.layout.fragment_home, container, false)
    ButterKnife.bind(this, view)

    val gridLayoutManager = GridLayoutManager(activity, 3)
    this.recyclerView.layoutManager = gridLayoutManager
    this.adapter = FlickerAdapter(this.photos, R.layout.fragment_home_flicker_list_item, this.context, this)
    this.recyclerView.adapter = this.adapter

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

  override fun onItemClick(pPhoto: Photo) {
    context.toast("Position clicked is " + pPhoto.title)
  }

  override fun updateView(photoInfo: PhotoInfo) {
    val photos = photoInfo.photos.photos as List<Photo>?
    if (photos != null && !photos.isEmpty()) {
      this.photos.addAll(photos)
      this.adapter.notifyDataSetChanged()
    }
  }
}