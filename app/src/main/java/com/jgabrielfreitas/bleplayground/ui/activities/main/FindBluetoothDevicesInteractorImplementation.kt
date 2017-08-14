package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.content.Context
import android.widget.ArrayAdapter
import com.jgabrielfreitas.bleplayground.bluetooth.Bluetooth
import com.jgabrielfreitas.bleplayground.model.bluetooth.LeDevice
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnFinishedListener
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnNewDeviceFoundListener

/**
 * Created by JGabrielFreitas on 14/08/17.
 */
class FindBluetoothDevicesInteractorImplementation : FindBluetoothDevicesInteractor {

  lateinit var bluetoothManager: Bluetooth

  override fun findDevices(newDeviceFound: OnNewDeviceFoundListener, onFinished: OnFinishedListener, context: Context) {
    bluetoothManager = Bluetooth(context, newDeviceFound, onFinished)
    bluetoothManager.startSearch()
  }

  fun getAdapter(): ArrayAdapter<LeDevice> {
    return bluetoothManager.leDeviceListAdapter
  }
}