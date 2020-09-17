package com.appsx.mvpWrapSample.main

import androidx.appcompat.app.AppCompatActivity
import com.appsx.mvpWrapSample.provider.AppFunctionStackProvider
import com.appsx.mvpwraplib.common.IFunction

abstract class BaseActivity : AppCompatActivity() {

    fun <T : Any> wrapToProxy(any: T, handler: IFunction): T {
        return AppFunctionStackProvider.get(applicationContext).wrapToProxy(any, handler)
    }

    fun buildViewFunctionCallStack(logTag: String): IFunction {
        return AppFunctionStackProvider.get(applicationContext).buildViewFunctionCallStack(logTag)
    }

    fun buildPresenterFunctionCallStack(logTag: String): IFunction {
        return AppFunctionStackProvider.get(applicationContext)
            .buildPresenterFunctionCallStack(logTag)
    }
}