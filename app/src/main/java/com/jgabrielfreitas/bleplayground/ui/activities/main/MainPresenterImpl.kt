package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.bluetooth.BluetoothDevice
import com.jgabrielfreitas.bleplayground.model.bluetooth.LeDevice
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnFinishedListener
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnNewDeviceFoundListener


/**
 * Created by JGabrielFreitas on 10/08/17.
 */
class MainPresenterImpl(var view: MainView?, var interactor: MainInteractor) : MainPresenter, OnFinishedListener, OnNewDeviceFoundListener {

  override fun onFinished() = stopSearch()

  override fun onResume() = interactor.setListeners(this, this)

  override fun startSearch() {
    view!!.startLoad()
    interactor.startSearch()
  }

  override fun stopSearch() = view!!.stopLoad()

  override fun cleanSearch() = view!!.cleanSearch()

  override fun onItemClicked(position: Int, device: LeDevice) = view!!.displayMessage("Device ${device.macAddress}")

  override fun onDestroy() {
    view = null
  }

  override fun addDevice(item: BluetoothDevice) {
    if (item.name != null) { view!!.addItem(item) }
  }

}