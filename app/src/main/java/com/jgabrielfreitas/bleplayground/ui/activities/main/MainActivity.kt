package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.bluetooth.BluetoothDevice
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.jgabrielfreitas.bleplayground.R.layout.activity_main
import com.jgabrielfreitas.bleplayground.adapter.LeDeviceListAdapter
import com.jgabrielfreitas.bleplayground.extensions.toast
import com.jgabrielfreitas.core.activity.BaseActivity
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import kotlinx.android.synthetic.main.activity_main.*
import android.R.layout.simple_list_item_1 as simple_list
import android.view.View.GONE as gone
import android.view.View.VISIBLE as visible

@InjectLayout(layout = activity_main)
class MainActivity : BaseActivity(), MainView {

  lateinit var presenter: MainPresenter
  lateinit var lowEnergyDeviceListAdapter: LeDeviceListAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter = MainPresenterImpl(this, MainInteractorImpl(FindBluetoothDevicesInteractorImpl(), this))
    lowEnergyDeviceListAdapter = instanceNewAdapter()
    startButton.setOnClickListener { presenter.startSearch() }
    stopButton.setOnClickListener { presenter.stopSearch() }
    cleanResultsButton.setOnClickListener { presenter.cleanSearch() }

    bluetoothDevicesListView.adapter = lowEnergyDeviceListAdapter
    bluetoothDevicesListView.setOnItemClickListener(this::onItemClick)
  }

  override fun startLoad() {
    progressBar.visibility = visible
  }

  override fun stopLoad() {
    progressBar.visibility = gone
  }

  override fun cleanSearch() {
    with(lowEnergyDeviceListAdapter) {
      clear()
      notifyDataSetChanged()
    }
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

  fun onItemClick(adapter: AdapterView<*>?, view: View?, position: Int, args: Long) {
    presenter.onItemClicked(position, lowEnergyDeviceListAdapter.getItem(position))
  }

  override fun displayMessage(message: String) = toast(message)

  fun instanceNewAdapter() = LeDeviceListAdapter(this, simple_list)

}
