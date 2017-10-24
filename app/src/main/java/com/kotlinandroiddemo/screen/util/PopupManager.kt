package com.kotlinandroiddemo.screen.util

import android.app.ProgressDialog
import android.content.Context

/**
 * Created by Deven on 10/23/17.
 */
class PopupManager(val context: Context) {
  private var progressDialogs = HashMap<String, ProgressDialog>()

  fun showProgress(tag: String, message: String) {
    val progressDialog = ProgressDialog(this.context)
    progressDialog.setMessage(message)
    progressDialog.show()

    this.progressDialogs.put(tag, progressDialog)
  }

  fun dismissProgress(tag: String): Boolean {
    val progressDialog: ProgressDialog? = this.progressDialogs.remove(tag)
    if (progressDialog == null) {
      return false
    } else {
      progressDialog.dismiss()
      return true
    }
  }
}