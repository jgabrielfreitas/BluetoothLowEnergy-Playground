package com.jgabrielfreitas.bleplayground.ui.activities.main

import com.jgabrielfreitas.bleplayground.model.bluetooth.LeDevice

/**
 * Created by JGabrielFreitas on 14/08/17.
 */
interface MainView {

  fun startLoad()

  fun stopLoad()

  fun addItem(item: LeDevice)
}