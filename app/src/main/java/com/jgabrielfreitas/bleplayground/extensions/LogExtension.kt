package com.jgabrielfreitas.bleplayground.extensions

import android.util.Log

/**
 * Created by JGabrielFreitas on 14/08/17.
 */

fun Any.log(message:String = "") = Log.e("Logger", message)