package com.denorapplications.mvvmtemplate.data.local

import androidx.room.*
import com.denorapplications.mvvmtemplate.domain.models.Cat
import com.denorapplications.mvvmtemplate.domain.models.Item

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item)

    @Query("SELECT * FROM item")
    suspend fun getItemsList(): List<Item>

    @Query("SELECT * FROM item WHERE id=:id")
    suspend fun getItemById(id: Long): Item

    @Delete
    suspend fun deleteItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)

    @Query("DELETE FROM item")
    suspend fun deleteAllItems()

}