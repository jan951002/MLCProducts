package com.jan.melichallenge.data.search

import com.jan.melichallenge.domain.Search
import com.jan.melichallenge.testmanager.MainCoroutineRule
import com.jan.melichallenge.testmanager.search.lastSearches
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
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

private const val TEST_SAVE_QUERY_VALUE = "search1"
private const val SAVE_NUM_INVOCATIONS = 1

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchRepositoryImplTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var searchRepository: SearchRepositoryImpl

    @Test
    fun `verify save search in repository`() = runBlockingTest {
        searchRepository.save(TEST_SAVE_QUERY_VALUE)
        verify(searchRepository, times(SAVE_NUM_INVOCATIONS)).save(TEST_SAVE_QUERY_VALUE)
    }

    @Test
    fun `get last searches with empty result`() = runBlockingTest {
        val expectResult = emptyList<Search>()
        given(searchRepository.getLastSearches()).willReturn(flowOf(expectResult))
        searchRepository.getLastSearches().collect { result ->
            assertEquals(expectResult, result)
        }
    }

    @Test
    fun `get last searches with data`() = runBlockingTest {
        val expectResult = lastSearches
        given(searchRepository.getLastSearches()).willReturn(flowOf(expectResult))
        searchRepository.getLastSearches().collect { result ->
            assertEquals(expectResult, result)
        }
    }
}
