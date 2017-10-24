package com.kotlinandroiddemo.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Deven on 10/20/17.
 */
data class Photos(@SerializedName("page") val page: Int, @SerializedName("pages") val pages: Int,
                  @SerializedName("perpage") val perpage: Int, @SerializedName("total") val total: Int,
                  @SerializedName("photo") val photos: List<Photo>)