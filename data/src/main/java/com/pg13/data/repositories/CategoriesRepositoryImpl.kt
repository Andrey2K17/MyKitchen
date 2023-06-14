package com.pg13.data.repositories

import com.pg13.data.interfaces.CloudDataSource
import com.pg13.domain.entities.Categories
import com.pg13.domain.entities.Resource
import com.pg13.domain.repositories.CategoriesRepository
import kotlinx.coroutines.flow.Flow

class CategoriesRepositoryImpl(
    private val cloudDataSource: CloudDataSource<Categories>
): CategoriesRepository {
    override fun getCategories(): Flow<Resource<Categories>> = cloudDataSource.getData()
}