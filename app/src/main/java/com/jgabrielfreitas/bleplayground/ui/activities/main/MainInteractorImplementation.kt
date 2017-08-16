package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.bluetooth.BluetoothDevice
import android.content.Context
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnFinishedListener
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnNewDeviceFoundListener

/**
 * Created by JGabrielFreitas on 11/08/17.
 */
class MainInteractorImplementation(var findDevices: FindBluetoothDevicesInteractor, var context: Context) : MainInteractor {

  lateinit var onFinishedListener: OnFinishedListener
  lateinit var newDeviceListener : OnNewDeviceFoundListener

  override fun setListeners(onFinished: OnFinishedListener, onNewDevice: OnNewDeviceFoundListener) {
    onFinishedListener = onFinished
    newDeviceListener  = onNewDevice
  }

  override fun startSearch() = findDevices.findDevices(this, context)

  override fun stopSearch() {
    onFinishedListener.onFinished()
  }

  override fun addDevice(device: BluetoothDevice) {
    newDeviceListener.addDevice(device)
  }
}