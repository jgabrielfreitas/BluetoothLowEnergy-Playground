package com.jgabrielfreitas.bleplayground.adapter

import android.bluetooth.BluetoothDevice
import android.content.Context
import android.support.annotation.LayoutRes
import android.widget.ArrayAdapter
import com.jgabrielfreitas.bleplayground.model.bluetooth.LeDevice

/**
 * Created by JGabrielFreitas on 14/08/17.
 */

class LeDeviceListAdapter(context: Context, @LayoutRes resource: Int) : ArrayAdapter<LeDevice>(context, resource) {

  var leDevices = mutableSetOf<BluetoothDevice>()

  fun addDevice(device: BluetoothDevice) {

    if (!leDevices.contains(device)) {
      leDevices.add(device)
      add(LeDevice(device.name ?: "NO NAME", device.address))
    }
  }
}
