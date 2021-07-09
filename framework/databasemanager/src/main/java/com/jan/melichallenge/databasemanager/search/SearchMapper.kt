package com.jan.melichallenge.databasemanager.search

import com.jan.melichallenge.domain.Search

fun com.jan.melichallenge.databasemanager.search.Search.toSearchDomain() = Search(
    localId = this.localId,
    query = this.query,
    time = this.time
)

fun Search.toSearchRoom() = Search(
    query = this.query,
    time = this.time
)