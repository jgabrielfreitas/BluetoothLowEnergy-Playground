package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.content.Context
import com.jgabrielfreitas.bleplayground.model.bluetooth.LeDevice
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnNewDeviceFoundListener
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnFinishedListener

/**
 * Created by JGabrielFreitas on 11/08/17.
 */
class MainInteractorImplementation(var findDevices: FindBluetoothDevicesInteractor, var context: Context) : MainInteractor {

  lateinit var onFinishedListener: OnFinishedListener
  lateinit var newDeviceListener: OnNewDeviceFoundListener

  override fun setListeners(onFinished: OnFinishedListener, onNewDevice: OnNewDeviceFoundListener) {
    onFinishedListener = onFinished
    newDeviceListener = onNewDevice
  }

  override fun startSearch() {
    findDevices.findDevices(newDeviceListener, onFinishedListener, context)
  }

  override fun stopSearch() {
  }

  override fun addDevice(device: LeDevice) {
  }
}