package com.admissions.reign.data.database.db

import com.admissions.data.source.LocalDataSource
import com.admissions.domain.HackerNew
import com.admissions.reign.common.toDomainModel
import com.admissions.reign.common.toEntityDB
import com.admissions.reign.data.database.dao.HackerNewDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class RoomDataBase @Inject constructor(
    private val hackerNewDao: HackerNewDao
) : LocalDataSource {

    override val list: Flow<List<HackerNew>> = hackerNewDao.getAll().map { it.toDomainModel() }
    override suspend fun isEmpty(): Boolean = hackerNewDao.itemsCount() == 0
    override suspend fun insertList(list: List<HackerNew>) = hackerNewDao.insertList(list.toEntityDB())
    override suspend fun getAll(): Flow<List<HackerNew>> = hackerNewDao.getAll().map { it.toDomainModel() }


}