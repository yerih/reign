package com.admissions.empty_project.data.server

import com.admissions.data.source.HackerRemoteDataSource
import com.admissions.domain.HackerNew
import com.admissions.domain.Result
import com.admissions.empty_project.data.server.request_responses.asHackerNewList
import retrofit2.HttpException
import java.lang.Exception

class HackerRemoteDataSourceImpl : HackerRemoteDataSource {
    override suspend fun remoteMethod(): Result<List<HackerNew>> {
        return try {
            val result = AnyApi.retrofitAppService.getHackerNews().hits.asHackerNewList()
            Result(result)
        }catch (e: HttpException){
            Result(null, Error(e.message.toString()))
        }catch (ex: Exception){
            Result(null, Error(ex.message.toString()))
        }
    }
}