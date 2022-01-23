package com.jan.melichallenge.ui.search

import com.jan.melichallenge.data.search.SearchRepository
import com.jan.melichallenge.usecases.search.SaveSearchUseCase
import com.jan.melichallenge.usecases.search.SearchListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 *  Module for defining search use case dependencies with the Hilt library
 *  @author Jaime Trujillo
 */
@Module
@InstallIn(ViewModelComponent::class)
class SearchDI {

    /**
     *  Function to provide a save search use case instance in the ViewModel scope
     *  @param searchRepository To create the instance
     *  @author Jaime Trujillo
     */
    @Provides
    @ViewModelScoped
    fun saveSearchUseCaseProvider(searchRepository: SearchRepository) = SaveSearchUseCase(
        searchRepository
    )

    /**
     *  Function to provide a search list use case instance in the ViewModel scope
     *  @param searchRepository To create the instance
     *  @author Jaime Trujillo
     */
    @Provides
    @ViewModelScoped
    fun searchListUseCaseProvider(searchRepository: SearchRepository) = SearchListUseCase(
        searchRepository
    )
}