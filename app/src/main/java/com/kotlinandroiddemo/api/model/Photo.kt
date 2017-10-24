package com.kotlinandroiddemo.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Deven on 10/20/17.
 */
data class Photo(@SerializedName("id") val id: Long, @SerializedName("owner") val owner: String,
                 @SerializedName("secret") val secret: String, @SerializedName("server") val server: String,
                 @SerializedName("farm") val farm: Int, @SerializedName("title") val title: String,
                 @SerializedName("public") val public: Int, @SerializedName("friend") val friend: Int,
                 @SerializedName("family") val family: Int)