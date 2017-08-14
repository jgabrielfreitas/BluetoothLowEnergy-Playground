package com.jgabrielfreitas.bleplayground.ui.activities.main

/**
 * Created by JGabrielFreitas on 14/08/17.
 */
interface MainView {

  fun startLoad()

  fun stopLoad()

  fun listUpdate()

  fun setItems(items: List<String>)

  fun addItem(item: String)
}