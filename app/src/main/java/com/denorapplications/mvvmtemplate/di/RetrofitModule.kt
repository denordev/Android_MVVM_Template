package com.denorapplications.mvvmtemplate.di

import android.content.Context
import com.denorapplications.mvvmtemplate.BuildConfig
import com.denorapplications.mvvmtemplate.data.remote.CatsApi
import com.denorapplications.mvvmtemplate.data.remote.repository.CatsRepositoryImpl
import com.denorapplications.mvvmtemplate.domain.repositories.CatsRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val BASE_URL = ""

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideHttpCache(@ApplicationContext context: Context): Cache {
        val cacheSize: Long = CACHE_SIZE
        return Cache(context.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(cache: Cache?, httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val client = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
        client.cache(cache)
        return client.build()
    }

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit? {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideCatsApi(moshi: Moshi, okHttpClient: OkHttpClient): CatsApi {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
            .create(CatsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCatsRepository(catsApi: CatsApi): CatsRepository {
        return CatsRepositoryImpl(catsApi)
    }

    private const val CACHE_SIZE: Long = 10 * 1024 * 1024
}
