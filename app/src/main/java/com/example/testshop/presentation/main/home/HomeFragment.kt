package com.example.testshop.presentation.main.home


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testshop.R
import com.example.testshop.databinding.FragmentHomeBinding
import com.example.testshop.presentation.app.ShopApp
import com.example.testshop.presentation.main.home.adapters.flashsale.FlashSaleAdapter
import com.example.testshop.presentation.main.home.adapters.latest.LatestAdapter
import javax.inject.Inject

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding = null")

    private val component by lazy {
        (requireActivity().application as ShopApp).component
    }

    private lateinit var latestAdapter: LatestAdapter
    private lateinit var flashSaleAdapter: FlashSaleAdapter

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

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
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]

        binding.btnCheckPhones.isChecked = true
        drawText()

        latestAdapter = LatestAdapter()
        binding.recyclerViewLatest.adapter = latestAdapter
        binding.recyclerViewBrands.adapter = latestAdapter
        viewModel.latestInfoList.observe(viewLifecycleOwner) {
            latestAdapter.submitList(it)
        }
        flashSaleAdapter = FlashSaleAdapter()
        binding.recyclerViewFlashSale.adapter = flashSaleAdapter
        viewModel.flashSaleInfoList.observe(viewLifecycleOwner) {
            flashSaleAdapter.submitList(it)
        }
    }

    private fun drawText() {
        val spans = SpannableString(getString(R.string.trade_by_bata))
        spans.setSpan(ForegroundColorSpan(Color.BLACK), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.textViewTradeBy.setText(spans)
    }

}

