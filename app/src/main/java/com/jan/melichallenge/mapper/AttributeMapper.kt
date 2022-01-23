package com.jan.melichallenge.mapper

import com.jan.melichallenge.domain.Attribute
import com.jan.melichallenge.serializable.AttributeSerializable

fun AttributeSerializable.toAttributeDomain() = Attribute(
    attributeGroupId = this.attributeGroupId,
    attributeGroupName = this.attributeGroupName,
    id = this.id,
    name = this.name,
    source = this.source,
    valueId = this.valueId,
    valueName = this.valueName
)

fun Attribute.toAttributeParcelable() = AttributeSerializable(
    attributeGroupId = this.attributeGroupId,
    attributeGroupName = this.attributeGroupName,
    id = this.id,
    name = this.name,
    source = this.source,
    valueId = this.valueId,
    valueName = this.valueName
)
