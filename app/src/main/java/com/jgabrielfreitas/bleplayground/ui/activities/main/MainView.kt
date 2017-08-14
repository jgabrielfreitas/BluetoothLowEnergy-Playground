package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.bluetooth.BluetoothDevice

/**
 * Created by JGabrielFreitas on 14/08/17.
 */
interface MainView {

  fun startLoad()

  fun stopLoad()

  fun addItem(item: BluetoothDevice)

  fun displayMessage(message: String)
}