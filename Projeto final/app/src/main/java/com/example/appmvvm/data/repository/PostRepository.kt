package com.example.appmvvm.data.repository

import com.example.appmvvm.data.api.RetrofitInstance

class PostRepository {
    suspend fun getPosts() = RetrofitInstance.api.getPosts()
}