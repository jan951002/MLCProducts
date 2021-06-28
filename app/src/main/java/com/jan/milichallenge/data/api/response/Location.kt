package com.jan.milichallenge.data.api.response

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name")
    val name: String
)