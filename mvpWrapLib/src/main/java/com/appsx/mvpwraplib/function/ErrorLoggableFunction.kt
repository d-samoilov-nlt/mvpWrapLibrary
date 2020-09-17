package com.appsx.mvpwraplib.function

import android.util.Log
import com.appsx.mvpwraplib.common.IFunction

class ErrorLoggableFunction(
    private val origin: IFunction,
    private val TAG: String,
    private val logToConsole: Boolean,
    private val remoteLog: IRemoteLog? = null
) : IFunction {
    override fun accept(f: () -> Unit) {
        try {
            origin.accept(f)
        } catch (e: Exception) {
            if (logToConsole) {
                Log.e(TAG, f.toString(), e)
            } else remoteLog?.log(e)

            throw e
        }
    }

    interface IRemoteLog {
        fun log(e: java.lang.Exception)
    }
}