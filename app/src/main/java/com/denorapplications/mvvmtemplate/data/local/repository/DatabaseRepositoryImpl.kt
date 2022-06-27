package com.denorapplications.mvvmtemplate.data.local.repository

import com.denorapplications.mvvmtemplate.data.local.CatDao
import com.denorapplications.mvvmtemplate.domain.models.Cat
import com.denorapplications.mvvmtemplate.domain.repositories.DatabaseRepository
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val catDao: CatDao
) : DatabaseRepository {

    override suspend fun insertItem(item: Cat) {
        catDao.insertItem(item)
    }

    override suspend fun getItemsList(): List<Cat> {
        return catDao.getItemsList()
    }

    override suspend fun getItemById(id: Long): Cat {
        return catDao.getItemById(id)
    }

    override suspend fun deleteItem(item: Cat) {
        catDao.deleteItem(item)
    }

    override suspend fun updateItem(item: Cat) {
        catDao.updateItem(item)
    }

    override suspend fun deleteAllItems() {
        catDao.deleteAllItems()
    }
}