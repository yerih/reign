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

    val hackerNews = localDataSource.list
    suspend fun requestHackerNews(): Unit {
//        val result: Result<List<HackerNew>>
        if(localDataSource.isEmpty()) {
            val result = hackerRemoteDataSource.getHackerNews()
            result.result!!.size
            result.result!!.forEach { hackerNew -> insert(hackerNew) }
//            insertList(result.result!!)
        }
//        return hackerNews
    }
    suspend fun insert(h: HackerNew): Unit = localDataSource.insert(h)
    suspend fun insertList(list: List<HackerNew>): Unit = localDataSource.insertList(list)
    suspend fun delete(h: HackerNew) = localDataSource.delete(h)
}