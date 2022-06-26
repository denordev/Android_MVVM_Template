package com.denorapplications.mvvmtemplate.domain.usecases

import com.denorapplications.mvvmtemplate.domain.models.Item
import com.denorapplications.mvvmtemplate.domain.repositories.DatabaseRepository
import javax.inject.Inject

class GetItemByIdUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {

    suspend operator fun invoke(id: Long) : Item {
        return databaseRepository.getItemById(id)
    }
}