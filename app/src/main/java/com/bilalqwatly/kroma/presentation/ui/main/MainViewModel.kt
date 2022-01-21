package com.bilalqwatly.kroma.presentation.ui.main

import com.bilalqwatly.kroma.data.local.SharedPreferencesManager
import com.bilalqwatly.kroma.presentation.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(session: SharedPreferencesManager) :
    BaseViewModel(session) {
}