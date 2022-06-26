package com.denorapplications.mvvmtemplate.di

import com.denorapplications.mvvmtemplate.presentation.MainActivity
import com.denorapplications.mvvmtemplate.presentation.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DatabaseModule::class,
        SharedPreferencesModule::class,
        RetrofitModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)

    fun viewModelFactory(): ViewModelFactory

}