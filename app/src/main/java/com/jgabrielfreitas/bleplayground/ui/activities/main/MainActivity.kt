package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.os.Bundle
import com.jgabrielfreitas.bleplayground.R.layout.activity_main
import com.jgabrielfreitas.core.activity.BaseActivity
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main.startButton
import kotlinx.android.synthetic.main.activity_main.stopButton
import android.view.View.GONE as gone
import android.view.View.VISIBLE as visible
import com.jgabrielfreitas.bleplayground.ui.activities.main.MainPresenter.View as MainView

@InjectLayout(layout = activity_main)
class MainActivity : BaseActivity(), MainView {

  lateinit var presenter: MainPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter = MainPresenterImplementation(this, MainInteractorImplementation())
    startButton.setOnClickListener { presenter.startClicked() }
    stopButton.setOnClickListener { presenter.stopClicked() }
  }

  override fun startLoad() {
    progressBar.visibility = visible
  }

  override fun stopLoad() {
    progressBar.visibility = gone
  }

  override fun listUpdate() {
  }

}
