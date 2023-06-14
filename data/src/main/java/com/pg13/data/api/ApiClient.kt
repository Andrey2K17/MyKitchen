package com.pg13.data.api

import com.pg13.data.entites.remote.CategoriesRemote
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("/v3/058729bd-1402-4578-88de-265481fd7d54/")
    suspend fun getCategories(): Response<CategoriesRemote>
}