package com.kotlinandroiddemo.api.service.flicker

import com.kotlinandroiddemo.api.model.PhotoInfo
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Deven on 10/20/17.
 */
interface IFlickerService {
  @GET("services/rest")
  fun getPhotoInfo(@Query("method") method: String, @Query("api_key") apiKey: String, @Query("format") format: String, @Query("nojsoncallback") noJsonCallback: String, @Query("text") text: String, @Query("page") page: Int): Observable<Response<PhotoInfo>>
}