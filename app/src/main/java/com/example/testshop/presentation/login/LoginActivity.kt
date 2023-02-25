package com.example.testshop.presentation.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testshop.databinding.ActivityLoginBinding
import com.example.testshop.presentation.main.MainActivity

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonSignIn.setOnClickListener {
            val intent = MainActivity.newIntent(this)
            startActivity(intent)
        }
    }

    companion object{

        fun newIntent(context: Context): Intent{
            return Intent(context, LoginActivity::class.java)
        }
    }
}