package com.lazamelezi.simplenewsapp.ui.simplenewsui

import com.lazamelezi.simplenews.data.Result
import com.lazamelezi.simplenews.data.response.NewsArticle


data class ArticleListUiState(
    val isLoading: Boolean = true,
    val list: List<NewsArticle>? = emptyList(),
    val error: Result.Error? = null
)
