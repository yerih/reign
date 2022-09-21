package com.admissions.data.source

import com.admissions.domain.HackerNew
import kotlinx.coroutines.flow.Flow

interface LocalDataSource{

    val list: Flow<List<HackerNew>>
    suspend fun isEmpty(): Boolean
    suspend fun insertList(list: List<HackerNew>): Unit
    suspend fun getAll(): Flow<List<HackerNew>>
}