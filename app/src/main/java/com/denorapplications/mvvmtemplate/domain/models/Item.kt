package com.denorapplications.mvvmtemplate.domain.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.denorapplications.mvvmtemplate.util.Constants
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = Constants.ITEM_NAME_COLUMN) val name: String,
    @ColumnInfo(name = Constants.ITEM_INFO_COLUMN) val info: String
) : Parcelable