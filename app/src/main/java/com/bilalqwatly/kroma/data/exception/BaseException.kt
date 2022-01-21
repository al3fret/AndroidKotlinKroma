package com.bilalqwatly.kroma.data.exception

import java.lang.Exception

class BaseException : Exception {
    constructor()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}