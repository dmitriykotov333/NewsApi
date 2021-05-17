package com.kotdev.newsapi.app.ui.adapters


import androidx.recyclerview.widget.DiffUtil
import com.kotdev.newsapi.app.data.NewsArticle

class DiffUtilNews : DiffUtil.ItemCallback<NewsArticle>() {

    override fun areItemsTheSame(oldItem: NewsArticle, newItem: NewsArticle) =
        oldItem.url == newItem.url

    override fun areContentsTheSame(oldItem: NewsArticle, newItem: NewsArticle) =
        oldItem == newItem
}