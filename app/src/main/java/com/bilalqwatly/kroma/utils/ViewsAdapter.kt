package com.bilalqwatly.kroma.utils


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bilalqwatly.kroma.presentation.ui.base.adpter.BaseListAdapter
import com.bumptech.glide.Glide
import java.io.Serializable


/**
 * This class is used to fill data in the Adapter and cache an image
 */
object ViewsAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(imageView: ImageView, url: String?) {
        val context = imageView.context ?: return
        Glide.with(context)
            .load(url)
            .into(imageView)
    }





    @JvmStatic
    @BindingAdapter("loadDataRecycler")
    fun loadData(recyclerView: RecyclerView, data: List<Serializable>?) {
        val adapter = recyclerView.adapter
        if (adapter != null) {
            if (adapter is BaseListAdapter<*, *>) {
                adapter.submitData(data)
            }
        }
    }



}