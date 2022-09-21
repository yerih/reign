package com.admissions.data.source

import com.admissions.domain.HackerNew
import com.admissions.domain.Result

interface HackerRemoteDataSource {
    suspend fun getHackerNews(): Result<List<HackerNew>>
}