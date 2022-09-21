package com.admissions.reign.data.di

import com.admissions.data.repository.HackerNewRepository
import com.admissions.usecases.HackerNewUserCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class GeneralModule {

    @Provides
    fun anyUseCasesProvider(anyRepository: HackerNewRepository) = HackerNewUserCases(anyRepository)
}