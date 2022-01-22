package com.jan.melichallenge.ui.search

import com.jan.melichallenge.data.search.SearchRepository
import com.jan.melichallenge.usecases.search.SaveSearchUseCase
import com.jan.melichallenge.usecases.search.SearchListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class SearchDI {

    @Provides
    @ViewModelScoped
    fun saveSearchUseCaseProvider(searchRepository: SearchRepository) = SaveSearchUseCase(
        searchRepository
    )

    @Provides
    @ViewModelScoped
    fun searchListUseCaseProvider(searchRepository: SearchRepository) = SearchListUseCase(
        searchRepository
    )
}