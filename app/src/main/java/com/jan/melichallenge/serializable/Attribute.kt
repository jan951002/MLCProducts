package com.jan.melichallenge.serializable

import java.io.Serializable

data class Attribute(
    val attributeGroupId: String?,
    val attributeGroupName: String?,
    val id: String?,
    val name: String?,
    val source: Long,
    val valueId: String?,
    val valueName: String?,
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}

typealias AttributeSerializable = Attribute
