package com.kotlinandroiddemo.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Deven on 10/20/17.
 */
data class PhotoInfo(@SerializedName("photos") val photos: Photos)