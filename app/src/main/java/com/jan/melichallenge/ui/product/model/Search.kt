package com.jan.melichallenge.ui.product.model

import java.io.Serializable

data class Search(
    val localId: Int,
    val query: String,
    val time: Long
) : Serializable