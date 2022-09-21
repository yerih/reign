package com.admissions.data.repository

import com.admissions.data.source.HackerRemoteDataSource
import com.admissions.data.source.LocalDataSource
import com.admissions.domain.HackerNew
import com.admissions.domain.Result
import kotlinx.coroutines.flow.Flow

class HackerNewRepository(
    private val hackerRemoteDataSource: HackerRemoteDataSource,
    private val localDataSource: LocalDataSource
){

    private val hackerNews = localDataSource.list
    suspend fun requestHackerNews(): Flow<List<HackerNew>> {
        val result: Result<List<HackerNew>>
        if(localDataSource.isEmpty()) {
            result = hackerRemoteDataSource.getHackerNews()
            insertList(result.result!!)
        }
        return hackerNews
    }
    suspend fun insertList(list: List<HackerNew>): Unit = localDataSource.insertList(list)
}