package com.appsx.mvpWrapSample.common

import android.content.Context
import android.widget.Toast
import com.appsx.mvpwraplib.FunctionStackBuilder
import com.appsx.mvpwraplib.function.ErrorLoggableFunction
import com.appsx.mvpwraplib.view.IErrorMessageView
import com.appsx.mvpwraplib.view.IProgressView

class AppFunctionStackBuilder(
    private val applicationContext: Context
) : FunctionStackBuilder() {

    override fun getIsConsoleLogEnabled(): Boolean = true

    override fun getErrorMessageView(): IErrorMessageView {
        return wrapToProxy(
            object : IErrorMessageView {
                override fun show(msg: String) {
                    Toast.makeText(
                        applicationContext,
                        msg,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            buildViewFunctionCallStack(this::class.java.simpleName)
        )
    }

    override fun getProgressView(): IProgressView {
        return wrapToProxy(
            object : IProgressView {
                private var toast: Toast? = null

                override fun show() {
                    getDialog().show()
                }

                override fun hide() {
                    // nop
                }

                private fun getDialog(): Toast {
                    if (toast == null) {
                        synchronized(this) {
                            if (toast == null) {
                                toast = Toast.makeText(
                                    applicationContext,
                                    "Loading...",
                                    Toast.LENGTH_SHORT
                                )
                            }
                        }
                    }

                    return toast!!
                }
            },
            buildViewFunctionCallStack(this::class.java.simpleName)
        )
    }

    override fun getRemoteLog(): ErrorLoggableFunction.IRemoteLog? {
        // You can log with Crashlytics here
        return null
    }
}