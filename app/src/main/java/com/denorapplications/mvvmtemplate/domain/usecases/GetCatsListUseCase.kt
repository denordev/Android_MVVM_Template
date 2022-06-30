package com.denorapplications.mvvmtemplate.domain.usecases

import com.denorapplications.mvvmtemplate.domain.repositories.CatsRepository
import com.denorapplications.mvvmtemplate.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject
private const val CATS_COUNT = 50
private const val PAGE_NUMBER = 1

class GetCatsListUseCase @Inject constructor(
    private val catsRepository: CatsRepository
) {

    operator fun invoke() = flow {
        try {
            emit(Resource.Loading())
            val list = catsRepository.getCatsList(CATS_COUNT, PAGE_NUMBER)
            emit(Resource.Success(list))
        }catch (e: HttpException) {
            emit(Resource.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)
}
