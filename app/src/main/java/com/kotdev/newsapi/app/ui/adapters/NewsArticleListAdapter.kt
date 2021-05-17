package com.kotdev.newsapi.app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kotdev.newsapi.app.data.NewsArticle
import com.kotdev.newsapi.databinding.ItemNewsArticleBinding
import com.kotdev.newsapi.databinding.ItemNewsArticleNullBinding

class NewsArticleListAdapter(
    private val onItemClick: (NewsArticle) -> Unit,
    private val onBookmarkClick: (NewsArticle) -> Unit,
) : ListAdapter<NewsArticle, RecyclerView.ViewHolder>(DiffUtilNews()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> {
                val binding =
                    ItemNewsArticleNullBinding.inflate(LayoutInflater.from(parent.context),
                        parent,
                        false)
                return NewsArticleViewHolderNull(binding,
                    onItemClick = { position ->
                        val article = getItem(position)
                        if (article != null) {
                            onItemClick(article)
                        }
                    },
                    onBookmarkClick = { position ->
                        val article = getItem(position)
                        if (article != null) {
                            onBookmarkClick(article)
                        }
                    }
                )
            }
            1 -> {
                val binding =
                    ItemNewsArticleBinding.inflate(LayoutInflater.from(parent.context),
                        parent,
                        false)
                return NewsArticleViewHolder(binding,
                    onItemClick = { position ->
                        val article = getItem(position)
                        if (article != null) {
                            onItemClick(article)
                        }
                    },
                    onBookmarkClick = { position ->
                        val article = getItem(position)
                        if (article != null) {
                            onBookmarkClick(article)
                        }
                    }
                )
            }
            else -> {
                val binding =
                    ItemNewsArticleBinding.inflate(LayoutInflater.from(parent.context),
                        parent,
                        false)
                return NewsArticleViewHolder(binding,
                    onItemClick = { position ->
                        val article = getItem(position)
                        if (article != null) {
                            onItemClick(article)
                        }
                    },
                    onBookmarkClick = { position ->
                        val article = getItem(position)
                        if (article != null) {
                            onBookmarkClick(article)
                        }
                    }
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).description.isNullOrEmpty()) {
            0
        } else {
            1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = getItem(position)
        when (holder) {
            is NewsArticleViewHolder -> {
                if (currentItem != null) {
                    holder.bind(currentItem)
                }
            }
            is NewsArticleViewHolderNull -> {
                if (currentItem != null) {
                    holder.bind(currentItem)
                }
            }
        }
    }
}