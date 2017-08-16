package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.bluetooth.BluetoothDevice
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnFinishedListener
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnNewDeviceFoundListener

/**
 * Created by JGabrielFreitas on 11/08/17.
 */
interface MainInteractor {

  fun setListeners(onFinished: OnFinishedListener, onNewDevice: OnNewDeviceFoundListener)

  fun startSearch()

  fun stopSearch()

  fun addDevice(device: BluetoothDevice)

}