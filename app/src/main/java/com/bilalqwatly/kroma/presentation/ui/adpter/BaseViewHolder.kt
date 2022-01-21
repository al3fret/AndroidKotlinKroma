package com.bilalqwatly.kroma.presentation.ui.adpter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T, DB : ViewDataBinding>(var binding: DB) :
    RecyclerView.ViewHolder(
        binding.root
    ) {
    abstract fun onBind(item: T, position: Int)
}