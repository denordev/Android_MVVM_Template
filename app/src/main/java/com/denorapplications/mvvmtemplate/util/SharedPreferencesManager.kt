package com.denorapplications.mvvmtemplate.util

import android.content.Context

class SharedPreferencesManager(context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences(Constants.SP_OPTIONS, Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun put(key: String, value: String) {
        editor.putString(key, value)
    }

    fun getStringValue(key: String): String {
        return sharedPreferences.getString(key, "") ?: ""
    }

    fun clear() {
        editor.clear()
    }
}
