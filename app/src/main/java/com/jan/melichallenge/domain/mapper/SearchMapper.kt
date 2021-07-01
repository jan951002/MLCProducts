package com.jan.melichallenge.domain.mapper

import com.jan.melichallenge.config.SearchRoom
import com.jan.melichallenge.domain.model.Search

fun SearchRoom.toSearchDomain() = Search(
    localId = this.localId,
    query = this.query,
    time = this.time
)

fun Search.toSearchRoom() = SearchRoom(
    query = this.query,
    time = this.time
)