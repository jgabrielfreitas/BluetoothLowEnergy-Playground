package com.jgabrielfreitas.bleplayground.bluetooth

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothAdapter.LeScanCallback
import android.bluetooth.BluetoothManager
import android.content.Context
import android.os.Handler
import com.jgabrielfreitas.bleplayground.ui.activities.main.MainInteractor

/**
 * Created by JGabrielFreitas on 14/08/17.
 */

class BluetoothLowEnergy(private val context: Context, val interactor: MainInteractor) {

  val bluetoothAdapter: BluetoothAdapter
  var scanning: Boolean = false
  val handler: Handler
  val leScanCallback = LeScanCallback { device, _, _ -> if (context is Activity) context.runOnUiThread { interactor.addDevice(device) } }

  val FOUR_SECONDS = 4000
  val SCAN_PERIOD  = FOUR_SECONDS

  init {
    val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    this.bluetoothAdapter = bluetoothManager.adapter
    this.handler = Handler()
  }

  fun startSearch() = scanLeDevice(true)

  private fun scanLeDevice(enable: Boolean) {
    if (enable) {
      // Stops scanning after a pre-defined scan period.
      handler.postDelayed({
        scanning = false
        bluetoothAdapter.stopLeScan(leScanCallback)
        interactor.stopSearch()
      }, SCAN_PERIOD.toLong())

      scanning = true
      bluetoothAdapter.startLeScan(leScanCallback)
    } else {
      scanning = false
      bluetoothAdapter.stopLeScan(leScanCallback)
      interactor.stopSearch()
    }
  }

}
