package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.bluetooth.BluetoothDevice
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import com.jgabrielfreitas.bleplayground.R.layout.activity_main
import com.jgabrielfreitas.bleplayground.adapter.LeDeviceListAdapter
import com.jgabrielfreitas.bleplayground.extensions.toast
import com.jgabrielfreitas.core.activity.BaseActivity
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import kotlinx.android.synthetic.main.activity_main.bluetoothDevicesListView
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main.startButton
import kotlinx.android.synthetic.main.activity_main.stopButton
import android.R.layout.simple_list_item_1 as simple_list
import android.view.View.GONE as gone
import android.view.View.VISIBLE as visible

@InjectLayout(layout = activity_main)
class MainActivity : BaseActivity(), MainView, OnItemClickListener {

  lateinit var presenter: MainPresenter
  lateinit var lowEnergyDeviceListAdapter: LeDeviceListAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter = MainPresenterImplementation(this, MainInteractorImplementation(FindBluetoothDevicesInteractorImplementation(), this))
    lowEnergyDeviceListAdapter = LeDeviceListAdapter(this, simple_list)
    startButton.setOnClickListener { presenter.startClicked() }
    stopButton.setOnClickListener { presenter.stopClicked() }

    bluetoothDevicesListView.adapter = lowEnergyDeviceListAdapter
    bluetoothDevicesListView.onItemClickListener = this
  }

  override fun startLoad() {
    progressBar.visibility = visible
  }

  override fun stopLoad() {
    progressBar.visibility = gone
  }

  override fun onResume() {
    super.onResume()
    presenter.onResume()
  }

  override fun onDestroy() {
    presenter.onDestroy()
    super.onDestroy()
  }

  override fun addItem(item: BluetoothDevice) {
    lowEnergyDeviceListAdapter.addDevice(item)
    lowEnergyDeviceListAdapter.notifyDataSetChanged()
  }

  override fun onItemClick(adapter: AdapterView<*>?, view: View?, position: Int, args: Long) {
    presenter.onItemClicked(position, lowEnergyDeviceListAdapter.getItem(position))
  }

  override fun displayMessage(message: String) {
    toast(message)
  }
}
