package com.example.android3homework8mc5.id

import com.example.android3homework8mc5.data.remote.apiservises.NewApi
import com.example.android3homework8mc5.data.repositories.NewRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {

    @Provides
    @Singleton
    fun provideNewsRepository(newApi: NewApi) = NewRepository(newApi)
}