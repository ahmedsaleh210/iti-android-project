package com.app.myapplication.core.repo

import com.app.myapplication.core.data_source.remote.ApiInterface
import com.app.myapplication.models.PostModel
import retrofit2.Response

class PostRepository(private val apiInterface: ApiInterface) {
    suspend fun getPostsByUserId(userId: Int): Response<List<PostModel>> {
        return apiInterface.getPostsByUserId(userId)
    }
}