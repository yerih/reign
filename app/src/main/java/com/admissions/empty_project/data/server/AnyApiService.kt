package com.admissions.empty_project.data.server

import com.admissions.empty_project.data.server.request_responses.HackerNewsResponse
import retrofit2.http.GET

interface AnyApiService{

    @GET("search_by_date?query=mobile")
    suspend fun getHackerNews(): HackerNewsResponse
}

object AnyApi{
    val retrofitAppService: AnyApiService by lazy {
        RetrofitSettings.builder("https://hn.algolia.com/api/v1/").create(AnyApiService::class.java)
    }
}

