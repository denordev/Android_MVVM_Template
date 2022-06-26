package com.denorapplications.mvvmtemplate.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
typealias ViewModelCreator = () -> ViewModel?


class ViewModelFactory(
    private val viewModelCreator: ViewModelCreator = { null }
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelCreator() as T
    }
}

inline fun <reified VM : ViewModel> Fragment.viewModelCreator(noinline creator: ViewModelCreator): Lazy<VM> =
    viewModels { ViewModelFactory(creator) }