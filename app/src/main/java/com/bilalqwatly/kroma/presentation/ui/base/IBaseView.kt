package com.bilalqwatly.kroma.presentation.ui.base

import androidx.annotation.StringRes

interface IBaseView {
    fun showMessage(message: String?)
    fun showMessage(@StringRes stringId: Int)
}