package com.admissions.usecases

import com.admissions.data.repository.HackerNewRepository
import com.admissions.domain.HackerNew
import com.admissions.domain.Result


class HackerNewUserCases(
    private val hackerRepo: HackerNewRepository
){
    suspend fun getHackerNews(): Result<List<HackerNew>> = hackerRepo.getHackerNews()
    suspend fun anyLocal() = hackerRepo.anyDB()
}