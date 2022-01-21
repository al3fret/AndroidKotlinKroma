package com.bilalqwatly.kroma.presentation.ui

import androidx.annotation.StringRes

interface IBaseView {
    fun showMessage(message: String?)
    fun showMessage(@StringRes stringId: Int)
    fun hideKeyboard()
}