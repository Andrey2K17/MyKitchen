package com.pg13.data.mappers

import com.pg13.data.entites.remote.CategoriesRemote
import com.pg13.data.entites.remote.CategoryRemote
import com.pg13.domain.entities.Categories
import com.pg13.domain.entities.Category

fun CategoryRemote.mapToDomain(): Category = Category(id, name, imageUrl)

fun CategoriesRemote.mapToDomain(): Categories = Categories(categories.map { it.mapToDomain() })