package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.content.Context
import com.jgabrielfreitas.bleplayground.bluetooth.BluetoothLowEnergy

/**
 * Created by JGabrielFreitas on 14/08/17.
 */
class FindBluetoothDevicesInteractorImplementation : FindBluetoothDevicesInteractor {

  lateinit var bluetoothLowEnergyManager: BluetoothLowEnergy

  override fun findDevices(interactor: MainInteractor, context: Context) {
    bluetoothLowEnergyManager = BluetoothLowEnergy(context, interactor)
    bluetoothLowEnergyManager.startSearch()
  }

}