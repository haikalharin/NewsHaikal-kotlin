package com.example.haikalharin.newsDB.Entity

import com.google.gson.annotations.SerializedName

class News(@field:SerializedName("urlToImage") var imgNews: String, @field:SerializedName("title") var titleNews: String, @field:SerializedName("publishedAt") var dateNews: String, @field:SerializedName("author") var authorNews: String, @field:SerializedName("description") var contentNews: String, @field:SerializedName("url") var sourceNews: String)