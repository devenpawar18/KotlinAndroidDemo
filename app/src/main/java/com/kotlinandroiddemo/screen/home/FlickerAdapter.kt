package com.kotlinandroiddemo.screen.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.kotlinandroiddemo.R
import com.kotlinandroiddemo.api.model.Photo

/**
 * Created by Deven on 10/23/17.
 */

class FlickerAdapter(private val photos: List<Photo>, private val rowLayout: Int, private val context: Context, private val onListItemClickListener: OnListItemClickListener) : RecyclerView.Adapter<FlickerAdapter.FlickerViewHolder>() {

  inner class FlickerViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
    @BindView(R.id.flickerImage)
    lateinit var flickerImage: ImageView

    init {
      ButterKnife.bind(this, view)

      view.setOnClickListener(this)
    }

    override fun onClick(pView: View) {
      val item = photos[this.layoutPosition]
      onListItemClickListener.onItemClick(item)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlickerAdapter.FlickerViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
    return FlickerViewHolder(view)
  }

  override fun onBindViewHolder(holder: FlickerViewHolder, position: Int) {
    val photo = this.photos[position]
    val url = this.context.resources.getString(R.string.flickr_image_url, photo.farm.toString(), photo.server, photo.id.toString(), photo.secret)
    Glide.with(this.context).load(url).centerCrop().placeholder(R.drawable.flicker_photo).crossFade().into(holder.flickerImage)
  }

  override fun getItemCount(): Int {
    return this.photos.size
  }

  interface OnListItemClickListener {
    fun onItemClick(pPhoto: Photo)
  }
}