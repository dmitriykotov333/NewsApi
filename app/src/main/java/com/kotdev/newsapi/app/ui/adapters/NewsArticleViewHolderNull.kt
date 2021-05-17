package com.kotdev.newsapi.app.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotdev.newsapi.R
import com.kotdev.newsapi.app.data.NewsArticle
import com.kotdev.newsapi.databinding.ItemNewsArticleBinding
import com.kotdev.newsapi.databinding.ItemNewsArticleNullBinding

class NewsArticleViewHolderNull(
    private val binding: ItemNewsArticleNullBinding,
    private val onItemClick: (Int) -> Unit,
    private val onBookmarkClick: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: NewsArticle) {
        binding.apply {

            textViewTitle.text = article.title ?: ""
            textViewAuthor.text = article.author ?: ""
            textViewDate.text = article.publishedAt ?: ""

            imageViewBookmark.setImageResource(
                when {
                    article.isBookmarked -> R.drawable.ic_bookmark_selected_null
                    else -> R.drawable.ic_bookmark_unselected_null
                }
            )
        }
    }

    init {
        binding.apply {
            root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(position)
                }
            }
            imageViewBookmark.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onBookmarkClick(position)
                }
            }
        }
    }
}