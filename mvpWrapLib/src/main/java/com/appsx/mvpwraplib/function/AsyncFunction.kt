package com.appsx.mvpwraplib.function

import com.appsx.mvpwraplib.common.IFunction
import java.util.concurrent.ExecutorService

class AsyncFunction(
    private val origin: IFunction,
    private val service: ExecutorService
) : IFunction {

    override fun accept(f: () -> Unit) {
        service.execute { origin.accept(f) }
    }
}