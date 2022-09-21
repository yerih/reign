package com.admissions.reign.data.server

import com.admissions.reign.data.server.request_responses.HackerNewsResponse
import retrofit2.http.GET

interface HackerNewApiService{

    @GET("search_by_date?query=mobile")
    suspend fun getHackerNews(): HackerNewsResponse
}

object HackerNewApi{
    val retrofitAppService: HackerNewApiService by lazy {
        RetrofitSettings.builder("https://hn.algolia.com/api/v1/").create(HackerNewApiService::class.java)
    }
}

