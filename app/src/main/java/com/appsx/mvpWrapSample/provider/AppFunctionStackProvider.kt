package com.appsx.mvpWrapSample.provider

import android.content.Context
import com.appsx.mvpWrapSample.common.AppFunctionStackBuilder

class AppFunctionStackProvider {

    companion object {
        private var functionBuilder: AppFunctionStackBuilder? = null

        fun get(applicationContext: Context): AppFunctionStackBuilder {
            if (functionBuilder == null) {
                synchronized(this) {
                    if (functionBuilder == null) {
                        functionBuilder = AppFunctionStackBuilder(applicationContext)
                    }
                }
            }

            return functionBuilder!!
        }
    }
}