package com.jan.melichallenge.data.database.mapper

import com.jan.melichallenge.domain.Search

fun com.jan.melichallenge.data.database.model.Search.toSearchDomain() = Search(
    localId = this.localId,
    query = this.query,
    time = this.time
)

fun Search.toSearchRoom() = com.jan.melichallenge.data.database.model.Search(
    query = this.query,
    time = this.time
)