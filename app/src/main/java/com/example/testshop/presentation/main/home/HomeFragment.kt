package com.example.testshop.presentation.main.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testshop.data.repository.ListRepositoryImpl
import com.example.testshop.databinding.FragmentHomeBinding
import com.example.testshop.domain.usecase.LoadDataUseCase
import com.example.testshop.presentation.main.home.adapters.flashsale.FlashSaleAdapter
import com.example.testshop.presentation.main.home.adapters.latest.LatestAdapter
import kotlinx.coroutines.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding = null")

    private lateinit var latestAdapter: LatestAdapter
    private lateinit var flashSaleAdapter: FlashSaleAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        binding.btnCheckPhones.isChecked = true
        checkBox()

        latestAdapter = LatestAdapter()
        binding.recyclerViewLatest.adapter = latestAdapter
        binding.recyclerViewBrands.adapter = latestAdapter
        viewModel.latestInfoList.observe(viewLifecycleOwner){
            latestAdapter.submitList(it)
        }
        flashSaleAdapter = FlashSaleAdapter()
        binding.recyclerViewFlashSale.adapter = flashSaleAdapter
        viewModel.flashSaleInfoList.observe(viewLifecycleOwner){
            flashSaleAdapter.submitList(it)
        }
    }

    private fun checkBox() {
        binding.btnCheckPhones.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.btnCheckPhones.isChecked = true
                binding.btnCheckCars.isChecked = false
                binding.btnCheckFurniture.isChecked = false
                binding.btnCheckGames.isChecked = false
                binding.btnCheckKids.isChecked = false
                binding.btnCheckHeadphones.isChecked = false
            } else {
                binding.btnCheckPhones.isChecked = false
            }
        }
        binding.btnCheckCars.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.btnCheckPhones.isChecked = false
                binding.btnCheckCars.isChecked = true
                binding.btnCheckFurniture.isChecked = false
                binding.btnCheckGames.isChecked = false
                binding.btnCheckKids.isChecked = false
                binding.btnCheckHeadphones.isChecked = false
            } else {
                binding.btnCheckCars.isChecked = false
            }
        }
        binding.btnCheckFurniture.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.btnCheckPhones.isChecked = false
                binding.btnCheckCars.isChecked = false
                binding.btnCheckFurniture.isChecked = true
                binding.btnCheckGames.isChecked = false
                binding.btnCheckKids.isChecked = false
                binding.btnCheckHeadphones.isChecked = false
            } else {
                binding.btnCheckFurniture.isChecked = false
            }
        }
        binding.btnCheckGames.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.btnCheckPhones.isChecked = false
                binding.btnCheckCars.isChecked = false
                binding.btnCheckFurniture.isChecked = false
                binding.btnCheckGames.isChecked = true
                binding.btnCheckKids.isChecked = false
                binding.btnCheckHeadphones.isChecked = false
            } else {
                binding.btnCheckGames.isChecked = false
            }
        }
        binding.btnCheckKids.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.btnCheckPhones.isChecked = false
                binding.btnCheckCars.isChecked = false
                binding.btnCheckFurniture.isChecked = false
                binding.btnCheckGames.isChecked = false
                binding.btnCheckKids.isChecked = true
                binding.btnCheckHeadphones.isChecked = false
            } else {
                binding.btnCheckKids.isChecked = false
            }
        }
        binding.btnCheckHeadphones.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.btnCheckPhones.isChecked = false
                binding.btnCheckCars.isChecked = false
                binding.btnCheckFurniture.isChecked = false
                binding.btnCheckGames.isChecked = false
                binding.btnCheckKids.isChecked = false
                binding.btnCheckHeadphones.isChecked = true
            } else {
                binding.btnCheckHeadphones.isChecked = false
            }
        }

    }

}

