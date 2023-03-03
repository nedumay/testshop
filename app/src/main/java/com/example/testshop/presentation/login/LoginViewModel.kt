package com.example.testshop.presentation.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshop.domain.model.users.User
import com.example.testshop.domain.usecase.GetUserFromDbUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val getUserFromDbUseCase: GetUserFromDbUseCase
) : ViewModel() {

    private val _userLogin = MutableLiveData<User>()
    val userLogin: LiveData<User>
        get() = _userLogin

    private val _errorInputFirstNameHaveBd = MutableLiveData<Boolean>()
    val errorInputFirstNamHaveBd: LiveData<Boolean>
        get() = _errorInputFirstNameHaveBd

    fun getUser(firstName: String){
        viewModelScope.launch {
            val userDb = getUserFromDbUseCase.invoke(firstName)
            Log.d("getUser","UserDb: $userDb")
            if(userDb.firstName != ""){
                _userLogin.value = userDb
                Log.d("getUser","User: ${_userLogin.value}")
                _errorInputFirstNameHaveBd.value = false
                Log.d("getUser","Error LD false ${_errorInputFirstNameHaveBd.value}")
            } else{
                _errorInputFirstNameHaveBd.value = true
                Log.d("getUser","Error LD true ${_errorInputFirstNameHaveBd.value}")
            }
        }
    }

}