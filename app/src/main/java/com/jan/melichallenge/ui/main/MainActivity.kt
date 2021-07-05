package com.jan.melichallenge.ui.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.jan.melichallenge.R
import com.jan.melichallenge.base.BaseActivity
import com.jan.melichallenge.databinding.ActivityMainBinding
import com.jan.melichallenge.ui.product.list.ProductsFragment
import com.jan.melichallenge.ui.search.SearchDialog
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate),
    SearchDialog.OnSearchPressed {

    private lateinit var searchDialog: SearchDialog
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var navController: NavController

    override fun layoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController = findNavController(R.id.nav_host_fragment)
        searchDialog = SearchDialog(this, this)

        configSearchListener()
        observableViewModel()
    }

    private fun observableViewModel() {
        mainViewModel.lastSearches.observe(this, { searchSuggestions ->
            searchDialog.searchSuggestions = searchSuggestions
        })
    }

    private fun configSearchListener() {
        binding.mainAppBar.mainSearchEdit.setOnClickListener { searchDialog.show() }
    }

    override fun onSearch(query: String) {
        if (query.isNotEmpty()) {
            binding.mainAppBar.mainSearchEdit.setText(query)
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            if (navController.currentDestination?.id == R.id.nav_products_fragment) {
                navHostFragment!!.childFragmentManager.fragments[0]?.let {
                    (it as ProductsFragment).findProducts(query)
                }
            }
        }
    }
}