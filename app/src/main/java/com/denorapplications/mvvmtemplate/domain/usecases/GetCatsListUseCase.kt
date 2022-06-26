package com.denorapplications.mvvmtemplate.domain.usecases

import com.denorapplications.mvvmtemplate.domain.repositories.CatsRepository
import com.denorapplications.mvvmtemplate.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetCatsListUseCase @Inject constructor(
    private val catsRepository: CatsRepository
) {

    operator fun invoke() = flow {
        try {
            emit(Resource.Loading())
            val list = catsRepository.getCatsList(50, 1)
            emit(Resource.Success(list))
        }catch (e: Exception) {
            emit(Resource.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)
}