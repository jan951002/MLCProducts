package com.jan.melichallenge.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.jan.melichallenge.R
import com.jan.melichallenge.ui.base.BaseActivity
import com.jan.melichallenge.databinding.ActivityMainBinding
import com.jan.melichallenge.ui.product.list.ProductsFragment
import com.jan.melichallenge.ui.search.SearchActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var searchDialog: SearchActivity
    private lateinit var navController: NavController

    override fun layoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController = findNavController(R.id.nav_host_fragment)
        searchDialog = SearchActivity()

        configSearchListener()
        binding.mainAppBar.mainBackButton.setOnClickListener { super.onBackPressed() }
    }

    private fun configSearchListener() {
        binding.mainAppBar.mainSearchEdit.setOnClickListener {
            val searchIntent = Intent(this, SearchActivity::class.java)
            resultSearchLauncher.launch(searchIntent)
        }
    }

    private fun onSearch(query: String) {
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

    fun configAppBar(isMainFragment: Boolean, text: String) {
        if (isMainFragment) {
            binding.mainAppBar.mainSearchEdit.visibility = View.VISIBLE
            binding.mainAppBar.mainTitleText.visibility = View.GONE
            binding.mainAppBar.mainBackButton.visibility = View.GONE
        } else {
            binding.mainAppBar.mainTitleText.text = text
            binding.mainAppBar.mainSearchEdit.visibility = View.GONE
            binding.mainAppBar.mainTitleText.visibility = View.VISIBLE
            binding.mainAppBar.mainBackButton.visibility = View.VISIBLE
        }
    }

    private val resultSearchLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val query = result.data?.extras?.getString("query") ?: ""
                onSearch(query)
            }
        }
}