package com.appsx.mvpwraplib.common

class FunctionCall : IFunction {
    override fun accept(f: () -> Unit) {
        f.invoke()
    }
}