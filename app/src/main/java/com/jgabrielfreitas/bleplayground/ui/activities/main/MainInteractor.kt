package com.jgabrielfreitas.bleplayground.ui.activities.main

import com.jgabrielfreitas.bleplayground.model.bluetooth.LeDevice

/**
 * Created by JGabrielFreitas on 11/08/17.
 */
interface MainInteractor {

  fun startSearch()

  fun stopSearch()

  fun addDevice(device: LeDevice)

}