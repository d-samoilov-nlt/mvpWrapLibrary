package com.appsx.mvpwraplib.function

import com.appsx.mvpwraplib.common.IFunction
import java.util.concurrent.locks.ReentrantLock

class TryLockFunction(
    private val origin: IFunction
) : IFunction {

    private val lock: ReentrantLock = ReentrantLock()

    override fun accept(f: () -> Unit) {
        if (lock.tryLock()) {
            try {
                origin.accept(f)
            } finally {
                lock.unlock()
            }
        }
    }
}