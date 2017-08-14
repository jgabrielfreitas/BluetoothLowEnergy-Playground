package com.jgabrielfreitas.bleplayground.bluetooth

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothAdapter.LeScanCallback
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context
import android.os.Handler
import android.util.Log
import com.jgabrielfreitas.bleplayground.adapter.LeDeviceListAdapter
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnFinishedListener
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnNewDeviceFoundListener

/**
 * Created by JGabrielFreitas on 14/08/17.
 */

class Bluetooth(private val context: Context, val onNewDeviceListener: OnNewDeviceFoundListener, val onFinishedListener: OnFinishedListener) {

  val mBluetoothAdapter: BluetoothAdapter
  var mScanning: Boolean = false
  val mHandler: Handler
  val mLeScanCallback = LeScanCallback { device, _, _ -> if (context is Activity) context.runOnUiThread { onNewDeviceListener.addDevice(device) } }

  init {
    val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    this.mBluetoothAdapter = bluetoothManager.adapter
    this.mHandler = Handler()
  }

  fun startSearch() {
    scanLeDevice(true)
  }

  private fun scanLeDevice(enable: Boolean) {
    Log.e("device", "starting scanLeDevice")
    if (enable) {
      // Stops scanning after a pre-defined scan period.
      mHandler.postDelayed({
        mScanning = false
        mBluetoothAdapter.stopLeScan(mLeScanCallback)
        onFinishedListener.onFinished()
      }, SCAN_PERIOD.toLong())

      mScanning = true
      mBluetoothAdapter.startLeScan(mLeScanCallback)
    } else {
      mScanning = false
      mBluetoothAdapter.stopLeScan(mLeScanCallback)
      onFinishedListener.onFinished()
    }
  }

  companion object {

    private val ONE_SECOND = 1000
    private val SCAN_PERIOD = ONE_SECOND
  }

}
