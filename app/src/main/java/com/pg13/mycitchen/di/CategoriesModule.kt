package com.pg13.mycitchen.di

import com.pg13.data.api.ApiClient
import com.pg13.data.interfaces.CloudDataSource
import com.pg13.data.net.categories.CloudDataSourceCategoriesImpl
import com.pg13.data.repositories.CategoriesRepositoryImpl
import com.pg13.domain.entities.Categories
import com.pg13.domain.repositories.CategoriesRepository
import com.pg13.domain.usecases.GetCategoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CategoriesModule {

    @Singleton
    @Provides
    fun provideGetCategoriesUseCase(repository: CategoriesRepository) : GetCategoriesUseCase {
        return GetCategoriesUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideCategoriesRepository(cloudDataSource: CloudDataSource<Categories>): CategoriesRepository {
        return CategoriesRepositoryImpl(cloudDataSource)
    }

    @Singleton
    @Provides
    fun provideCloudDataSourceCategories(client: ApiClient): CloudDataSource<Categories> {
        return CloudDataSourceCategoriesImpl(client)
    }
}