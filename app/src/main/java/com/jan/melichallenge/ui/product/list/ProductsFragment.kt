package com.jan.melichallenge.ui.product.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jan.melichallenge.base.BaseFragment
import com.jan.melichallenge.databinding.FragmentProductsBinding
import com.jan.melichallenge.domain.model.Product
import com.jan.melichallenge.util.MessageUtil.showShortToastWithoutAction
import com.jan.melichallenge.util.ToastyType
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class ProductsFragment : BaseFragment<FragmentProductsBinding>(FragmentProductsBinding::inflate) {

    private val productsViewModel: ProductsViewModel by viewModel()
    private lateinit var productsAdapter: ProductsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        productsAdapter = ProductsAdapter { product -> onItemClick(product) }
        binding.productsRecycler.adapter = productsAdapter
        observableViewModel()
        configScroll()
    }

    private fun observableViewModel() {
        productsViewModel.products.observe(viewLifecycleOwner, { products ->
            products?.let { productsAdapter.submitList(it) }
        })
    }

    fun findProducts(query: String) {
        productsViewModel.query = query
        productsViewModel.viewModelScope.launch { productsViewModel.searchProducts(true, 0) }
    }

    private fun configScroll() {
        val layoutManager = binding.productsRecycler.layoutManager as GridLayoutManager
        binding.productsRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val lastVisiblePosition = layoutManager.findLastVisibleItemPosition()
                if (lastVisiblePosition != 0
                    && (lastVisiblePosition + 1) == layoutManager.itemCount
                ) {
                    productsViewModel.offset.value = layoutManager.itemCount + 1
                }
            }
        })
    }

    private fun onItemClick(product: Product) {
        requireContext().showShortToastWithoutAction(ToastyType.INFO, "Product: ${product.title}")
    }
}