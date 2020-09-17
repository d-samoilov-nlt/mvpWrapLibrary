package com.appsx.mvpWrapSample.main

import android.os.Bundle
import com.appsx.mvpWrapSample.R
import com.appsx.mvpWrapSample.main.presenter.IMainPresenter
import com.appsx.mvpWrapSample.main.presenter.MainPresenter
import com.appsx.mvpWrapSample.main.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private lateinit var presenter: IMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = wrapToProxy(
            MainPresenter(
                wrapToProxy(
                    MainView(container),
                    buildViewFunctionCallStack(this::class.java.simpleName)
                )
            ),
            buildPresenterFunctionCallStack(this::class.java.simpleName)
        )

        presenter.onCreate()
    }
}