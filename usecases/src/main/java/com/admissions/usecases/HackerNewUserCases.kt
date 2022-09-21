package com.admissions.usecases

import com.admissions.data.repository.HackerNewRepository
import com.admissions.domain.HackerNew
import kotlinx.coroutines.flow.Flow


class HackerNewUserCases(
    private val hackerRepo: HackerNewRepository
){
    suspend fun getHackerNews(): Flow<List<HackerNew>> = hackerRepo.requestHackerNews()
    suspend fun insertList(list: List<HackerNew>) = hackerRepo.insertList(list)
}