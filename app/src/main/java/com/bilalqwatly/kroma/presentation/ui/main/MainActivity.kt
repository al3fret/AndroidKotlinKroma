package com.bilalqwatly.kroma.presentation.ui.main


import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bilalqwatly.kroma.BR
import com.bilalqwatly.kroma.R
import com.bilalqwatly.kroma.data.remote.api.model.response.ResultData
import com.bilalqwatly.kroma.databinding.ActivityMainBinding
import com.bilalqwatly.kroma.presentation.callback.OnItemClickListener
import com.bilalqwatly.kroma.presentation.ui.base.view.activity.MVVMActivity
import com.bilalqwatly.kroma.presentation.ui.details.DetailsActivity
import com.bilalqwatly.kroma.presentation.ui.main.adapter.MainAdapter
import com.bilalqwatly.kroma.utils.NavigationUtil
import com.bilalqwatly.kroma.utils.constants.DataConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : MVVMActivity<MainViewModel, ActivityMainBinding>() {


    private val onItemClickListener: OnItemClickListener<ResultData> =
        object : OnItemClickListener<ResultData> {
            override fun onClick(item: ResultData, position: Int) {

                val bundle = Bundle()
                bundle.putSerializable(DataConstants.ITEM, item)

                NavigationUtil.goToActivity(this@MainActivity, DetailsActivity::class.java, bundle)
            }
        }


    override val layoutId: Int
        get() = R.layout.activity_main

    override fun provideViewModel(): MainViewModel {

        return ViewModelProvider(this)[MainViewModel::class.java]
    }

    override val viewModelId: Int
        get() = BR.viewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.toolbarTitle.postValue(getString(R.string.ny_times_most_popular))
    }

    override fun setupList() {
        adapter = MainAdapter(
            this,
            onItemClickListener
        )
        activityBinding.rvList.adapter = adapter
        activityBinding.rvList.itemAnimator = null
    }


    override fun setupBaseObservers() {
        super.setupBaseObservers()

        viewModel.mainData.observe(this, {

        })
    }
}