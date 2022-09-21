package com.admissions.empty_project.data.database.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.admissions.empty_project.common.Constants
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = Constants.hackerNewEntity)
data class HackerNewEntity(
    @PrimaryKey
    val id: String,
    val url: String,
    val title: String,
    val author: String,
    val date: String,
) : Parcelable