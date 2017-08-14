package com.jgabrielfreitas.bleplayground.ui.activities.main

import com.jgabrielfreitas.bleplayground.model.bluetooth.LeDevice
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnFinishedListener

/**
 * Created by JGabrielFreitas on 11/08/17.
 */
class MainInteractorImplementation(var findDevices: FindBluetoothDevicesInteractor) : MainInteractor {

  lateinit var onFinishedListener: OnFinishedListener

  override fun setListener(listener: OnFinishedListener) {
    this.onFinishedListener = listener
  }

  override fun startSearch() {
    findDevices.findDevices(onFinishedListener)
  }

  override fun stopSearch() {
  }

  override fun addDevice(device: LeDevice) {
  }
}