package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.R.layout.simple_list_item_1 as simple_list
import android.os.Bundle
import android.widget.ArrayAdapter
import com.jgabrielfreitas.bleplayground.R.layout.activity_main
import com.jgabrielfreitas.core.activity.BaseActivity
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import kotlinx.android.synthetic.main.activity_main.bluetoothDevicesListView
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main.startButton
import kotlinx.android.synthetic.main.activity_main.stopButton
import android.view.View.GONE as gone
import android.view.View.VISIBLE as visible

@InjectLayout(layout = activity_main)
class MainActivity : BaseActivity(), MainView {

  lateinit var presenter: MainPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter = MainPresenterImplementation(this, MainInteractorImplementation(FindBluetoothDevicesInteractorImplementation()))
    startButton.setOnClickListener { presenter.startClicked() }
    stopButton.setOnClickListener { presenter.stopClicked() }
  }

  override fun startLoad() {
    progressBar.visibility = visible
  }

  override fun stopLoad() {
    progressBar.visibility = gone
  }

  override fun setItems(items: List<String>) {
    bluetoothDevicesListView.adapter = ArrayAdapter<String>(this, simple_list, items)
  }

  override fun listUpdate() {
  }

  override fun onResume() {
    super.onResume()
    presenter.onResume()
  }

  override fun onDestroy() {
    presenter.onDestroy()
    super.onDestroy()
  }

  override fun addItem(item: String) {
    var adapter = bluetoothDevicesListView.adapter

  }
}
