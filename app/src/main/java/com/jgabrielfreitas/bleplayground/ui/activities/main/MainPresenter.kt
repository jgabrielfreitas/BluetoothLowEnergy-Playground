package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.bluetooth.BluetoothDevice

/**
 * Created by JGabrielFreitas on 10/08/17.
 */
interface MainPresenter {

  fun onResume()

  fun startSearch()

  fun stopSearch()

  fun cleanSearch()

  fun onItemClicked(position: Int, device: BluetoothDevice)

  fun onDestroy()

}