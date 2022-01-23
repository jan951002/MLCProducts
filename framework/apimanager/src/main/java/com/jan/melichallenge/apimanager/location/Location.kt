package com.jan.melichallenge.apimanager.location

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name")
    val name: String
)
