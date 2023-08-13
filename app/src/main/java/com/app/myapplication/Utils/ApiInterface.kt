package com.app.myapplication.Utils

import com.app.myapplication.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("posts")
    suspend fun getPosts() : Response<ArrayList<PostModel>>

    @GET("posts")
    suspend fun getPostsByUserId(@Query("userId") userId: Int) : Response<ArrayList<PostModel>>

    @GET("posts/{id}/comments")
    suspend fun getCommentsByPostId(@Path("id") id: Int) : Response<ArrayList<CommentModel>>

    @POST("auth/login")
    suspend fun login(@Body bodyRequest: LoginBodyRequest): Response<UserResponse>
}