package com.admissions.empty_project.data.di

import android.app.Application
import com.admissions.data.source.LocalDataSource
import com.admissions.empty_project.data.database.dao.HackerNewDao
import com.admissions.empty_project.data.database.db.HackerNewDataBase
import com.admissions.empty_project.data.database.db.RoomDataBase
import com.admissions.empty_project.data.server.HackerRemoteDataSourceImpl
import com.admissions.empty_project.data.server.RetrofitSettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun dataBaseProvider(app: Application) = HackerNewDataBase.getInstance(app.applicationContext)

    @Provides
    @Singleton
    fun okHTTPClientProvider(): OkHttpClient = RetrofitSettings.okHttpClient

    @Provides
    fun anyRemoteDataSourceProvider() = HackerRemoteDataSourceImpl()

    @Provides
    fun anyDaoProvider(db: HackerNewDataBase) = db.hackerNewDao()

    @Provides
    fun localDataSource(anyDao: HackerNewDao): LocalDataSource = RoomDataBase(anyDao)

}