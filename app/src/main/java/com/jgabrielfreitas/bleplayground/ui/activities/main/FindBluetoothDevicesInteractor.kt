package com.jgabrielfreitas.bleplayground.ui.activities.main

/**
 * Created by JGabrielFreitas on 14/08/17.
 */
interface FindBluetoothDevicesInteractor {

  fun findDevices(listener: OnFinishedListener)

  interface OnFinishedListener {
    fun onFinished(items: List<String>)
  }

}