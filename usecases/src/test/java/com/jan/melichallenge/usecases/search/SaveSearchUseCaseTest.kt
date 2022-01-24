package com.jan.melichallenge.usecases.search

import com.jan.melichallenge.testmanager.MainCoroutineRule
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

private const val TEST_SAVE_QUERY_VALUE = "search1"
private const val SAVE_NUM_INVOCATIONS = 1

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SaveSearchUseCaseTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var saveSearchUseCase: SaveSearchUseCase

    @Test
    fun `verify save search`() = runBlockingTest {
        saveSearchUseCase.invoke(TEST_SAVE_QUERY_VALUE)
        verify(saveSearchUseCase, times(SAVE_NUM_INVOCATIONS)).invoke(TEST_SAVE_QUERY_VALUE)
    }
}
