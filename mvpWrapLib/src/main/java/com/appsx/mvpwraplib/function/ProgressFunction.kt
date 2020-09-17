package com.appsx.mvpwraplib.function

import com.appsx.mvpwraplib.common.IFunction
import com.appsx.mvpwraplib.view.IProgressView

class ProgressFunction(
    private val origin: IFunction,
    private val view: IProgressView
) : IFunction {
    override fun accept(f: () -> Unit) {
        try {
            view.show()
            origin.accept(f)
        } finally {
            view.hide()

        }
    }
}