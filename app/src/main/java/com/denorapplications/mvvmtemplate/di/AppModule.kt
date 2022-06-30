package com.denorapplications.mvvmtemplate.di

import dagger.Module

@Module(
    includes = [
        RetrofitModule::class,
        DatabaseModule::class,
        SharedPreferencesModule::class,
    ]
)
object AppModule
