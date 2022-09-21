package com.admissions.empty_project.data.database.db

import com.admissions.data.repository.AnyRepository
import com.admissions.empty_project.data.server.HackerRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun anyRepositoryProvider(anyNetworkDataSource: HackerRemoteDataSourceImpl, localDataSource: RoomDataBase) = AnyRepository(anyNetworkDataSource,localDataSource)

}