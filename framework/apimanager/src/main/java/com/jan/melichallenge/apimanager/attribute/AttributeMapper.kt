package com.jan.melichallenge.apimanager.attribute

import com.jan.melichallenge.domain.Attribute

fun com.jan.melichallenge.apimanager.attribute.Attribute.toAttributeDomain() = Attribute(
    attributeGroupId = this.attributeGroupId,
    attributeGroupName = this.attributeGroupName,
    id = this.id,
    name = this.name,
    source = this.source,
    valueId = this.valueId,
    valueName = this.valueName
)