package com.bilalqwatly.kroma.presentation.exception

import androidx.annotation.StringRes
import com.bilalqwatly.kroma.R


object ExceptionFactory {
    @get:StringRes
    val string: Int
        get() = R.string.no_internet_connection
}