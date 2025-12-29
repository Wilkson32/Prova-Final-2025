package com.example.appmvvm.data.api

import com.example.appmvvm.data.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}