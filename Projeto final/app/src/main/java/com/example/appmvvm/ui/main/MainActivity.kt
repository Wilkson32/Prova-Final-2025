package com.example.appmvvm.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmvvm.R
import com.example.appmvvm.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.posts.observe(this) {
            recyclerView.adapter = PostAdapter(it) { post ->
                val i = Intent(this, DetailActivity::class.java)
                i.putExtra("title", post.title)
                i.putExtra("body", post.body)
                startActivity(i)
            }
        }

        viewModel.fetchPosts()
    }
}