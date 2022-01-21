package com.bilalqwatly.kroma.data.local

import android.content.Context
import javax.inject.Inject
import dagger.hilt.android.qualifiers.ApplicationContext
import android.content.SharedPreferences


class SharedPreferencesManager @Inject constructor(@param:ApplicationContext
                                                   var _context: Context) {
    // Shared Preferences
    private val mPreferences: SharedPreferences
    private val mEditor: SharedPreferences.Editor
    // Shared pref mode
    private var PRIVATE_MODE = 0





    fun clear() {

    }

    companion object {
        // Shared preferences file name
        private const val PREF_NAME = "com.bilalqwatly.baseKotlin.pref_name"


        fun clearPreferences(context: Context) {
            val prefs = context.getSharedPreferences(
                PREF_NAME, Context.MODE_PRIVATE
            )
            prefs.edit().clear().apply()
        }
    }

    init {
        mPreferences = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        mEditor = mPreferences.edit()
    }
}