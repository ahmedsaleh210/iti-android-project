package com.app.myapplication.Utils

import com.app.myapplication.models.CommentModel
import com.app.myapplication.models.PostModel
import com.app.myapplication.models.ResponseUserList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("posts")
    suspend fun getPosts() : Response<ArrayList<PostModel>>

    @GET("posts")
    suspend fun getPostsByUserId(@Query("userId") userId: Int) : Response<ArrayList<PostModel>>

    @GET("posts/{id}/comments")
    suspend fun getCommentsByPostId(@Path("id") id: Int) : Response<ArrayList<CommentModel>>
}