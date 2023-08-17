package com.app.myapplication.core.data_source.remote

import com.app.myapplication.core.model.body.LoginBodyRequest
import com.app.myapplication.core.model.response.UserResponse
import com.app.myapplication.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("posts")
    suspend fun getPosts(): Response<List<PostModel>>

    @GET("posts")
    suspend fun getPostsByUserId(@Query("userId") userId: Int): Response<List<PostModel>>

    @GET("posts/{id}/comments")
    suspend fun getCommentsByPostId(@Path("id") id: Int): Response<List<CommentModel>>

    @POST("auth/login")
    suspend fun login(@Body bodyRequest: LoginBodyRequest): Response<UserResponse>
}