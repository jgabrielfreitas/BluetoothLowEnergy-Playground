package com.jgabrielfreitas.bleplayground.extensions

import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

/**
 * Created by JGabrielFreitas on 10/08/17.
 */

fun Context.toast(any: Any, duration: Int = LENGTH_LONG) {
  toast(any.toString(), duration)
}

fun Context.toast(message: String, duration: Int = LENGTH_LONG) {
  Toast.makeText(this, message, duration).show()
}