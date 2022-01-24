package com.jan.melichallenge.ui.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.jan.melichallenge.domain.Search
import com.jan.melichallenge.testmanager.MainCoroutineRule
import com.jan.melichallenge.testmanager.search.lastSearches
import com.jan.melichallenge.usecases.search.SearchListUseCase
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest{

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var searchListUseCase: SearchListUseCase

    private lateinit var searchViewModel: SearchViewModel

    @Mock
    private lateinit var observer:Observer<List<Search>>

    @Test
    fun `search list with empty result`() = runBlockingTest {
        val expectResult = emptyList<Search>()
        given { searchListUseCase.invoke() }.willReturn(flowOf(expectResult))

        searchViewModel = SearchViewModel(searchListUseCase)
        searchViewModel.lastSearches.observeForever(observer)

        verify(observer).onChanged(expectResult)
    }

    @Test
    fun `search list containing data`() = runBlockingTest {
        val expectResult = lastSearches
        given { searchListUseCase.invoke() }.willReturn(flowOf(expectResult))

        searchViewModel = SearchViewModel(searchListUseCase)
        searchViewModel.lastSearches.observeForever(observer)

        verify(observer).onChanged(expectResult)
    }
}
