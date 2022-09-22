package com.admissions.data.repository

import com.admissions.data.source.HackerRemoteDataSource
import com.admissions.data.source.LocalDataSource
import com.admissions.domain.HackerNew
import kotlinx.coroutines.flow.Flow

class HackerNewRepository(
    private val hackerRemoteDataSource: HackerRemoteDataSource,
    private val localDataSource: LocalDataSource
){

    val hackerNews = localDataSource.list
    suspend fun requestHackerNews(isRefresh: Boolean = false): Flow<List<HackerNew>> {
        if(localDataSource.isEmpty() || isRefresh) {
            val result = hackerRemoteDataSource.getHackerNews()
            if(result.isSuccess) { insertList(result.result!!) }
        }
        return hackerNews
    }
    suspend fun insertList(list: List<HackerNew>): Unit = localDataSource.insertList(list)
    suspend fun delete(h: HackerNew) = localDataSource.delete(h)
}