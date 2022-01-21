package com.bilalqwatly.kroma.presentation.ui.main


import androidx.lifecycle.ViewModelProvider
import com.bilalqwatly.kroma.BR
import com.bilalqwatly.kroma.R
import com.bilalqwatly.kroma.databinding.ActivityMainBinding
import com.bilalqwatly.kroma.presentation.ui.base.view.activity.MVVMActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint class MainActivity : MVVMActivity<MainViewModel, ActivityMainBinding>() {


    override val layoutId: Int
        get() = R.layout.activity_main

    override fun provideViewModel(): MainViewModel {

        return ViewModelProvider(this)[MainViewModel::class.java]
    }

    override val viewModelId: Int
        get() = BR.viewModel

}