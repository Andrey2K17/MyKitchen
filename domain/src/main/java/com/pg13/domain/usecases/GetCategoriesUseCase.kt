package com.pg13.domain.usecases

import com.pg13.domain.entities.Categories
import com.pg13.domain.entities.Resource
import com.pg13.domain.repositories.CategoriesRepository
import kotlinx.coroutines.flow.Flow

class GetCategoriesUseCase(private val repository: CategoriesRepository) {
    operator fun invoke(): Flow<Resource<Categories>> = repository.getCategories()
}