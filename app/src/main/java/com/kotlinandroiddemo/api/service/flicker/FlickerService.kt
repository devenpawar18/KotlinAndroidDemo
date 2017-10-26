package com.kotlinandroiddemo.api.service.flicker

import com.kotlinandroiddemo.api.model.PhotoInfo
import com.kotlinandroiddemo.api.service.util.ServiceAdapterWrapper
import com.kotlinandroiddemo.application.scope.ApplicationScope
import io.reactivex.Observable
import org.greenrobot.eventbus.EventBus
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Deven on 10/20/17.
 */
@ApplicationScope
class FlickerService @Inject constructor(eventBus: EventBus) {
  private val flickerService = ServiceAdapterWrapper.wrapService(IFlickerService::class.java, eventBus)

  fun getPhotoInfo(method: String, apiKey: String, format: String, noJsonCallback: String, text: String, page: Int): Observable<Response<PhotoInfo>> {
    return flickerService.getPhotoInfo(method, apiKey, format, noJsonCallback, text, page)
  }
}