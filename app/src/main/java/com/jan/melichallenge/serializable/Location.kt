package com.jan.melichallenge.serializable

import java.io.Serializable

data class Location(
    val name: String
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}

typealias LocationSerializable = Location
