package com.admissions.empty_project.data.database.db

import com.admissions.data.source.LocalDataSource
import com.admissions.empty_project.data.database.dao.HackerNewDao
import javax.inject.Inject


class RoomDataBase @Inject constructor(
    private val anyDao: HackerNewDao
) : LocalDataSource {

    override suspend fun method() {

    }

}