package com.example.haikalharin.newsDB.API

import com.example.haikalharin.newsDB.API.RetrofitApi.getClient

object Server {
    const val URL_API = "https://newsapi.org/"
    val apiService: ApiService
        get() = getClient(URL_API)!!.create(ApiService::class.java)
}