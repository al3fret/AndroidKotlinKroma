package com.bilalqwatly.kroma.presentation.ui.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bilalqwatly.kroma.utils.lifecycle.Event
import com.bilalqwatly.kroma.data.local.SharedPreferencesManager
import com.bilalqwatly.kroma.presentation.exception.ExceptionFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import javax.inject.Inject


@HiltViewModel
open class BaseViewModel @Inject constructor(
    var session: SharedPreferencesManager
) : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    override fun onCleared() {
        super.onCleared()
        viewModelScope.coroutineContext.cancelChildren()
    }

    var isLoading = MutableLiveData(false)
    var isLoadingPage = MutableLiveData(false)
    var isError = MutableLiveData(false)
    var isFirstLoading = MutableLiveData(false)
    var isLoadingRefresh = MutableLiveData(false)
    var errorMessage = MutableLiveData("")
    private val _toastMessage = MutableLiveData<Event<String?>>()
    var toastMessage: LiveData<Event<String?>> = _toastMessage
    private val _toastMessageResource = MutableLiveData<Event<Int>>()
    var toastMessageResource: LiveData<Event<Int>> = _toastMessageResource

    var toolbarTitle = MutableLiveData("")

    protected fun showMessage(message: String?) {
        _toastMessage.postValue(Event(message))
    }




    private fun showMessage(stringId: Int) {
        _toastMessageResource.postValue(Event(stringId))
    }

    protected fun showMessage(error: Throwable) {
        if (error.message != null) showMessage(error.message) else
            showMessage(ExceptionFactory.string)
    }


    protected fun showError() {
        isError.postValue(true)
        stopLoading()
    }



    protected fun startLoading(loading: Boolean, loadingRefresh: Boolean, loadingPage: Boolean) {

        isError.postValue(false)
        isFirstLoading.postValue(loading)
        isLoading.postValue(loading)
        isLoadingRefresh.postValue(loadingRefresh)
        isLoadingPage.postValue(loadingPage)
    }

    protected fun startLoadingPage() {
        isLoadingPage.postValue(true)
    }


    protected fun stopLoading() {

        isLoading.postValue(false)
        isLoadingPage.postValue(false)
        isLoadingRefresh.postValue(false)
        isFirstLoading.postValue(false)
    }


    open fun setToolbarTitle(title: String) {
        toolbarTitle.postValue(title)
    }

    fun fetchFirstData() {
        loadData(loading = true, loadingRefresh = false, loadingPage = false)
    }

    fun fetchDataPage() {
        loadData(loading = false, loadingRefresh = false, loadingPage = true)
    }

    open fun refreshData() {
        loadData(loading = false, loadingRefresh = true, loadingPage = false)
    }

     open fun fetchData(loading: Boolean, loadingRefresh: Boolean, loadingPage: Boolean) {
        startLoading(loading, loadingRefresh, loadingPage)
    }

    private fun loadData(loading: Boolean, loadingRefresh: Boolean, loadingPage: Boolean) {
        if (isLoading.value!! ||
            isLoadingRefresh.value!! ||
            isLoadingPage.value!!
        ) return
        fetchData(loading, loadingRefresh, loadingPage)
    }






}

