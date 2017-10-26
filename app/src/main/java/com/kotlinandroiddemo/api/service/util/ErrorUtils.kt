package com.kotlinandroiddemo.api.service.util

import retrofit2.Response
import java.io.IOException


/**
 * Created by Deven on 10/26/17.
 */
class ErrorUtils {
  companion object {
    fun parseError(response: Response<*>): ApiError {
      val converter = ServiceAdapterWrapper.wrapService()
        .responseBodyConverter<ApiError>(ApiError::class.java, arrayOfNulls<Annotation>(0))

      val error: ApiError

      try {
        error = converter.convert(response.errorBody())
      } catch (e: IOException) {
        return ApiError()
      }

      return error
    }
  }
}