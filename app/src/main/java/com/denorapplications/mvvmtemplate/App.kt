package com.denorapplications.mvvmtemplate

import android.app.Application
import android.content.Context
import com.denorapplications.mvvmtemplate.di.AppComponent
import com.denorapplications.mvvmtemplate.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

/** Extension to get AppComponent */
val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }