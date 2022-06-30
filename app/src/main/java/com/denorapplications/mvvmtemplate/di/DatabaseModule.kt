package com.denorapplications.mvvmtemplate.di

import android.content.Context
import androidx.room.Room
import com.denorapplications.mvvmtemplate.data.local.AppDatabase
import com.denorapplications.mvvmtemplate.data.local.ItemDao
import com.denorapplications.mvvmtemplate.data.local.repository.DatabaseRepositoryImpl
import com.denorapplications.mvvmtemplate.domain.repositories.DatabaseRepository
import com.denorapplications.mvvmtemplate.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        Constants.TABLE_NAME
    )
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideItemDao(appDatabase: AppDatabase): ItemDao {
        return appDatabase.itemDao()
    }

    @Singleton
    @Provides
    fun provideDatabaseRepository(itemDao: ItemDao): DatabaseRepository {
        return DatabaseRepositoryImpl(itemDao)
    }
}
