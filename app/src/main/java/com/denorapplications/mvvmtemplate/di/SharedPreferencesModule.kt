package com.denorapplications.mvvmtemplate.di

import android.content.Context
import com.denorapplications.mvvmtemplate.util.SharedPreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    @Singleton
    @Provides
    fun provideSharedPreferencesManager(@ApplicationContext context: Context) =
        SharedPreferencesManager(context)
}
