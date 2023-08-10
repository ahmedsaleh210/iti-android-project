package com.app.myapplication.Utils

import com.app.myapplication.models.ResponseUserList
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/api/users?page=1")
    suspend fun getUsers() : Response<ResponseUserList>
}