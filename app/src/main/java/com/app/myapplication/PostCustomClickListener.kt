package com.app.myapplication

import com.app.myapplication.models.PostModel

interface PostCustomClickListener {
    fun onItemClickListener(post: PostModel, position: Int)
}