package com.example.testshop.presentation.main.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testshop.R
import com.example.testshop.databinding.FragmentProfileBinding
import com.example.testshop.presentation.sign.SignActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
    get() = _binding ?: throw RuntimeException("FragmentProfileBinding = null")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.textViewChangePhoto.setOnClickListener {
            Log.d("FragmentProfileBinding", "Change photo")
        }
        binding.linearLayoutLogOut.setOnClickListener {
            logOut()
        }
        binding.imageViewBackBtn.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
        }
    }
    /**
     * Добавить выход из аккаунта
     **/
    private fun logOut() {
        if(context != null){
            val intent = SignActivity.newIntent(requireContext())
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        } else{
            findNavController().navigate(R.id.action_profileFragment_to_signActivity)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}