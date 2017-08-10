package com.jgabrielfreitas.bleplayground.ui.activities.main

import android.widget.ProgressBar
import butterknife.OnClick
import com.jgabrielfreitas.bleplayground.R
import com.jgabrielfreitas.bleplayground.R.layout.activity_main
import com.jgabrielfreitas.bleplayground.ui.activities.main.MainPresenter.View
import com.jgabrielfreitas.core.activity.BaseActivity
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import kotlinx.android.synthetic.main.activity_main.*

@InjectLayout(layout = activity_main)
class MainActivity : BaseActivity(), View{

  val presenter: MainPresenter = MainPresenterImplementation(this)

  @OnClick(R.id.startButton)
  fun startLoad(){
    presenter.startLoad()
  }

  @OnClick(R.id.stopButton)
  fun stopLoad(){
    presenter.stopLoad()
  }

  override fun getProgressBar(): ProgressBar = progressBar

}
