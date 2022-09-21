package com.admissions.data.repository

import com.admissions.data.source.HackerRemoteDataSource
import com.admissions.data.source.LocalDataSource
import com.admissions.domain.HackerNew
import com.admissions.domain.Result

class HackerNewRepository(
    private val hackerRemoteDataSource: HackerRemoteDataSource,
    private val localDataSource: LocalDataSource
){

    val hackerNews = localDataSource.list
    suspend fun getHackerNews(): Result<List<HackerNew>> = hackerRemoteDataSource.getHackerNews()
    suspend fun insertList(list: List<HackerNew>): Unit = localDataSource.insertList(list)
}