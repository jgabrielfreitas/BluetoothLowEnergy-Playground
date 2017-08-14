package com.jgabrielfreitas.bleplayground.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.jgabrielfreitas.bleplayground.adapter.LeDeviceListAdapter;
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnFinishedListener;
import com.jgabrielfreitas.bleplayground.ui.activities.main.FindBluetoothDevicesInteractor.OnNewDeviceFoundListener;

/**
 * Created by JGabrielFreitas on 14/08/17.
 */

public class Bluetooth {

  private Context context;
  private BluetoothAdapter mBluetoothAdapter;
  private boolean mScanning;
  private Handler mHandler;
  private OnNewDeviceFoundListener onNewDeviceListener;
  private OnFinishedListener onFinishedListener;

  private static final int ONE_SECOND  = 1_000;
  private static final int SCAN_PERIOD = ONE_SECOND;

  private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {
    @Override public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {
      if (context instanceof Activity) {
        ((Activity) context).runOnUiThread(new Runnable() {
          @Override public void run() {
            onNewDeviceListener.addDevice(device);
          }
        });
      }
    }
  };

  public Bluetooth(Context context, OnNewDeviceFoundListener onNewDeviceListener, OnFinishedListener onFinishedListener) {
    this.context = context;
    final BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
    this.mBluetoothAdapter = bluetoothManager.getAdapter();
    this.mHandler = new Handler();
    this.onNewDeviceListener = onNewDeviceListener;
    this.onFinishedListener = onFinishedListener;
  }

  public void startSearch(){
    scanLeDevice(true);
  }

  private void scanLeDevice(final boolean enable) {
    Log.e("device", "starting scanLeDevice");
    if (enable) {
      // Stops scanning after a pre-defined scan period.
      mHandler.postDelayed(new Runnable() {
        @Override public void run() {
          mScanning = false;
          mBluetoothAdapter.stopLeScan(mLeScanCallback);
          onFinishedListener.onFinished();
        }
      }, SCAN_PERIOD);

      mScanning = true;
      mBluetoothAdapter.startLeScan(mLeScanCallback);
    } else {
      mScanning = false;
      mBluetoothAdapter.stopLeScan(mLeScanCallback);
      onFinishedListener.onFinished();
    }
  }

}
