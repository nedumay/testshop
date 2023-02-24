package com.example.testshop.ui.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testshop.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    companion object{

        fun newIntent(context: Context): Intent{
            return Intent(context, LoginActivity::class.java)
        }
    }
}