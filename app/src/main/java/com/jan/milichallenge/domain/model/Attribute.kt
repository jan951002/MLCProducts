package com.jan.milichallenge.domain.model

data class Attribute(
    val attributeGroupId: String,
    val attributeGroupName: String,
    val id: String,
    val name: String,
    val source: Int,
    val valueId: String?,
    val valueName: String,
)