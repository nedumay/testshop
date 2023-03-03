package com.example.testshop.presentation.main.profile

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testshop.R
import com.example.testshop.databinding.FragmentProfileBinding
import com.example.testshop.presentation.app.ShopApp
import com.example.testshop.presentation.main.home.HomeViewModel
import com.example.testshop.presentation.main.home.ViewModelFactory
import com.example.testshop.presentation.sign.SignActivity
import javax.inject.Inject

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
    get() = _binding ?: throw RuntimeException("FragmentProfileBinding = null")

    private lateinit var viewModel: ProfileViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as ShopApp).component
    }

    lateinit var editor: SharedPreferences

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[ProfileViewModel::class.java]
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

    private fun logOut() {
        editor = requireActivity().getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        val userFirsName = editor.getString(SHARED_KEY, EMPTY)
        viewModel.deleteUser(userFirsName!!)
        if(context != null){
            val intent = SignActivity.newIntent(requireContext())
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        } else{
            findNavController().navigate(R.id.action_profileFragment_to_signActivity)
        }
        val delete = editor.edit()
        delete.clear()
        delete.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        private const val SHARED_PREF = "User"
        private const val SHARED_KEY = "User first name"
        private const val EMPTY = ""

    }
}