package com.jan.melichallenge.ui.product.detail

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jan.melichallenge.R
import com.jan.melichallenge.base.BaseFragment
import com.jan.melichallenge.databinding.FragmentProductDetailBinding
import com.jan.melichallenge.ui.main.MainActivity
import com.jan.melichallenge.ui.product.mapper.toProductDomain

class ProductDetailFragment :
    BaseFragment<FragmentProductDetailBinding>(FragmentProductDetailBinding::inflate) {

    private val attributesAdapter = AttributesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configLayoutManager()
        binding.attributesRecycler.adapter = attributesAdapter
        arguments?.getSerializable("product")?.let {
            val product = (it as com.jan.melichallenge.ui.product.model.Product).toProductDomain()
            binding.product = product
            attributesAdapter.submitList(
                product.attributes.filter { attribute -> attribute.name != null && attribute.valueName != null }
            )
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).configAppBar(
            false, getString(R.string.lab_product_detail)
        )
    }

    private fun configLayoutManager() {
        if (requireContext().resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.attributesRecycler.layoutManager = LinearLayoutManager(requireContext())
        } else {
            binding.attributesRecycler.layoutManager = GridLayoutManager(requireContext(), 3)
        }
    }
}