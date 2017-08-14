package com.jgabrielfreitas.bleplayground.ui.activities.main

import com.jgabrielfreitas.bleplayground.model.bluetooth.LeDevice

/**
 * Created by JGabrielFreitas on 10/08/17.
 */
interface MainPresenter {

  fun onResume()

  fun startClicked()

  fun stopClicked()

  fun onItemClicked(position: Int, device: LeDevice)

  fun onDestroy()

}