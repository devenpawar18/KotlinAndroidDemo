package com.kotlinandroiddemo.util.service

import io.reactivex.functions.Consumer

/**
 * Created by Deven on 10/20/17.
 */
interface ISuccessCallback<T> : Consumer<T> {

}