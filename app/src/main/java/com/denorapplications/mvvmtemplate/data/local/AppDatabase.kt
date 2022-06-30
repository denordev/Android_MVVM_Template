package com.denorapplications.mvvmtemplate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.denorapplications.mvvmtemplate.domain.models.Item
import com.denorapplications.mvvmtemplate.util.Constants

@Database(
    entities = [Item::class],
    version = Constants.DATABASE_VERSION,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}
