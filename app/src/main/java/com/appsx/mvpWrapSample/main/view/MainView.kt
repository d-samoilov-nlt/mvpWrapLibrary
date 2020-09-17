package com.appsx.mvpWrapSample.main.view

import android.view.View
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_main.view.*

class MainView(override val containerView: View) : IMainView, LayoutContainer {

    override fun show(msg: String) {
        containerView.textView.text = msg
    }
}