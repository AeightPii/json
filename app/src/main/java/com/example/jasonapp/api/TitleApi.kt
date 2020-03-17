package com.example.jasonapp.api
import com.example.jasonapp.model.Title
import retrofit2.Call
import retrofit2.http.GET

interface TitleApi {
    @GET("/posts/")
    fun getTitle(): Call<List<Title>>
}