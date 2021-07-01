package com.jan.melichallenge.domain.mapper

import com.jan.melichallenge.config.AttributeResponse
import com.jan.melichallenge.config.AttributeRoom
import com.jan.melichallenge.domain.model.Attribute

fun AttributeResponse.toAttributeDomain() = Attribute(
    attributeGroupId = this.attributeGroupId,
    attributeGroupName = this.attributeGroupName,
    id = this.id,
    name = this.name,
    source = this.source,
    valueId = this.valueId,
    valueName = this.valueName
)

fun AttributeRoom.toAttributeDomain() = Attribute(
    attributeGroupId = this.attributeGroupId,
    attributeGroupName = this.attributeGroupName,
    id = this.attributeId,
    name = this.attributeName,
    source = this.source,
    valueId = this.valueId,
    valueName = this.valueName
)

fun Attribute.toAttributeRoom() = AttributeRoom(
    attributeGroupId = this.attributeGroupId,
    attributeGroupName = this.attributeGroupName,
    attributeId = this.id,
    attributeName = this.name,
    source = this.source,
    valueId = this.valueId,
    valueName = this.valueName
)