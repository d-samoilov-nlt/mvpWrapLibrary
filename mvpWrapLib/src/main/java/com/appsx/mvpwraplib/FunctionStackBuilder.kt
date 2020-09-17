package com.appsx.mvpwraplib

import com.appsx.mvpwraplib.common.FunctionCall
import com.appsx.mvpwraplib.common.IFunction
import com.appsx.mvpwraplib.function.*
import com.appsx.mvpwraplib.handler.FunctionProxyInvocationHandler
import com.appsx.mvpwraplib.view.IErrorMessageView
import com.appsx.mvpwraplib.view.IProgressView
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy
import java.util.concurrent.Executors

abstract class FunctionStackBuilder {
    abstract fun getIsConsoleLogEnabled(): Boolean
    abstract fun getErrorMessageView(): IErrorMessageView
    abstract fun getProgressView(): IProgressView
    abstract fun getRemoteLog(): ErrorLoggableFunction.IRemoteLog?

    fun buildPresenterFunctionCallStack(
        logTag: String
    ): IFunction {
        return AsyncFunction(
            ProgressFunction(
                SafeFunction(
                    ErrorLoggableFunction(
                        FunctionCall(),
                        logTag,
                        getIsConsoleLogEnabled(),
                        getRemoteLog()
                    ),
                    getErrorMessageView()
                ),
                getProgressView()
            ),
            Executors.newCachedThreadPool()
        )
    }

    fun buildViewFunctionCallStack(logTag: String): IFunction {
        return InMainThreadFunction(
            SafeFunction(
                ErrorLoggableFunction(
                    FunctionCall(),
                    logTag,
                    getIsConsoleLogEnabled(),
                    getRemoteLog()
                ),
                getErrorMessageView()
            )
        )
    }

    fun <T : Any> wrapToProxy(any: T, f: IFunction): T {
        return wrapToProxy(
            any,
            FunctionProxyInvocationHandler(
                any,
                f
            )
        )
    }

    fun <T : Any> wrapToProxy(any: T, handler: InvocationHandler): T {
        return Proxy.newProxyInstance(
            any::class.java.classLoader,
            any::class.java.interfaces,
            handler
        ) as T
    }
}