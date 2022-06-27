package com.denorapplications.mvvmtemplate.data.local

import androidx.room.*
import com.denorapplications.mvvmtemplate.domain.models.Cat

@Dao
interface CatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Cat)

    @Query("SELECT * FROM cat")
    suspend fun getItemsList(): List<Cat>

    @Query("SELECT * FROM cat WHERE id=:id")
    suspend fun getItemById(id: Long): Cat

    @Delete
    suspend fun deleteItem(item: Cat)

    @Update
    suspend fun updateItem(item: Cat)

    @Query("DELETE FROM cat")
    suspend fun deleteAllItems()

}