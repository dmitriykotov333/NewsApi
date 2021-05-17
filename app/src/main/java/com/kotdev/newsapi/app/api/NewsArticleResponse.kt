package com.kotdev.newsapi.app.api

data class NewsArticleResponse(
    val title: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String?,
    val author: String?,
    val description: String?
)