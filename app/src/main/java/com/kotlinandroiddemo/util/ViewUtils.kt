package com.kotlinandroiddemo.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Created by Deven on 10/20/17.
 */
class ViewUtils {
  companion object {
    fun <T> checkNotNull(reference: T, erroeMessage: Any): T {
      if (reference == null) {
        throw NullPointerException(erroeMessage as? String)
      } else {
        return reference
      }
    }

    fun <T> checkNotNull(reference: T): T {
      if (reference == null) {
        throw NullPointerException()
      } else {
        return reference
      }
    }

    fun addViewToActivity(fragmentManager: FragmentManager, fragment: Fragment, frameId: Int) {
      checkNotNull(fragmentManager)
      checkNotNull(fragment)
      val transaction: FragmentTransaction = fragmentManager.beginTransaction()
      transaction.add(frameId, fragment)
      transaction.commit()
    }
  }
}