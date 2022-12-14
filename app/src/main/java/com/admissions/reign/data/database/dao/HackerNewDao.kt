package com.admissions.reign.data.database.dao

import androidx.room.*
import com.admissions.reign.common.Constants
import com.admissions.reign.data.database.entity.HackerNewEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface HackerNewDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAny(p: HackerNewEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list: List<HackerNewEntity>)


    @Query("SELECT COUNT(author) FROM hackernews")
    suspend fun itemsCount(): Int

    @Delete
    fun delete(p: HackerNewEntity)

    @Query("SELECT * FROM ${Constants.hackerNewEntity}")
    fun getAll(): Flow<List<HackerNewEntity>>

}

