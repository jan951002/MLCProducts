package com.jan.melichallenge.ui.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.jan.melichallenge.domain.repository.ProductRepository

class SearchViewModel(
    application: Application, private val productRepository: ProductRepository
) : AndroidViewModel(application) {


}