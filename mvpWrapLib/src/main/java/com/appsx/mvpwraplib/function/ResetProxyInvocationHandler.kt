package com.appsx.mvpwraplib.function

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.util.concurrent.atomic.AtomicBoolean

class ResetProxyInvocationHandler(
    private val origin: Any,
    private val isAvailable: AtomicBoolean
) : InvocationHandler {

    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        if (isAvailable.get()) {
            return if (args == null) {
                method!!.invoke(origin)
            } else {
                method!!.invoke(origin, *args)
            }
        }

        throw IllegalStateException("cached instance not available")
    }

}