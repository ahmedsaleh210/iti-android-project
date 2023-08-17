package com.app.myapplication.Ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.myapplication.core.model.response.UserResponse
import com.app.myapplication.core.repo.LoginRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {
    private val _loginResult = MutableLiveData<Response<UserResponse>>()
    val loginResult: LiveData<Response<UserResponse>> = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val response = repository.login(username, password)
            _loginResult.value = response
        }
    }
}