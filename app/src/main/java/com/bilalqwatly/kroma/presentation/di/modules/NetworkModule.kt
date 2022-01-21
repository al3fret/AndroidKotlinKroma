package com.bilalqwatly.kroma.presentation.di.modules

import android.content.Context

import com.bilalqwatly.kroma.utils.constants.NetworkConstants
import com.bilalqwatly.kroma.data.remote.api.ApiEndPoints
import com.bilalqwatly.kroma.data.remote.api.RetrofitService
import com.bilalqwatly.kroma.data.remote.interceptor.AuthInterceptor
import com.bilalqwatly.kroma.data.remote.interceptor.OnlineInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(ApiEndPoints.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getApiCallInterface(retrofit: Retrofit): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }

    @Provides
    @Singleton
    fun getRequestHeader(
        @ApplicationContext context: Context,
        authInterceptor: AuthInterceptor?,
        onlineInterceptor: OnlineInterceptor?
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(NetworkConstants.TIME_OUT.toLong(), TimeUnit.SECONDS)
        httpClient.readTimeout(NetworkConstants.TIME_OUT.toLong(), TimeUnit.SECONDS)
        httpClient.writeTimeout(NetworkConstants.TIME_OUT.toLong(), TimeUnit.SECONDS)
        val myCache = Cache(context.cacheDir, NetworkConstants.CACHE_SIZE)
        httpClient.cache(myCache)
        httpClient.addInterceptor(loggingInterceptor)
        httpClient.addInterceptor(authInterceptor!!)
        httpClient.addNetworkInterceptor(onlineInterceptor!!)
        return httpClient.build()
    }
}