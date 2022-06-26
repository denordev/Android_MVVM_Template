package com.denorapplications.mvvmtemplate.di

import android.content.Context
import com.denorapplications.mvvmtemplate.util.SharedPreferencesManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object SharedPreferencesModule {

    @Singleton
    @Provides
    fun provideSharedPreferencesManager(context: Context) = SharedPreferencesManager(context)

}