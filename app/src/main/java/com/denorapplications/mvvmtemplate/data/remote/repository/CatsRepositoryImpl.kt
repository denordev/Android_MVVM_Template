package com.denorapplications.mvvmtemplate.data.remote.repository

import com.denorapplications.mvvmtemplate.data.remote.CatsApi
import com.denorapplications.mvvmtemplate.domain.models.Cat
import com.denorapplications.mvvmtemplate.domain.repositories.CatsRepository
import java.util.concurrent.ConcurrentMap
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(
    private val catsApi: CatsApi
) : CatsRepository {

    override suspend fun getCatById(id: String): Cat {
        return catsApi.getCatById(id)
    }

    override suspend fun getCatsList(count: Int, page: Int): List<Cat> {
        return catsApi.getCatsList(count, page)
    }

}
