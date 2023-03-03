package com.example.testshop.presentation.sign

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshop.domain.model.users.User
import com.example.testshop.domain.usecase.AddUserToDbUseCase
import com.example.testshop.domain.usecase.GetUserFromDbUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class SignViewModel @Inject constructor(
    private val getUserFromDbUseCase: GetUserFromDbUseCase,
    private val addUserToDbUseCase: AddUserToDbUseCase
) : ViewModel() {

    private val _errorInputFirstNameHaveBd = MutableLiveData<Boolean>()
    val errorInputFirstNamHaveBd: LiveData<Boolean>
        get() = _errorInputFirstNameHaveBd

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    private suspend fun getUser(firstName: String) {
        viewModelScope.launch {
            val userDb = getUserFromDbUseCase.invoke(firstName)
            _user.value = userDb
        }.join()
    }

    fun addUser(inputFirstName: String?, inputLastName: String?, inputEmail: String?) {
        val firstName = inputFirstName?.trim() ?: ""
        val lastName = inputLastName?.trim() ?: ""
        val email = inputEmail?.trim() ?: ""
        viewModelScope.launch {
            getUser(firstName)
            val fieldsValid = validateInputName(firstName, lastName, email)
            if (fieldsValid) {
                val userAdd = User(firstName = firstName, lastName = lastName, email = email)
                addUserToDbUseCase.invoke(userAdd)
            }
            Log.d("getUser", "Not Add user")
        }
    }

    private fun validateInputName(firstName: String, lastName: String, email: String): Boolean {
        val valid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        if (firstName == _user.value?.firstName) {
            _errorInputFirstNameHaveBd.value = true
            return false
        } else if (firstName.isEmpty()) {
            return false
        } else if (lastName.isEmpty()) {
            return false
        } else if (!valid) {
            return false
        } else if (email.isEmpty()) {
            return false
        } else{
            _errorInputFirstNameHaveBd.value = false
            return true
        }
    }
}