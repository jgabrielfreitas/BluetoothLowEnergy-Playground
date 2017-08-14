package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.content.Context

/**
 * Created by JGabrielFreitas on 10/08/17.
 */
interface MainPresenter {

  fun onResume()

  fun startClicked()

  fun stopClicked()

  fun onItemClicked(position: Int)

  fun onDestroy()

}