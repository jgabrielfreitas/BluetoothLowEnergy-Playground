package com.jgabrielfreitas.bleplayground

import android.support.design.widget.BottomNavigationView
import com.jgabrielfreitas.bleplayground.R.layout.activity_main
import com.jgabrielfreitas.core.activity.BaseActivity
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import kotlinx.android.synthetic.main.activity_main.message
import kotlinx.android.synthetic.main.activity_main.navigation

@InjectLayout(layout = activity_main)
class MainActivity : BaseActivity() {

  override fun modifyViews() {
    super.modifyViews()
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
  }

  private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
      R.id.navigation_home -> {
        message.text = getString(R.string.title_home)
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_dashboard -> {
        message.text = getString(R.string.bluetooth)
        return@OnNavigationItemSelectedListener true
      }
    }
    false
  }
}
