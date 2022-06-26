package com.denorapplications.mvvmtemplate.di

import com.denorapplications.mvvmtemplate.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, DatabaseModule::class]
)
interface AppComponent {

    fun inject(activity: MainActivity)

}