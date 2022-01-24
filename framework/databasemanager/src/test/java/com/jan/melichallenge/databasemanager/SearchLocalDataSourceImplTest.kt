package com.jan.melichallenge.databasemanager

import com.jan.melichallenge.databasemanager.search.SearchLocalDataSourceImpl
import com.jan.melichallenge.domain.Search
import com.jan.melichallenge.testmanager.MainCoroutineRule
import com.jan.melichallenge.testmanager.search.firstSearch
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

private const val SAVE_NUM_INVOCATIONS = 1

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchLocalDataSourceImplTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var searchLocalDataSource: SearchLocalDataSourceImpl

    @Test
    fun `verify save search in local datasource`() = runBlockingTest {
        searchLocalDataSource.save(firstSearch)
        verify(searchLocalDataSource, times(SAVE_NUM_INVOCATIONS)).save(firstSearch)
    }

    @Test
    fun `get last searches with empty result`() = runBlockingTest {
        val expectResult = emptyList<Search>()
        given(searchLocalDataSource.getLastSearches()).willReturn(flowOf(expectResult))
        searchLocalDataSource.getLastSearches().collect { result ->
            assertEquals(expectResult, result)
        }
    }

    @Test
    fun `get last searches with data`() = runBlockingTest {
        val expectResult = lastSearches
        given(searchLocalDataSource.getLastSearches()).willReturn(flowOf(expectResult))
        searchLocalDataSource.getLastSearches().collect { result ->
            assertEquals(expectResult, result)
        }
    }
}
