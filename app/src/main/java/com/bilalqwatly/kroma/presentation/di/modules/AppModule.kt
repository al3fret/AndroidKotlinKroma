package com.bilalqwatly.kroma.presentation.di.modules

import android.content.Context
import com.bilalqwatly.kroma.data.local.SharedPreferencesManager
import com.bilalqwatly.kroma.data.remote.networkchecker.INetworkChecker
import com.bilalqwatly.kroma.data.remote.networkchecker.NetworkCheckerImpl

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * this class is used to inject ApplicationClass .
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext context: Context?): SharedPreferencesManager {
        return SharedPreferencesManager(context!!)
    }

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideNetworkChecker(networkChecker: NetworkCheckerImpl): INetworkChecker {
        return networkChecker
    }

}