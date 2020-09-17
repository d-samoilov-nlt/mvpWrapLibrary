package com.appsx.mvpWrapSample.main.presenter

import com.appsx.mvpWrapSample.main.view.IMainView

class MainPresenter(
    private val view: IMainView
) : IMainPresenter {

    override fun onCreate() {
        Thread.sleep(5 * 1000)
        view.show("Hello MVP")
    }
}