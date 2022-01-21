package com.bilalqwatly.kroma.presentation.ui.splash


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bilalqwatly.kroma.presentation.ui.main.MainActivity
import com.bilalqwatly.kroma.utils.NavigationUtil

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NavigationUtil.goToActivity(this, MainActivity::class.java, true)
    }

}