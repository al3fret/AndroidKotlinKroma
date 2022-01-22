package com.bilalqwatly.kroma.presentation.ui.details

import androidx.lifecycle.MutableLiveData
import com.bilalqwatly.kroma.data.local.SharedPreferencesManager
import com.bilalqwatly.kroma.data.remote.api.model.response.ResultData
import com.bilalqwatly.kroma.presentation.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    session: SharedPreferencesManager
) : BaseViewModel(session) {


    var item: MutableLiveData<ResultData> =
        MutableLiveData<ResultData>()


}