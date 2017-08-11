package com.jgabrielfreitas.bleplayground.ui.activities.main

import com.jgabrielfreitas.bleplayground.ui.activities.main.MainPresenter.View

/**
 * Created by JGabrielFreitas on 10/08/17.
 */
class MainPresenterImplementation(var view: View?, var interactor: MainInteractor) : MainPresenter {

  override fun startClicked() {
    view!!.startLoad()
    interactor.startSearch()
  }

  override fun stopClicked() {
    view!!.stopLoad()
  }

  override fun onDestroy() {
    view = null
  }

}