package com.appsx.mvpwraplib.function

import com.appsx.mvpwraplib.common.IFunction
import com.appsx.mvpwraplib.view.IErrorMessageView

class SafeFunction(
    private val origin: IFunction,
    private val view: IErrorMessageView
) : IFunction {
    override fun accept(f: () -> Unit) {
        try {
            origin.accept(f)
        } catch (e: Throwable) {
            try {
                view.show(e.cause!!.message!!)
            } catch (exception: KotlinNullPointerException) {
                view.show(e.toString())
            }
        }
    }
}