package com.example.pupilmeshporject.presentation.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pupilmeshporject.domain.model.User
import com.example.pupilmeshporject.domain.usecases.AuthUserCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUserCases: AuthUserCases
) : ViewModel(){

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var error by mutableStateOf<String?>(null)
    var navigateToHome by mutableStateOf(false)

    fun onSignInClick() {
        viewModelScope.launch {
            if( email.isBlank() || password.isBlank()){
                error = "Email and Password can't be empty"
                return@launch
            }

            val user = authUserCases.getUser(email)
            if (user == null ) {
                error = "Wrong Credential"
                return@launch
            }else {
                navigateToHome = true
            }

        }
    }

    fun onSignUpClick() {
        viewModelScope.launch {
            if( email.isBlank() || password.isBlank()){
                error = "Email and Password can't be empty"
                return@launch
            }

            val user = authUserCases.getUser(email)
            if (user != null ) {
                error = "User Already exists please login"
                return@launch
            }else {
                authUserCases.insertUser(User(email,password))
                navigateToHome = true
            }
        }
    }
}