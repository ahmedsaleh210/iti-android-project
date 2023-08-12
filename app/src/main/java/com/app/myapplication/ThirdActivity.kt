package com.app.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.app.myapplication.Utils.ApiInterface
import com.app.myapplication.Utils.RetrofitClient
import com.app.myapplication.databinding.ActivityThirdBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val postId = intent.getIntExtra("postId",0)

        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)

        lifecycleScope.launch() {
            try{
                val response = apiInterface.getCommentsByPostId(postId)
                if(response.isSuccessful){
                    val comments = response.body()
                    binding.commentsRecyclerview.adapter = CommentCustomAdapter(response.body() ?: listOf())
                }
            }
            catch (error:Exception){
                Log.d("Error Said",error.toString())
                Toast.makeText(this@ThirdActivity, error.toString(), Toast.LENGTH_SHORT).show()

            }
        }

    }
}