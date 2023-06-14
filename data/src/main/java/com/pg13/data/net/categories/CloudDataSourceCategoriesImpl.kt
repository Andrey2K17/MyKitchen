package com.pg13.data.net.categories

import com.pg13.data.api.ApiClient
import com.pg13.data.interfaces.CloudDataSource
import com.pg13.data.mappers.mapToDomain
import com.pg13.data.util.networkBoundResource
import com.pg13.domain.entities.Categories
import com.pg13.domain.entities.Resource
import kotlinx.coroutines.flow.Flow

class CloudDataSourceCategoriesImpl(
    private val api: ApiClient
) : CloudDataSource<Categories> {
    override fun getData(): Flow<Resource<Categories>> = networkBoundResource(
        { api.getCategories() },
        { cloudData -> cloudData.mapToDomain()}
    )
}