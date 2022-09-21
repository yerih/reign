package com.admissions.usecases

import com.admissions.data.repository.AnyRepository
import com.admissions.domain.HackerNew
import com.admissions.domain.Result


class AnyUseCases(
    private val hackerRepo: AnyRepository
){
    suspend fun getHackerNews(): Result<List<HackerNew>> = hackerRepo.getHackerNews()
    suspend fun anyLocal() = hackerRepo.anyDB()
}