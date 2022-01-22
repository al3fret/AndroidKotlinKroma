package com.bilalqwatly.kroma.presentation.ui.main.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bilalqwatly.kroma.R
import com.bilalqwatly.kroma.data.remote.api.model.response.ResultData
import com.bilalqwatly.kroma.databinding.ListItemMainBinding
import com.bilalqwatly.kroma.presentation.callback.OnItemClickListener
import com.bilalqwatly.kroma.presentation.ui.base.adpter.BaseListAdapter
import com.bilalqwatly.kroma.presentation.ui.base.adpter.BaseViewHolder
import com.bumptech.glide.Glide


class MainAdapter(
    context: Context,
    onItemClickListener: OnItemClickListener<ResultData>,
) :
    BaseListAdapter<ResultData, BaseViewHolder<ResultData, *>>(
        context,
        onItemClickListener,
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ResultData, *> {
        val binding: ListItemMainBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.list_item_main,
            parent,
            false
        )
        return MainViewHolder(
            binding
        )
    }


    internal inner class MainViewHolder(itemView: ListItemMainBinding) :
        BaseViewHolder<ResultData, ListItemMainBinding>(itemView) {
        override fun onBind(item: ResultData, position: Int) {
            binding.data = item


            try {
                Glide.with(context)
                    .load(item.media?.get(0)?.mediaMetaDataList?.get(2)?.url)
                    .placeholder(R.drawable.kroma)
                    .into(binding.ivImage)

            } catch (e: Exception) {
                e.printStackTrace()
            }

            binding.rootView.setOnClickListener { onItemClickListener.onClick(item, position) }
            binding.executePendingBindings()
        }
    }


}