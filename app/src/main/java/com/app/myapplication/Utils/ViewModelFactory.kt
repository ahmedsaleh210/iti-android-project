package com.app.myapplication.Utils
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.myapplication.Ui.login.LoginViewModel
import com.app.myapplication.Ui.second.PostViewModel
import com.app.myapplication.core.repo.LoginRepository
import com.app.myapplication.core.repo.PostRepository



class ViewModelFactory(private val loginRepository: LoginRepository? = null, private val postRepository: PostRepository? = null) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                if (loginRepository == null) {
                    throw IllegalArgumentException("LoginRepository must be provided")
                }
                LoginViewModel(loginRepository) as T
            }
            modelClass.isAssignableFrom(PostViewModel::class.java) -> {
                if (postRepository == null) {
                    throw IllegalArgumentException("PostRepository must be provided")
                }
                PostViewModel(postRepository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}



