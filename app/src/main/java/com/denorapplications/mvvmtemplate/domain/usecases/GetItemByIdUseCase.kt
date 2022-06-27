package com.denorapplications.mvvmtemplate.domain.usecases

import com.denorapplications.mvvmtemplate.domain.repositories.DatabaseRepository
import com.denorapplications.mvvmtemplate.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetItemByIdUseCase @Inject constructor (
    private val databaseRepository: DatabaseRepository
) {

    operator fun invoke(id: Long) = flow{
        try {
            emit(Resource.Loading())
            val item = databaseRepository.getItemById(id)
            emit(Resource.Success(item))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unexpected error"))
        }
    }.flowOn(Dispatchers.IO)
}