package com.jgabrielfreitas.bleplayground.extensions

import android.bluetooth.BluetoothDevice

/**
 * Created by JGabrielFreitas on 16/08/17.
 */

fun BluetoothDevice.row() = name

fun BluetoothDevice.toString() = name