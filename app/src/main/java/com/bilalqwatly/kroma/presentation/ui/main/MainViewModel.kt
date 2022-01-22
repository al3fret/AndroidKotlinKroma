package com.bilalqwatly.kroma.presentation.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bilalqwatly.kroma.data.exception.BaseException
import com.bilalqwatly.kroma.data.local.SharedPreferencesManager
import com.bilalqwatly.kroma.data.remote.api.model.request.MainRequest
import com.bilalqwatly.kroma.data.remote.api.model.response.ResultData
import com.bilalqwatly.kroma.domin.interactor.usecase.base.CoroutineScopeUseCase
import com.bilalqwatly.kroma.domin.interactor.usecase.main.MainUseCase
import com.bilalqwatly.kroma.presentation.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    session: SharedPreferencesManager,
    private val mainUseCase: MainUseCase,
) :
    BaseViewModel(session) {

    var mainData: MutableLiveData<ArrayList<ResultData>> = MutableLiveData<ArrayList<ResultData>>()

    override fun fetchFirstData() {
        super.fetchFirstData()
        getMainData()
    }


    override fun refreshData() {
        super.refreshData()

        startLoading(loading = false, loadingRefresh = false, loadingPage = false)
        getMainData();

    }

    private fun getMainData() =
        mainUseCase(
            viewModelScope, params = MainRequest(
                "all-sections", 7,
                "JeWuf5MX895HSxaeRSQsGSO9Aup1X40b"
            )
        ) {
            it.either(
                ::handleLogoDataFailure,
                ::handleLogoDataSuccess
            )
        }

    private fun handleLogoDataFailure(failure: BaseException) {

        stopLoading()
        isError.postValue(true)
    }

    private fun handleLogoDataSuccess(data: ArrayList<ResultData>) {
        stopLoading()

        mainData.postValue(data);

    }


    init {
        fetchFirstData()
    }

}