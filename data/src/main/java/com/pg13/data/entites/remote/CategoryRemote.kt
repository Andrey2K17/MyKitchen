package com.pg13.data.entites.remote

import com.google.gson.annotations.SerializedName

data class CategoryRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image_url") val imageUrl: String
)