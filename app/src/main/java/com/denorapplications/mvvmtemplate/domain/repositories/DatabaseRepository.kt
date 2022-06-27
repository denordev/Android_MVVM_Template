package com.denorapplications.mvvmtemplate.domain.repositories

import com.denorapplications.mvvmtemplate.domain.models.Cat

interface DatabaseRepository {

    suspend fun insertItem(item: Cat)

    suspend fun getItemsList(): List<Cat>

    suspend fun getItemById(id: Long): Cat

    suspend fun deleteItem(item: Cat)

    suspend fun updateItem(item: Cat)

    suspend fun deleteAllItems()
}