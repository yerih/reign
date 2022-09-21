package com.admissions.reign.data.database.db

import com.admissions.data.repository.HackerNewRepository
import com.admissions.reign.data.server.HackerRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun anyRepositoryProvider(anyNetworkDataSource: HackerRemoteDataSourceImpl, localDataSource: RoomDataBase) = HackerNewRepository(anyNetworkDataSource,localDataSource)

}