package com.bilalqwatly.kroma.presentation.ui.base.view.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

import com.bilalqwatly.kroma.utils.lifecycle.EventObserver
import com.bilalqwatly.kroma.utils.lifecycle.EventObserver.OnChanged
import com.bilalqwatly.kroma.R
import com.bilalqwatly.kroma.presentation.ui.base.viewmodel.BaseViewModel

abstract class MVVMActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseActivity() {
    private lateinit var activityBinding: DB
    protected lateinit var viewModel: VM
    protected abstract fun provideViewModel(): VM
    protected abstract val viewModelId: Int

    // Called to get params from intent's bundle
    protected open fun onFetchParams() {}
    override fun setView() {
        if (layoutId != 0) activityBinding = DataBindingUtil.setContentView(this, layoutId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDataBinding()
        onFetchParams()

        setupList()
        initToolbar()
        setupBaseObservers()
        setListeners()
    }

    protected open fun initToolbar() {}


    protected open fun setListeners() {}
    protected open fun setupList() {}
    private fun setupDataBinding() {
        viewModel = provideViewModel()
        activityBinding.setVariable(viewModelId, viewModel)
        activityBinding.lifecycleOwner = this
        activityBinding.executePendingBindings()
    }

    fun setStatusBarColor(color: Int) {
        window.statusBarColor = color
    }

    open fun setupBaseObservers() {

        viewModel.isError.observe(this, {

            if (it)
                showMessage(R.string.no_internet_connection)
        })

        viewModel.toastMessage.observe(
            this,
            EventObserver(object : OnChanged<String?> {
                override fun onChanged(data: String?) {
                    showMessage(data)
                }
            })
        )
        viewModel.toastMessageResource.observe(
            this,
            EventObserver(object : OnChanged<Int> {
                override fun onChanged(data: Int) {
                    showMessage(data)
                }
            })
        )



    }


}
