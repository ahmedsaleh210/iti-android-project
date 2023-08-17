package com.app.myapplication.core.repo

import com.app.myapplication.core.data_source.remote.ApiInterface
import com.app.myapplication.core.model.body.LoginBodyRequest
import com.app.myapplication.core.model.response.UserResponse
import retrofit2.Response

class LoginRepository(private val apiInterface: ApiInterface) {
    suspend fun login(username: String, password: String): Response<UserResponse> {
        val bodyRequest = LoginBodyRequest(username, password)
        return apiInterface.login(bodyRequest)
    }
}