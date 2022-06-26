package com.denorapplications.mvvmtemplate.util

import android.content.Context

class SharedPreferencesManager(context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences(Constants.SP_OPTIONS, Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun put() {
//         editor.putString()
    }

    fun get() {
//        sharedPreferences.getString()
    }

    fun clear() {
//        editor.clear()
    }
}