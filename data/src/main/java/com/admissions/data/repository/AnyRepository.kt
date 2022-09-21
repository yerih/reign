package com.admissions.data.repository

import com.admissions.data.source.HackerRemoteDataSource
import com.admissions.data.source.LocalDataSource
import com.admissions.domain.HackerNew
import com.admissions.domain.Result

class AnyRepository(
    private val hackerRemoteDataSource: HackerRemoteDataSource,
    private val localDataSource: LocalDataSource
){
    suspend fun getHackerNews(): Result<List<HackerNew>> = hackerRemoteDataSource.remoteMethod()
    suspend fun anyDB(): Unit = localDataSource.method()
}