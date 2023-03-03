package com.example.testshop.presentation.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.testshop.databinding.ActivityLoginBinding
import com.example.testshop.presentation.app.ShopApp
import com.example.testshop.presentation.main.MainActivity
import com.example.testshop.presentation.main.home.ViewModelFactory
import com.example.testshop.presentation.sign.SignActivity
import com.example.testshop.presentation.sign.SignViewModel
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private val component by lazy {
        (application as ShopApp).component
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this,viewModelFactory)[LoginViewModel::class.java]

        val sharedPrefUser = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

        var errorFirstNameHaveDb:Boolean


        binding.buttonSignIn.setOnClickListener {
            val firstName = binding.editTextFirstName.text?.trim().toString()
            loginViewModel.getUser(firstName)
            loginViewModel.errorInputFirstNamHaveBd.observe(this){ error ->
                errorFirstNameHaveDb = error
                if(errorFirstNameHaveDb != true){
                    val editor = sharedPrefUser.edit()
                    editor.putString(SHARED_KEY, firstName)
                    editor.apply()
                    val intent = MainActivity.newIntent(this)
                    startActivity(intent)
                    finish()
                } else{
                    val intent = SignActivity.newIntent(this)
                    Toast.makeText(this@LoginActivity, TOAST_MESSAGE, Toast.LENGTH_LONG).show()
                    startActivity(intent)
                    finish()
                }
            }

        }
    }

    companion object{
        private const val TOAST_MESSAGE = "Account does not exist"
        private const val SHARED_PREF = "User"
        private const val SHARED_KEY = "User first name"

        fun newIntent(context: Context): Intent{
            return Intent(context, LoginActivity::class.java)
        }
    }
}