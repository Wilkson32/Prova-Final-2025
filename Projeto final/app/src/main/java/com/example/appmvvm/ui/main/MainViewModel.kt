package com.example.appmvvm.ui.main

import androidx.lifecycle.*
import com.example.appmvvm.data.model.Post
import com.example.appmvvm.data.repository.PostRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = PostRepository()
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    fun fetchPosts() {
        viewModelScope.launch {
            _posts.value = repository.getPosts()
        }
    }
}