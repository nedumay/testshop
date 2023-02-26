package com.example.testshop.presentation.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.testshop.R
import com.example.testshop.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
    get() = _binding ?: throw RuntimeException("FragmentHomeBinding = null")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCheckPhones.isChecked = true
        checkBox()
    }

    private fun checkBox() {
        binding.btnCheckPhones.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
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
        binding.btnCheckCars.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
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
        binding.btnCheckFurniture.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
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
        binding.btnCheckGames.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
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
        binding.btnCheckKids.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
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
        binding.btnCheckHeadphones.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
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

