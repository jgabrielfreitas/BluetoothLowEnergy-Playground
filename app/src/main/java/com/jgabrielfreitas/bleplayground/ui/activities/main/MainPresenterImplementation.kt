package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.content.Context
import com.jgabrielfreitas.bleplayground.extensions.toast

/**
 * Created by JGabrielFreitas on 10/08/17.
 */
class MainPresenterImplementation(var context: Context): MainPresenter {

  override fun startLoad() {

  }

  override fun stopLoad() {
    context.toast("stop load")
  }
}