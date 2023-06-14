package com.pg13.data.entites.remote

import com.google.gson.annotations.SerializedName

data class CategoriesRemote(
    @SerializedName("сategories") val categories: List<CategoryRemote>
)