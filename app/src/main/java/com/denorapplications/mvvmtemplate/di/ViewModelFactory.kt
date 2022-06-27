package com.denorapplications.mvvmtemplate.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.denorapplications.mvvmtemplate.presentation.catslistfragment.CatListViewModel
import com.denorapplications.mvvmtemplate.presentation.mainfragment.MainViewModel
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    mainViewModel: Provider<MainViewModel>,
    catListViewModel: Provider<CatListViewModel>
) : ViewModelProvider.Factory {

    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        MainViewModel::class.java to mainViewModel,
        CatListViewModel::class.java to catListViewModel
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return providers[modelClass]!!.get() as T
    }
}