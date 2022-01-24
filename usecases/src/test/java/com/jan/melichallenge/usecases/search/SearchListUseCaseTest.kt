package com.jan.melichallenge.usecases.search

import com.jan.melichallenge.domain.Search
import com.jan.melichallenge.testmanager.MainCoroutineRule
import com.jan.melichallenge.testmanager.search.lastSearches
import com.nhaarman.mockitokotlin2.given
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchListUseCaseTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var searchListUseCase: SearchListUseCase

    @Test
    fun `search list with empty result`() = runBlockingTest {
        val expectResult = emptyList<Search>()
        given { searchListUseCase.invoke() }.willReturn(flowOf(expectResult))
        searchListUseCase.invoke().collect { result -> assertEquals(expectResult, result) }
    }

    @Test
    fun `search list containing data`() = runBlockingTest {
        val expectResult = lastSearches
        given { searchListUseCase.invoke() }.willReturn(flowOf(expectResult))
        searchListUseCase.invoke().collect { result -> assertEquals(expectResult, result) }
    }
}
