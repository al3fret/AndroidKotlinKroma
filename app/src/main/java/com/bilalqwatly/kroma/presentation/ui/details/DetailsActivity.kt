package com.bilalqwatly.kroma.presentation.ui.details


import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bilalqwatly.kroma.BR
import com.bilalqwatly.kroma.R
import com.bilalqwatly.kroma.data.remote.api.model.response.ResultData
import com.bilalqwatly.kroma.databinding.ActivityDetailsBinding
import com.bilalqwatly.kroma.presentation.ui.base.view.activity.MVVMActivity
import com.bilalqwatly.kroma.utils.constants.DataConstants
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : MVVMActivity<DetailsViewModel, ActivityDetailsBinding>() {


    override val layoutId: Int
        get() = R.layout.activity_details

    override fun provideViewModel(): DetailsViewModel {
        return ViewModelProvider(this)[DetailsViewModel::class.java]
    }

    override val viewModelId: Int
        get() = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.isBack.postValue(true)


    }

    override fun onFetchParams() {
        super.onFetchParams()

        viewModel.item.postValue(intent.getSerializableExtra(DataConstants.ITEM) as ResultData)

    }


    override fun setupBaseObservers() {
        super.setupBaseObservers()

        viewModel.goBackClick.observe(this, {

            if (it)
                onBackPressed()
        })

        viewModel.item.observe(this,{
            viewModel.toolbarTitle.postValue(it.byline)

            try {
                Glide.with(context)
                    .load(it.media?.get(0)?.mediaMetaDataList?.get(2)?.url)
                    .placeholder(R.drawable.kroma)
                    .into(activityBinding.ivImage)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        })
    }

}