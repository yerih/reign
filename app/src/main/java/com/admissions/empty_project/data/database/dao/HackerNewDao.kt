package com.admissions.empty_project.data.database.dao

import androidx.room.*
import com.admissions.empty_project.common.Constants
import com.admissions.empty_project.data.database.entity.HackerNewEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface HackerNewDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAny(p: HackerNewEntity)

//    @Delete
//    fun deleteAny()

    @Query("SELECT * FROM ${Constants.hackerNewEntity}")
    fun getAll(): Flow<List<HackerNewEntity>>

//    @Query("SELECT * FROM $AnyEntityName where id=:id")
//    suspend fun getAnyById(id: String): AnyEntity?


}

