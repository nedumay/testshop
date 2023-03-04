package com.example.testshop.presentation.sign

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.testshop.databinding.ActivitySignBinding
import com.example.testshop.presentation.app.ShopApp
import com.example.testshop.presentation.login.LoginActivity
import com.example.testshop.presentation.main.MainActivity
import com.example.testshop.presentation.main.home.ViewModelFactory
import javax.inject.Inject

class SignActivity : AppCompatActivity() {

    private lateinit var signViewModel: SignViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }

    private val component by lazy {
        (application as ShopApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sharedPrefUser = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

        signViewModel = ViewModelProvider(this, viewModelFactory)[SignViewModel::class.java]

        var errorFirstNameHaveDb: Boolean

        isEmailValid()
        isFirstNameValid()
        isLastNameValid()

        binding.buttonSignIn.setOnClickListener {
            val firstName = binding.editTextFirstName.text?.trim().toString()
            val lastName = binding.editTextLastName.text?.trim().toString()
            val email = binding.editTextEmail.text?.trim().toString()
            signViewModel.addUser(firstName, lastName, email)

            signViewModel.errorInputFirstNamHaveBd.observe(this) { haveBd ->
                errorFirstNameHaveDb = haveBd
                val editor = sharedPrefUser.edit()
                if (errorFirstNameHaveDb) {
                    Toast.makeText(this, INVALID_FIRST_NAME, Toast.LENGTH_LONG).show()
                } else {
                    editor.putString(SHARED_KEY, firstName)
                    editor.apply()
                    val intent = MainActivity.newIntent(this)
                    startActivity(intent)
                    finish()
                }

            }
        }
        binding.textViewLogin.setOnClickListener {
            val intent = LoginActivity.newIntent(this)
            startActivity(intent)
        }

    }

    private fun isEmailValid() {
        binding.editTextEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val valid =
                    android.util.Patterns.EMAIL_ADDRESS.matcher(s?.trim().toString()).matches()
                if (!valid) {
                    binding.tilEmail.error = INVALID_ADDRESS
                } else {
                    binding.tilEmail.error = EMPTY_FIELD
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 0) {
                    binding.tilEmail.error = NOT_BE_EMPTY
                }
            }
        })
    }

    private fun isFirstNameValid() {
        binding.editTextFirstName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.isNotBlank() == true) {
                    binding.tilFirstName.error = EMPTY_FIELD
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 0) {
                    binding.tilFirstName.error = NOT_BE_EMPTY
                }
            }
        })
    }

    private fun isLastNameValid() {
        binding.editTextLastName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.isNotBlank() == true) {
                    binding.tilLastName.error = EMPTY_FIELD
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 0) {
                    binding.tilLastName.error = NOT_BE_EMPTY
                }
            }
        })
    }

    companion object {
        private const val SHARED_PREF = "User"
        private const val SHARED_KEY = "User first name"
        private const val EMPTY_FIELD = ""
        private const val INVALID_ADDRESS = "Invalid Email address"
        private const val INVALID_FIRST_NAME = "Аn account with the same name already exists"
        private const val NOT_BE_EMPTY = "Required Field!"

        fun newIntent(context: Context): Intent {
            return Intent(context, SignActivity::class.java)
        }
    }
}