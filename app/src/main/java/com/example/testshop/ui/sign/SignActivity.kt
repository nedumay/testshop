package com.example.testshop.ui.sign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
        isEmailValid()
    }

    private fun isEmailValid() {
        binding.editTextEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val email = binding.editTextEmail.text?.trim().toString()
                val valid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                if (!valid) {
                    binding.tilEmail.error = INVALID_ADDRESS
                } else {
                    binding.tilEmail.error = EMPTY_FIELD
                }
            }
        })
    }

    companion object{
        private const val EMPTY_FIELD = ""
        private const val INVALID_ADDRESS = "Invalid Email address"
    }
}