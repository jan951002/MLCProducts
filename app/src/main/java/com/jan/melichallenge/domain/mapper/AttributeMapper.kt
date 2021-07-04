package com.jan.melichallenge.domain.mapper

import com.jan.melichallenge.config.AttributeResponse
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