package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.bluetooth.BluetoothDevice
import android.content.Context

/**
 * Created by JGabrielFreitas on 14/08/17.
 */
interface FindBluetoothDevicesInteractor {

  fun findDevices(newDeviceFound: OnNewDeviceFoundListener, onFinished: OnFinishedListener, context: Context)

  interface OnFinishedListener {
    fun onFinished()
  }

  interface OnNewDeviceFoundListener {
    fun addDevice(item: BluetoothDevice)
  }

}