package com.denorapplications.mvvmtemplate.data.local.repository

import com.denorapplications.mvvmtemplate.data.local.ItemDao
import com.denorapplications.mvvmtemplate.domain.models.Item
import com.denorapplications.mvvmtemplate.domain.repositories.DatabaseRepository
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao
) : DatabaseRepository {

    override suspend fun insertItem(item: Item) {
        itemDao.insertItem(item)
    }

    override suspend fun getItemsList(): List<Item> {
        return itemDao.getItemsList()
    }

    override suspend fun getItemById(id: Long): Item {
        return itemDao.getItemById(id)
    }

    override suspend fun deleteItem(item: Item) {
        itemDao.deleteItem(item)
    }

    override suspend fun updateItem(item: Item) {
        itemDao.updateItem(item)
    }

    override suspend fun deleteAllItems() {
        itemDao.deleteAllItems()
    }
}
