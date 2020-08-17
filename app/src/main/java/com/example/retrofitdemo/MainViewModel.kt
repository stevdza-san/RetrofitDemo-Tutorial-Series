package com.example.retrofitdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittest.model.Post
import com.example.retrofitdemo.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    var myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    var myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    var myCustomPosts2: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun pushPost(post: Post) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }

    fun pushPost2(userId: Int, id: Int, title: String, body: String) {
        viewModelScope.launch {
            val response = repository.pushPost2(userId, id, title, body)
            myResponse.value = response
        }
    }

    fun getPost(auth: String){
        viewModelScope.launch {
            val response = repository.getPost(auth)
            myResponse.value = response
        }
    }
    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }
    fun getCustomPosts(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId, sort, order)
            myCustomPosts.value = response
        }
    }

    fun getCustomPosts2(userId: Int, options: Map<String, String>) {
        viewModelScope.launch {
            val response = repository.getCustomPosts2(userId, options)
            myCustomPosts2.value = response
        }
    }

}