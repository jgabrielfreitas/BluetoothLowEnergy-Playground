package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.os.Handler
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnFinishedListener
import java.util.Arrays

/**
 * Created by JGabrielFreitas on 14/08/17.
 */
class FindBluetoothDevicesInteractorImplementation : FindBluetoothDevicesInteractor {

  override fun findDevices(listener: OnFinishedListener) {
    Handler().postDelayed({ listener.onFinished(createArrayList()) }, 2000)
  }

  private fun createArrayList(): List<String> {
    return Arrays.asList(
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5"
    )
  }
}