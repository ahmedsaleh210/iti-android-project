package com.app.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.myapplication.databinding.ActivityThirdBinding
import com.squareup.picasso.Picasso

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra("userName")
        val userImage = intent.getStringExtra("userImage")
        val postContent = intent.getStringExtra("postContent")

        binding.userNameTextview.text = userName
        binding.postContentTextview.text = postContent

        if (userImage!!.isNotEmpty()){
            Picasso.get()
                .load(userImage)
                .resize(140, 100)
                .centerCrop()
                .into(binding.userImageImview)
        }
    }
}