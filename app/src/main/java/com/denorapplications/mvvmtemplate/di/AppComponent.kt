package com.denorapplications.mvvmtemplate.di

import android.content.Context
import com.denorapplications.mvvmtemplate.presentation.MainActivity
import com.denorapplications.mvvmtemplate.presentation.catslistfragment.CatsListFragment
import com.denorapplications.mvvmtemplate.presentation.mainfragment.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)
    fun inject(fragment: CatsListFragment)

    fun viewModelsFactory(): ViewModelFactory

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }
}