package com.example.testshop.presentation.main.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshop.domain.usecase.DeleteUserFromDbUseCase
import kotlinx.coroutines.launch

import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val deleteUserFromDbUseCase: DeleteUserFromDbUseCase
) : ViewModel() {

    fun deleteUser(firstName : String){
        viewModelScope.launch {
            deleteUserFromDbUseCase(firstName)
        }
    }

}