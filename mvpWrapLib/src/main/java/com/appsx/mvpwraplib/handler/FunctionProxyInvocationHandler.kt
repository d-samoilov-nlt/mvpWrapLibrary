package com.appsx.mvpwraplib.handler

import com.appsx.mvpwraplib.common.IFunction
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

class FunctionProxyInvocationHandler(
    private val origin: Any,
    private val f: IFunction
) : InvocationHandler {

    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any {
        return f.accept {
            if (args == null) {
                method!!.invoke(origin)
            } else {
                method!!.invoke(origin, *args)
            }
        }
    }
}