package com.appsx.mvpwraplib.function

import android.os.Handler
import android.os.Looper
import com.appsx.mvpwraplib.common.IFunction

class InMainThreadFunction(
    private val origin: IFunction
) : IFunction {

    private val handler: Handler = Handler(Looper.getMainLooper())

    override fun accept(f: () -> Unit) {
        if (Looper.getMainLooper().thread == Thread.currentThread()) {
            origin.accept(f)
        } else {
            this.handler.post { origin.accept(f) }
        }
    }
}