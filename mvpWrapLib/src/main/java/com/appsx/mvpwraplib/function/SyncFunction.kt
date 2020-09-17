package com.appsx.mvpwraplib.function

import com.appsx.mvpwraplib.common.IFunction

class SyncFunction(
    private val syncObject: Any
) : IFunction {
    override fun accept(f: () -> Unit) {
        synchronized(syncObject, f)
    }
}