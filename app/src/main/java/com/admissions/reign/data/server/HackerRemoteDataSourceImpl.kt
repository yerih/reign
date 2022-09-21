package com.admissions.reign.data.server

import com.admissions.data.source.HackerRemoteDataSource
import com.admissions.domain.HackerNew
import com.admissions.domain.Result
import com.admissions.reign.data.server.request_responses.asHackerNewList
import retrofit2.HttpException
import java.lang.Exception

class HackerRemoteDataSourceImpl : HackerRemoteDataSource {
    override suspend fun getHackerNews(): Result<List<HackerNew>> {
        return try {
            val result = HackerNewApi.retrofitAppService.getHackerNews().hits.asHackerNewList()
            Result(result)
        }catch (e: HttpException){
            Result(null, Error(e.message.toString()))
        }catch (ex: Exception){
            Result(null, Error(ex.message.toString()))
        }
    }
}