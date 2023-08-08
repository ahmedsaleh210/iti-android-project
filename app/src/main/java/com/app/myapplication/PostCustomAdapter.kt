package com.app.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.app.myapplication.databinding.PostItemBinding
import com.squareup.picasso.Picasso

class PostCustomAdapter(var postsList: ArrayList<Post>, var listener: PostCustomClickListener): RecyclerView.Adapter<PostCustomAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: PostItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.personTextview.text = postsList[position].userName
        holder.binding.dateTextview.text = "${postsList[position].postDate.day} / ${postsList[position].postDate.month} / ${postsList[position].postDate.year}"
        holder.binding.contentTextview.text = postsList[position].postContent

        if (postsList[position].userImage.isNotEmpty()){
            Picasso.get()
                .load(postsList[position].userImage)
                .resize(140, 100)
                .centerCrop()
                .into(holder.binding.personImageView)
        }

        holder.binding.viewDetailsButton.setOnClickListener {
            listener.onItemClickListener(postsList[position], position)
        }

    }
}