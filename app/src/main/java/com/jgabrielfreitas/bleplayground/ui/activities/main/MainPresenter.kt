package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.content.Context
import android.widget.ProgressBar

/**
 * Created by JGabrielFreitas on 10/08/17.
 */
interface MainPresenter {

  fun startLoad()

  fun stopLoad()


  interface View {
    fun getProgressBar(): ProgressBar
  }

}