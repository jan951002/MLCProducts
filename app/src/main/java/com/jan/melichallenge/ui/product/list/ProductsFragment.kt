package com.jan.melichallenge.ui.product.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jan.melichallenge.R
import com.jan.melichallenge.databinding.FragmentProductsBinding
import com.jan.melichallenge.domain.Product
import com.jan.melichallenge.imagemanager.loadDrawable
import com.jan.melichallenge.internetmanager.isOnline
import com.jan.melichallenge.mapper.toProductParcelable
import com.jan.melichallenge.ui.base.BaseFragment
import com.jan.melichallenge.ui.main.MainActivity
import com.jan.melichallenge.ui.product.list.SearchProductsState.GENERAL_ERROR
import com.jan.melichallenge.ui.product.list.SearchProductsState.LOADING
import com.jan.melichallenge.ui.product.list.SearchProductsState.NEW_SEARCH
import com.jan.melichallenge.ui.product.list.SearchProductsState.NETWORK_ERROR
import com.jan.melichallenge.ui.product.list.SearchProductsState.NOT_FOUND
import com.jan.melichallenge.ui.product.list.SearchProductsState.SEARCHED
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductsBinding>(FragmentProductsBinding::inflate) {

    private val productsViewModel: ProductsViewModel by viewModels()
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        productsAdapter = ProductsAdapter { product -> onItemClick(product) }
        binding.productsRecycler.adapter = productsAdapter
        navController = Navigation.findNavController(binding.root)
        observableViewModel()
        configScroll()
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).configAppBar(true, "")
    }

    private fun observableViewModel() {
        productsViewModel.products.observe(viewLifecycleOwner, { products ->
            products?.let { productsAdapter.submitList(it) }
        })

        productsViewModel.searchState.observe(viewLifecycleOwner, { searchState ->
            configVisible(searchState)
        })
    }

    fun findProducts(query: String) {
        productsViewModel.query = query
        productsViewModel.searchProducts(true, 0)
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

    private fun configVisible(searchState: SearchProductsState) {
        when (searchState) {
            NEW_SEARCH -> {
                binding.productsSearchState.searchStateImage.loadDrawable(R.drawable.ic_binoculars)
                binding.productsSearchState.searchStateText.text =
                    getString(R.string.lab_search_suggestion)
                binding.productsRecycler.visibility = View.GONE
                binding.loadingSpinKit.visibility = View.GONE
                binding.productsSearchState.root.visibility = View.VISIBLE
            }
            SEARCHED -> {
                binding.productsRecycler.visibility = View.VISIBLE
                binding.loadingSpinKit.visibility = View.GONE
                binding.productsSearchState.root.visibility = View.GONE
            }
            NOT_FOUND -> {
                binding.productsSearchState.searchStateImage.loadDrawable(R.drawable.ic_not_found)
                binding.productsSearchState.searchStateText.text =
                    getString(R.string.lab_search_not_found)
                binding.productsRecycler.visibility = View.GONE
                binding.loadingSpinKit.visibility = View.GONE
                binding.productsSearchState.root.visibility = View.VISIBLE
            }
            GENERAL_ERROR -> {
                binding.productsSearchState.searchStateImage.loadDrawable(R.drawable.ic_error)
                binding.productsSearchState.searchStateText.text =
                    if (requireContext().isOnline())
                        getString(R.string.lab_search_general_error)
                    else
                        getString(R.string.lab_search_is_offline)
                binding.productsRecycler.visibility = View.GONE
                binding.loadingSpinKit.visibility = View.GONE
                binding.productsSearchState.root.visibility = View.VISIBLE
            }
            NETWORK_ERROR -> {
                binding.productsSearchState.searchStateImage.loadDrawable(R.drawable.ic_error)
                binding.productsSearchState.searchStateText.text =
                    if (requireContext().isOnline())
                        getString(R.string.lab_search_network_error)
                    else {
                        getString(R.string.lab_search_is_offline)
                    }
                binding.productsRecycler.visibility = View.GONE
                binding.loadingSpinKit.visibility = View.GONE
                binding.productsSearchState.root.visibility = View.VISIBLE
            }
            LOADING -> {
                binding.productsRecycler.visibility = View.GONE
                binding.loadingSpinKit.visibility = View.VISIBLE
                binding.productsSearchState.root.visibility = View.GONE
            }
        }
    }

    private fun onItemClick(product: Product) {
        val direction = ProductsFragmentDirections
            .actionNavProductsFragmentToNavProductDetailFragment(product.toProductParcelable())
        navController.navigate(direction)
    }
}
