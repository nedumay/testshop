package com.example.testshop.ui.sign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.testshop.R
import com.example.testshop.databinding.ActivitySignBinding
import com.example.testshop.ui.login.LoginActivity

class SignActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textViewLogin.setOnClickListener {
            val intent = LoginActivity.newIntent(this)
            startActivity(intent)
        }

    }
}