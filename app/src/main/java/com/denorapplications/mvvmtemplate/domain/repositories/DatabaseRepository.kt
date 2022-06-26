package com.denorapplications.mvvmtemplate.domain.repositories

import com.denorapplications.mvvmtemplate.domain.models.Item

interface DatabaseRepository {

    suspend fun insertItem(item: Item)

    suspend fun getItemsList(): List<Item>

    suspend fun getItemById(id: Long): Item

    suspend fun deleteItem(item: Item)

    suspend fun updateItem(item: Item)

    suspend fun deleteAllItems()
}