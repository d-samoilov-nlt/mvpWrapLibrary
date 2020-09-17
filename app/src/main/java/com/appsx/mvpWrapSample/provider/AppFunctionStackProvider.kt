package com.appsx.mvpWrapSample.provider

import com.appsx.mvpWrapSample.common.AppFunctionStackBuilder

class AppFunctionStackProvider {

    companion object {
        private var functionBuilder: AppFunctionStackBuilder? = null

        fun get(): AppFunctionStackBuilder {
            if (functionBuilder == null) {
                synchronized(this) {
                    if (functionBuilder == null) {
                        functionBuilder = AppFunctionStackBuilder()
                    }
                }
            }

            return functionBuilder!!
        }
    }
}