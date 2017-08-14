package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.util.Log
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnFinishedListener


/**
 * Created by JGabrielFreitas on 10/08/17.
 */
class MainPresenterImplementation(var view: MainView?, var interactor: MainInteractor) : MainPresenter, OnFinishedListener {

  override fun onFinished(items: List<String>) {
    stopClicked()
    view!!.setItems(items)
  }

  override fun onResume() {
    interactor.setListener(this)
    view!!.setItems(mutableListOf("No devices"))
  }

  override fun startClicked() {
    view!!.startLoad()
    interactor.startSearch()
  }

  override fun stopClicked() {
    view!!.stopLoad()
  }

  override fun onItemClicked(position: Int) {
    Log.e("position", "Position %d clicked ${position + 1}")
  }

  override fun onDestroy() {
    view = null
  }

}