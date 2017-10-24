package com.kotlinandroiddemo.screen.util

import android.app.ProgressDialog
import android.content.Context
import org.jetbrains.anko.indeterminateProgressDialog

/**
 * Created by Deven on 10/23/17.
 */
class PopupManager(val context: Context) {
  private var progressDialogs = HashMap<String, ProgressDialog>()

  fun showProgress(tag: String, message: String) {
    val progressDialog = context.indeterminateProgressDialog(message)
    progressDialogs.put(tag, progressDialog)
  }

  fun dismissProgress(tag: String): Boolean {
    val progressDialog: ProgressDialog? = progressDialogs.remove(tag)
    if (progressDialog == null) {
      return false
    }

    progressDialog.dismiss()
    return true
  }
}