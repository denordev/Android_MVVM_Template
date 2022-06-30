package com.denorapplications.mvvmtemplate

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.denorapplications.mvvmtemplate.di.AppComponent
import com.denorapplications.mvvmtemplate.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(applicationContext)
    }
}

/** Extension to get AppComponent */
val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }

/** Extension to get AppComponent in Fragment*/
fun Fragment.getAppComponent(): AppComponent =
    requireContext().appComponent
