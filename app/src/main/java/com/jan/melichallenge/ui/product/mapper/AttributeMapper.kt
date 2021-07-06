package com.jan.melichallenge.ui.product.mapper

import com.jan.melichallenge.config.AttributeParcelable
import com.jan.melichallenge.domain.model.Attribute

fun AttributeParcelable.toAttributeDomain() = Attribute(
    attributeGroupId = this.attributeGroupId,
    attributeGroupName = this.attributeGroupName,
    id = this.id,
    name = this.name,
    source = this.source,
    valueId = this.valueId,
    valueName = this.valueName
)

fun Attribute.toAttributeParcelable() = AttributeParcelable(
    attributeGroupId = this.attributeGroupId,
    attributeGroupName = this.attributeGroupName,
    id = this.id,
    name = this.name,
    source = this.source,
    valueId = this.valueId,
    valueName = this.valueName
)