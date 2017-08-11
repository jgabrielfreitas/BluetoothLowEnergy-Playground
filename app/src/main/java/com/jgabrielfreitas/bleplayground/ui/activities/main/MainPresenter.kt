package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.content.Context

/**
 * Created by JGabrielFreitas on 10/08/17.
 */
interface MainPresenter {

  fun startClicked()

  fun stopClicked()

  fun onDestroy()

  interface View {

    fun startLoad()

    fun stopLoad()

    fun listUpdate()

  }

}