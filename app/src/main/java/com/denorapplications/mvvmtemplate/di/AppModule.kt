package com.denorapplications.mvvmtemplate.di

import android.content.Context
import com.denorapplications.mvvmtemplate.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideContext(application: App): Context {
        return application
    }

}