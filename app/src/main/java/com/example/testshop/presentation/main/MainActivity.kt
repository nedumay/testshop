package com.example.testshop.presentation.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.testshop.R
import com.example.testshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        createNavBottom()

    }

    private fun createNavBottom() {
        val host = supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        val navController = host.navController
        binding.bottomNavigation.setupWithNavController(navController)
    }

    companion object{
        private const val EXTRA_FIRST_NAME = "firstName"
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }

}