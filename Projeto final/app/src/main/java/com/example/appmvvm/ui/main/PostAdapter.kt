package com.example.appmvvm.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appmvvm.data.model.Post
import com.example.appmvvm.databinding.ItemPostBinding

class PostAdapter(
    private val list: List<Post>,
    private val onClick: (Post) -> Unit
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPostBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = list[position]
        holder.binding.txtTitle.text = post.title
        holder.binding.root.setOnClickListener { onClick(post) }
    }

    override fun getItemCount() = list.size
}