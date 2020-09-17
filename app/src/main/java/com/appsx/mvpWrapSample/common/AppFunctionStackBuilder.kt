package com.appsx.mvpWrapSample.common

import com.appsx.mvpwraplib.FunctionStackBuilder
import com.appsx.mvpwraplib.function.ErrorLoggableFunction
import com.appsx.mvpwraplib.view.IErrorMessageView
import com.appsx.mvpwraplib.view.IProgressView

class AppFunctionStackBuilder : FunctionStackBuilder() {

    override fun getIsConsoleLogEnabled(): Boolean = true

    override fun getErrorMessageView(): IErrorMessageView {
        return object : IErrorMessageView {
            override fun show(msg: String) {
                //nop
            }
        }
    }

    override fun getProgressView(): IProgressView {
        return object : IProgressView {
            override fun show() {
                // nop
            }

            override fun hide() {
                // nop
            }
        }
    }

    override fun getRemoteLog(): ErrorLoggableFunction.IRemoteLog? {
        // You can log with Crashlytics here
        return null
    }
}