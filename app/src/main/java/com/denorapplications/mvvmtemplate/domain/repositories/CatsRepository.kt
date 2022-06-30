package com.denorapplications.mvvmtemplate.domain.repositories

import com.denorapplications.mvvmtemplate.domain.models.Cat

interface CatsRepository {

    suspend fun getCatById(id: String): Cat

    suspend fun getCatsList(count: Int, page: Int): List<Cat>
}
