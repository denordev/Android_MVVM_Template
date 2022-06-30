package com.denorapplications.mvvmtemplate.data.remote

import com.denorapplications.mvvmtemplate.BuildConfig
import com.denorapplications.mvvmtemplate.domain.models.Cat
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface CatsApi {

    @Headers("x-api-key:${BuildConfig.CATS_API_KEY}")
    @GET("{image_id}")
    suspend fun getCatById(@Path("image_id") id: String): Cat

    @Headers("x-api-key:${BuildConfig.CATS_API_KEY}")
    @GET("search?&order=desc?mime_types=gif")
    suspend fun getCatsList(
        @Query("limit") count: Int,
        @Query("page") page: Int
    ): List<Cat>
}
