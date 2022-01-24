package com.jan.melichallenge.testmanager.search

import com.jan.melichallenge.domain.Search

private const val TIME_ONE = 123L
private const val TIME_TWO = 456L

val firstSearch = Search(
    0,
    "search1",
    TIME_ONE
)

val secondSearch = Search(
    1,
    "search2",
    TIME_TWO
)

val lastSearches = listOf(secondSearch, firstSearch)
