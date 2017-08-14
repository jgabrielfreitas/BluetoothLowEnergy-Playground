package com.jgabrielfreitas.bleplayground.ui.activities.main

import com.jgabrielfreitas.bleplayground.model.bluetooth.LeDevice
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnNewDeviceFoundListener
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnFinishedListener

/**
 * Created by JGabrielFreitas on 11/08/17.
 */
interface MainInteractor {

  fun setListeners(onFinished: OnFinishedListener, onNewDevice: OnNewDeviceFoundListener)

  fun startSearch()

  fun stopSearch()

  fun addDevice(device: LeDevice)

}