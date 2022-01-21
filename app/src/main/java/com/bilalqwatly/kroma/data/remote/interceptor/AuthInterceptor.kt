package com.bilalqwatly.kroma.data.remote.interceptor


import com.bilalqwatly.kroma.data.local.SharedPreferencesManager
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(private val sharedPref: SharedPreferencesManager) :
    Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        val request: Request = chain.request()
        val newRequest = request.newBuilder().build()
        return chain.proceed(newRequest)
    }
}