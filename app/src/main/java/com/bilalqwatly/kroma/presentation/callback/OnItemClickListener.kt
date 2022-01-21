package com.bilalqwatly.kroma.presentation.callback

interface OnItemClickListener<T> {
    fun onClick(item: T, position: Int)
}