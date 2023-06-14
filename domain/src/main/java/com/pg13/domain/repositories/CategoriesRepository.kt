package com.pg13.domain.repositories

import com.pg13.domain.entities.Categories
import com.pg13.domain.entities.Resource
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {
    fun getCategories(): Flow<Resource<Categories>>
}