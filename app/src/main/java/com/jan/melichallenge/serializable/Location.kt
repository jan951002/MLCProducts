package com.jan.melichallenge.serializable

import java.io.Serializable

data class Location(
    val name: String
) : Serializable

typealias LocationSerializable = Location