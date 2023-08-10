package com.app.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.app.myapplication.databinding.PostItemBinding
import com.app.myapplication.models.User
import com.squareup.picasso.Picasso

class PostCustomAdapter(var userList: List<User>, var listener: PostCustomClickListener): RecyclerView.Adapter<PostCustomAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: PostItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.personTextview.text = "${userList[position].firstName} ${userList[position].lastName}"
        holder.binding.dateTextview.text = "${userList[position].id}"
        holder.binding.contentTextview.text = userList[position].email

        if (userList[position].avatar.isNotEmpty()){
            Picasso.get()
                .load(userList[position].avatar)
                .resize(140, 100)
                .centerCrop()
                .into(holder.binding.personImageView)
        }
//
//        holder.binding.viewDetailsButton.setOnClickListener {
//            listener.onItemClickListener(userList[position], position)
//        }

    }
}