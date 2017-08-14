package com.jgabrielfreitas.bleplayground.model.bluetooth

/**
 * Created by JGabrielFreitas on 10/08/17.
 */
data class LeDevice(var name: String, val macAddress: String) {

  override fun toString(): String = "$name : $macAddress"
}

